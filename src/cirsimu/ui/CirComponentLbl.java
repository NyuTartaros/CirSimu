package cirsimu.ui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cirsimu.entity.CirComponent;

public class CirComponentLbl extends JLabel {

	private CirComponent cirComponent;
	
	public CirComponentLbl(){
		
	}
	
	public CirComponentLbl(CirComponent cirComponent){
		this.cirComponent = cirComponent;
		setIcon(new ImageIcon("./icons/"+cirComponent.getType()+".png"));
		int width = getIcon().getIconWidth();
		int height = getIcon().getIconHeight();
		int x = cirComponent.getx();
		int y = cirComponent.gety();
		setBounds(x, y, width, height);
	}
	
	public void setComponent(CirComponent cirComponent){
		if(cirComponent == null){
			setIcon(null);
			setBounds(0, 0, 0, 0);
			return;
		}
		this.cirComponent = cirComponent;
		setIcon(new ImageIcon("./icons/"+cirComponent.getType()+".png"));
		int width = getIcon().getIconWidth();
		int height = getIcon().getIconHeight();
		int x = cirComponent.getx();
		int y = cirComponent.gety();
		setBounds(x, y, width, height);
	}
	
}
