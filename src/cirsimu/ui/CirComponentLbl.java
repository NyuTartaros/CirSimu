package cirsimu.ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cirsimu.entity.CirComponent;

public class CirComponentLbl extends JLabel {

	private CirComponent cirComponent;
	
	public CirComponentLbl(CirComponent cirComponent){
		this.cirComponent = cirComponent;
		setIcon(new ImageIcon("./icons/"+cirComponent.getType()+".png"));
	}
}
