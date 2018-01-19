package cirsimu.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import cirsimu.entity.CirComponent;
import cirsimu.entity.CirComponentList;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class DrawArea extends JPanel {
	private CirComponentList cirComponentList = new CirComponentList();
	private CirComponentLbl tmpLbl = new CirComponentLbl();	//拖动编辑时用于预览的临时组件label
	private static final int WAITING = 0;
	private static final int EDITING = 1;
	private static final int LINKING = 2;
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
					case LINKING:
						
						break;
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
		status = LINKING;
	}
	
	public void stopLinking(){
		status = WAITING;
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
	
}
