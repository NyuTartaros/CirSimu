package cirsimu.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import cirsimu.entity.CirComponent;
import cirsimu.entity.CirComponentList;

public class DrawArea extends JPanel {
	private CirComponentList cirComponentList;
	private CirComponentLbl tmpLbl;	//�϶��༭ʱ����Ԥ������ʱ���label
	private int status = 0;
	private static final int WAITING = 0;
	private static final int EDITING = 1;
	private static final int LINKING = 2;
	
	//TODO ����ʵ��Ԫ�����ú��϶�����
	
	public DrawArea(){
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
	
}
