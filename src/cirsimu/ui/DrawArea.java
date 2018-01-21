package cirsimu.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import cirsimu.entity.CirComponent;
import cirsimu.entity.CirComponentList;
import cirsimu.entity.Point;

import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.Array;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class DrawArea extends JPanel {
	private CirComponentList cirComponentList = new CirComponentList();
	private CirComponentLbl tmpLbl = new CirComponentLbl();	
			//�϶��༭ʱ����Ԥ������ʱ���label
	private int[] tmpInterfaceA;	//����ʱ��¼����ʱ�ӿ�
	private int[] tmpInterfaceB;	//����ʱ��¼����ʱ�ӿ�
	private int status = WAITING;
	private String currentComponent = "";
	
	private static final int WAITING = 0;
	private static final int EDITING = 1;
	private static final int LINKING_A = 2;
	private static final int LINKING_B = 3;
	public static final int delta = 5;	//�ӿڵ�������
	
	//TODO ����Ԫ���زģ�����Ԫ��ͼƬ�ߴ�һ��
	//TODO ����ఴť���ͼ��
	//TODO ʵ��Ԫ���Ҽ��˵�
	//TODO ʵ��Ԫ���϶�����
	
	public DrawArea(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//�����������õ�ǰ���
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
						//DEBUG
						System.out.println("DrawArea.click_LINKING_A: "
								+ "x=" + e.getX() + ", " + "y=" + e.getY());
						if(tmpResultA == null){
							JOptionPane.showMessageDialog(getParent()
									, "δ����κνӿ�.");
							stopLinking();
							return;
						}
						tmpInterfaceA = tmpResultA;
						//DEBUG
//						System.out.println("clickAt: " + tmpResultA[0]
//								+ "," + tmpResultA[1]);
						System.out.println("clickAt: " + tmpInterfaceA[0]
								+ "," + tmpInterfaceA[1]);
						startLinking_B();
						paint(getGraphics());
						return;
					case LINKING_B:
						int[] tmpResultB = clickInComp(e.getX(), e.getY());
						if(tmpResultB == null){
							JOptionPane.showMessageDialog(getParent()
									, "δ����κνӿ�.");
							startLinking_B();
							return;
						}else if (Arrays.equals(tmpResultB, tmpInterfaceA)) {
							JOptionPane.showMessageDialog(getParent()
									, "�ӿڲ��������Լ�.");
							startLinking_B();
							return;
						}
						tmpInterfaceB = tmpResultB;
						setlink(tmpInterfaceA, tmpInterfaceB);
						//DEBUG
						System.out.println("tmpInterfaceA: "
								+ "comp=" + tmpInterfaceA[0] + ", "
								+ "inter=" + tmpInterfaceA[1]);
						System.out.println("tmpInterfaceB: "
								+ "comp=" + tmpInterfaceB[0] + ", "
								+ "inter=" + tmpInterfaceB[1]);
						stopLinking();
						paint(getGraphics());
						return;
					case WAITING:
						return;
					}
				}
				//��סCtrl��������ȡ����ǰ�༭������
				if(e.isControlDown() && e.getButton()==MouseEvent.BUTTON1){
					//DEBUG
//					System.out.println("At DrawArea.mouseClicked(): ControlDown.");
					stopEditing();
					stopLinking();
					return;
				}
				//�Ҽ�����������Ҽ��˵�
				if(e.getButton()==MouseEvent.BUTTON3) {
					switch (status) {
					case WAITING:
						int[] compNoNinterNo = clickInComp(e.getX(), e.getY());
						//DEBUG
						System.out.println(compNoNinterNo.length);
						System.out.println(""+compNoNinterNo[0]+compNoNinterNo[1]);
						int compNo = compNoNinterNo[0];
						RightMenu rightMenu = new RightMenu((DrawArea)e.getComponent(), cirComponentList.get(compNo));
						rightMenu.show(e.getComponent(), e.getX(), e.getY());
						return;
					default:
						return;
					}
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
	
	//��дpaint()����
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
			drawInterfaces(g);
			drawInterfaces_B(g);
		}
	}
	
	private void drawLink(Graphics g){
		ArrayList<CirComponent> cirComponents
				= cirComponentList.getArrayList();
		g.setColor(Color.BLACK);
		for(int i=0; i<cirComponents.size(); i++){
			CirComponent comp = cirComponents.get(i);
			HashMap<Integer,Integer> neighCompTable = comp.getNeighCompTable();
			HashMap<Integer,Integer> neighInterTable = comp.getNeighInterTable();
			//DEBUG
//			System.out.println("componentNo." + i);
//			System.out.println("neighCompTable:");
//			for(Integer key : neighCompTable.keySet()){
//				System.out.println("key=" + key + ", " 
//						+ "value=" + neighCompTable.get(key));
//			}
//			System.out.println("neighInterTable:");
//			for(Integer key : neighInterTable.keySet()){
//				System.out.println("key=" + key + ", " 
//						+ "value=" + neighInterTable.get(key));
//			}
			for(Integer aInter : neighCompTable.keySet()){
				Integer aComp = i;
				Integer bComp = neighCompTable.get(aInter);
				Integer bInter = neighInterTable.get(aInter);
				Point aPoint = comp.getInterfaceLoc(aInter);
				Point bPoint = cirComponents.get(bComp).getInterfaceLoc(bInter);
				Point[] linkPath = getLinkPath(aPoint, bPoint);
				for(int j=0; j<linkPath.length-1; j++){
					Point prev = linkPath[j];
					Point next = linkPath[j+1];
					g.drawLine(prev.getX(), prev.getY(), next.getX(), next.getY());
				}
			}
		}
	}
	
	private void drawInterfaces(Graphics g){
		ArrayList<CirComponent> cirComponents
				= cirComponentList.getArrayList();
		g.setColor(Color.GREEN);
		for(int i=0; i<cirComponents.size(); i++){
			CirComponent tmpComp = cirComponents.get(i);
			Point[] interLocs = tmpComp.getInterfaceLocs();
			for(int j=0; j<interLocs.length; j++){
				int x = interLocs[j].getX();
				int y = interLocs[j].getY();
				g.drawRect(x-delta, y-delta, 2*delta, 2*delta);
			}
		}
	}
	
	private void drawInterfaces_B(Graphics g){
		ArrayList<CirComponent> cirComponents
				= cirComponentList.getArrayList();
		g.setColor(Color.RED);
		int comp = tmpInterfaceA[0];
		int inter = tmpInterfaceA[1];
		//DEBUG
//		System.out.println("comp=" + comp + ", " + "inter=" + inter);
		Point interLoc = cirComponents.get(comp).getInterfaceLoc(inter);
		int x = interLoc.getX();
		int y = interLoc.getY();
		//DEBUG
//		System.out.println("x=" + x + ", " + "y=" + y);
		g.drawRect(x-delta, y-delta, 2*delta, 2*delta);
	}
	
	private Point[] getLinkPath(Point aPoint, Point bPoint){
		Point a;
		Point b;
		if(aPoint.getX() == bPoint.getX() || aPoint.getY() == bPoint.getY()){
			Point[] result = {aPoint, bPoint};
			return result;
		}
		if(aPoint.getX() < bPoint.getX()){
			a = aPoint;
			b = bPoint;
		}else{
			a = bPoint;
			b = aPoint;
		}
		Point c;
		c = new Point(a.getX(), b.getY());
		Point[] result = {a, c, b};
		return result;
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
		paint(getGraphics());
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
		paint(getGraphics());
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
		cirComponentList.setlink(interA[0], interA[1]
				, interB[0], interB[1]);
	}
	
	//DEBUG
	public void isDrawArea() {
		System.out.println("It's drawArea.");
		System.out.println("CompList.size()=" + cirComponentList.size());
	}
	
}
