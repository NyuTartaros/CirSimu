package cirsimu.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cirsimu.ui.MainWindow;

public class CirSimu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException 
				| InstantiationException 
				| IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow mainWindow = new MainWindow();
	}

}
