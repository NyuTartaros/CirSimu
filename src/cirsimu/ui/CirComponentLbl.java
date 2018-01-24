package cirsimu.ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cirsimu.entity.CirComponent;

public class CirComponentLbl extends JLabel {

	private CirComponent cirComponent;
	
	public CirComponentLbl(){
		
	}
	
	public CirComponentLbl(CirComponent cirComponent){
		setComponent(cirComponent);
	}
	
	public void setComponent(CirComponent cirComponent){
		if(cirComponent == null){
			setIcon(null);
			setBounds(0, 0, 0, 0);
			return;
		}
		this.cirComponent = cirComponent;
		switch(cirComponent.getRotateCount()) {
		case 0:
			setIcon(new ImageIcon("./icons/"+cirComponent.getType()+".png"));
			break;
		case 1:
			setIcon(new ImageIcon("./icons/"+cirComponent.getType()+"1"+".png"));
			break;
		case 2:
			setIcon(new ImageIcon("./icons/"+cirComponent.getType()+"2"+".png"));
			break;
		case 3:
			setIcon(new ImageIcon("./icons/"+cirComponent.getType()+"3"+".png"));
			break;
		}
		int width = getIcon().getIconWidth();
		int height = getIcon().getIconHeight();
		int x = cirComponent.getx();
		int y = cirComponent.gety();
		setBounds(x, y, width, height);
	}
	
}
