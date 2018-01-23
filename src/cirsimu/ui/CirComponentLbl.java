package cirsimu.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cirsimu.entity.CirComponent;
import cirsimu.util.ImageUtil;
import cirsimu.util.ImageUtils2;

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
			try {
				BufferedImage iconImage;
				iconImage = ImageIO.read(new File("./icons/"+cirComponent.getType()+".png"));
				ImageIcon icon = new ImageIcon(ImageUtil.imageToBytes(iconImage, "jpg"));
				setIcon(icon);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				BufferedImage iconImage;
				iconImage = ImageIO.read(new File("./icons/"+cirComponent.getType()+".png"));
				iconImage = ImageUtils2.rotateClockwise90(iconImage);
				ImageIcon icon = new ImageIcon(ImageUtil.imageToBytes(iconImage, "jpg"));
				setIcon(icon);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				BufferedImage iconImage;
				iconImage = ImageIO.read(new File("./icons/"+cirComponent.getType()+".png"));
				iconImage = ImageUtils2.rotate180(iconImage);
				ImageIcon icon = new ImageIcon(ImageUtil.imageToBytes(iconImage, "jpg"));
				setIcon(icon);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				BufferedImage iconImage;
				iconImage = ImageIO.read(new File("./icons/"+cirComponent.getType()+".png"));
				iconImage = ImageUtils2.rotate180(iconImage);
				iconImage = ImageUtils2.rotateClockwise90(iconImage);
				ImageIcon icon = new ImageIcon(ImageUtil.imageToBytes(iconImage, "jpg"));
				setIcon(icon);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		int width = getIcon().getIconWidth();
		int height = getIcon().getIconHeight();
		int x = cirComponent.getx();
		int y = cirComponent.gety();
		setBounds(x, y, width, height);
	}
	
}
