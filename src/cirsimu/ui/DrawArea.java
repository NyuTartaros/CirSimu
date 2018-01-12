package cirsimu.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import cirsimu.entity.CirComponent;
import cirsimu.entity.CirComponentList;

public class DrawArea extends JPanel {
	private CirComponentList cirComponentList;
	private CirComponentLbl tmpLbl;	//拖动编辑时用于预览的临时组件label
	private int status = 0;
	private static final int WAITING = 0;
	private static final int EDITING = 1;
	private static final int LINKING = 2;
	
	//TODO 首先实现元件放置和拖动功能
	
	public DrawArea(){
		setVisible(true);
		setBackground(Color.WHITE);
	}
	
	//TODO 重写paint()方法
	public void paint(Graphics g){
		super.paint(g);
		ArrayList<CirComponent> cirComponents 
			= cirComponentList.getArrayList();
		for(int i=0; i<cirComponents.size(); i++){
			add(new CirComponentLbl(cirComponents.get(i)));
		}
	}
	
}
