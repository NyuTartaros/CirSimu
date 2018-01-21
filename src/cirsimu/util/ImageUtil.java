package cirsimu.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	/**
	* ת��BufferedImage ����Ϊbyte����
	* 
	* @param image
	* Image����
	* @param format
	* image��ʽ�ַ���.��"gif","png"
	* @return byte����
	*/
	public static byte[] imageToBytes(BufferedImage bImage, String format) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(bImage, format, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toByteArray();
	}
	
	/**
	* ת��byte����ΪImage
	* 
	* @param bytes
	* @return Image
	*/
	public static Image bytesToImage(byte[] bytes) {
		Image image = Toolkit.getDefaultToolkit().createImage(bytes);
		try {
			MediaTracker mt = new MediaTracker(new Label());
			mt.addImage(image, 0);
			mt.waitForAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return image;
	}
}