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
	private CirComponentLbl tmpLbl = new CirComponentLbl();	//�϶��༭ʱ����Ԥ������ʱ���label
	private static final int WAITING = 0;
	private static final int EDITING = 1;
	private static final int LINKING = 2;
	private int status = WAITING;
	private String currentComponent = "";
	
	//TODO ����ʵ��Ԫ�����ú��϶�����
	
	public DrawArea(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//�����������õ�ǰ���
				if(!e.isControlDown() && e.getButton() == e.BUTTON1){
					if(isWaiting()){
						return;
					}
					CirComponent tmpComponent = new CirComponent
							(currentComponent, e.getX(), e.getY());
					cirComponentList.add(tmpComponent);
					stopEditing();
					stopLinking();
					paint(getGraphics());
					return;
				}
				//��סCtrl��������ȡ����ǰ�༭������
				if(e.isControlDown() && e.getButton()==e.BUTTON1){
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
				if(status == WAITING){
					return;
				}
				CirComponent tmpComponent = new CirComponent
						(currentComponent, e.getX(), e.getY());
				tmpLbl.setComponent(tmpComponent);
			}
		});
		setVisible(true);
		setBackground(Color.WHITE);
	}
	
	//TODO ��дpaint()����
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
	
}
