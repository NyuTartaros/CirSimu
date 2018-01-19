package cirsimu.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cirsimu.entity.CirComponent;
import cirsimu.entity.CirComponentList;
import cirsimu.entity.Point;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class DrawArea extends JPanel {
	private CirComponentList cirComponentList = new CirComponentList();
	private CirComponentLbl tmpLbl = new CirComponentLbl();	
			//拖动编辑时用于预览的临时组件label
	private int[] tmpInterfaceA;	//连线时记录的临时接口
	private int[] tmpInterfaceB;	//连线时记录的临时接口
	private static final int WAITING = 0;
	private static final int EDITING = 1;
	private static final int LINKING_A = 2;
	private static final int LINKING_B = 3;
	private int status = WAITING;
	private String currentComponent = "";
	
	//TODO 实现元件拖动功能
	//TODO 实现元件右键菜单
	
	public DrawArea(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//左键点击：放置当前组件
				if(!e.isControlDown() && e.getButton() == MouseEvent.BUTTON1){
					switch(status){
					case EDITING:
						CirComponent tmpComponent = new CirComponent
								(currentComponent, e.getX(), e.getY());
						cirComponentList.add(tmpComponent);
						stopEditing();
						paint(getGraphics());
						return;
					case LINKING_A:
						int[] tmpResultA = clickInComp(e.getX(), e.getY());
						if(tmpResultA == null){
							JOptionPane.showMessageDialog(getParent()
									, "未点击任何接口.");
							stopLinking();
							return;
						}
						tmpInterfaceA = tmpResultA;
						startLinking_B();
						return;
					case LINKING_B:
						int[] tmpResultB = clickInComp(e.getX(), e.getY());
						if(tmpResultB == null){
							JOptionPane.showMessageDialog(getParent()
									, "未点击任何接口.");
							startLinking_B();
							return;
						}else if (tmpResultB.equals(tmpInterfaceA)) {
							JOptionPane.showMessageDialog(getParent()
									, "接口不能连接自己.");
							startLinking_B();
							return;
						}
						tmpInterfaceB = tmpResultB;
						setlink(tmpInterfaceA, tmpInterfaceB);
						return;
					case WAITING:
						return;
					}
					if(isWaiting()){
						return;
					}

				}
				//按住Ctrl左键点击：取消当前编辑或连接
				if(e.isControlDown() && e.getButton()==MouseEvent.BUTTON1){
					//DEBUG
//					System.out.println("At DrawArea.mouseClicked(): ControlDown.");
					stopEditing();
					stopLinking();
					return;
				}
			}
		});
		setLayout(null);
		tmpLbl.setBounds(225, 5, 0, 0);
		add(tmpLbl);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				switch(status){
				case EDITING:
					CirComponent tmpComponent = new CirComponent
							(currentComponent, e.getX(), e.getY());
					tmpLbl.setComponent(tmpComponent);
					return;
				case LINKING_A:	//TODO
					
					return;
				case LINKING_B:	//TODO
					
					return;
				case WAITING:
					return;
				}
			}
		});
		setVisible(true);
		setBackground(Color.WHITE);
	}
	
	//重写paint()方法
	public void paint(Graphics g){
		super.paint(g);
		ArrayList<CirComponent> cirComponents 
				= cirComponentList.getArrayList();
		for(int i=0; i<cirComponents.size(); i++){
			add(new CirComponentLbl(cirComponents.get(i)));
		}
		drawLink(g);
		if(isLinking_A()){
			drawInterfaces(g);
		}else if (isLinking_B()) {
			drawInterfaces_B(g);
		}
	}
	
	private void drawLink(Graphics g){
		ArrayList<CirComponent> cirComponents
				= cirComponentList.getArrayList();
		g.setColor(Color.BLACK);
		
	}
	
	private void drawInterfaces(Graphics g){
		ArrayList<CirComponent> cirComponents
				= cirComponentList.getArrayList();
		g.setColor(Color.GREEN);
		for(int i=0; i<cirComponents.size(); i++){
			int delta = 5;	//接口方框半边长
			CirComponent tmpComp = cirComponents.get(i);
			Point[] interLocs = tmpComp.getInterfaceLocs();
			for(int j=0; j<interLocs.length; j++){
				int x = interLocs[j].getX();
				int y = interLocs[j].getY();
				g.drawLine(x-delta, y-delta, x-delta, y+delta);
				g.drawLine(x-delta, y+delta, x+delta, y+delta);
				g.drawLine(x+delta, y+delta, x+delta, y-delta);
				g.drawLine(x+delta, y-delta, x-delta, y-delta);
			}
		}
	}
	
	private void drawInterfaces_B(Graphics g){
		int delta = 5;	//接口方框半边长
		ArrayList<CirComponent> cirComponents
				= cirComponentList.getArrayList();
		g.setColor(Color.RED);
		int comp = tmpInterfaceA[0];
		int inter = tmpInterfaceA[1];
		Point interLoc = cirComponents.get(comp).getInterfaceLoc(inter);
		int x = interLoc.getX();
		int y = interLoc.getY();
		g.drawLine(x-delta, y-delta, x-delta, y+delta);
		g.drawLine(x-delta, y+delta, x+delta, y+delta);
		g.drawLine(x+delta, y+delta, x+delta, y-delta);
		g.drawLine(x+delta, y-delta, x-delta, y-delta);
	}
	
	public void startEditing(String componentType){
		status = EDITING;
		currentComponent = componentType;
	}
	
	public void stopEditing(){
		status = WAITING;
		currentComponent = "";
		tmpLbl.setComponent(null);
	}
	
	public void startLinking(){
		status = LINKING_A;
	}
	
	public boolean isLinking_A(){
		if(status == LINKING_A){
			return true;
		}else{
			return false;
		}
	}
	
	private void startLinking_B(){
		status = LINKING_B;
	}
	
	public boolean isLinking_B(){
		if(status == LINKING_B){
			return true;
		}else{
			return false;
		}
	}
	
	public void stopLinking(){
		status = WAITING;
		tmpInterfaceA = null;
		tmpInterfaceB = null;
	}
	
	public boolean isWaiting(){
		if(status == WAITING){
			return true;
		}else{
			return false;
		}
	}
	
	public CirComponentList getComponentList(){
		return cirComponentList;
	}
	
	public void newGraph() {
		cirComponentList = new CirComponentList();
		paint(getGraphics());
	}
	
	private int[] clickInComp(int x, int y){
		return cirComponentList.pointInComp(x, y);
	}
	
	private void setlink(int[] interA, int[] interB){
		cirComponentList.setlink(interA[0], interB[1]
				, interB[0], interB[1]);
	}
	
}
