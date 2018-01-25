package cirsimu.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cirsimu.ui.MainWindow;

public class CirSimu {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException 
				| InstantiationException 
				| IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		MainWindow mainWindow = new MainWindow();
	}

}
