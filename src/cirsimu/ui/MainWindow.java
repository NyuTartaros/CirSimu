package cirsimu.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.ImageIcon;

public class MainWindow extends JFrame {
	
	private JPanel componentBtnBar = new JPanel();
	
	public MainWindow() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u7535\u8DEF\u7F16\u8F91\u4EFF\u771F");
		setLocationRelativeTo(null);
		setSize(1000,800);
		
		getContentPane().add(componentBtnBar, BorderLayout.WEST);
		
		JToolBar componentToolBar_1 = new JToolBar();
		componentToolBar_1.setFloatable(false);
		componentToolBar_1.setOrientation(SwingConstants.VERTICAL);
		componentBtnBar.add(componentToolBar_1);
		
		JButton voltmeterBtn = new JButton("");
		voltmeterBtn.setIcon(new ImageIcon("F:\\GitHubCirSimu\\icons\\voltmeter.png"));
		voltmeterBtn.setToolTipText("\u7535\u538B\u8868");
		componentToolBar_1.add(voltmeterBtn);
		
		JButton resistanceBtn = new JButton("");
		resistanceBtn.setIcon(new ImageIcon("F:\\GitHubCirSimu\\icons\\resistance.png"));
		resistanceBtn.setToolTipText("\u7535\u963B");
		componentToolBar_1.add(resistanceBtn);
		
		JButton diodeBtn = new JButton("");
		diodeBtn.setIcon(new ImageIcon("F:\\GitHubCirSimu\\icons\\diode.png"));
		diodeBtn.setToolTipText("\u4E8C\u6781\u7BA1");
		componentToolBar_1.add(diodeBtn);
		
		JButton voltageSourceBtn = new JButton("");
		voltageSourceBtn.setToolTipText("\u7535\u538B\u6E90");
		componentToolBar_1.add(voltageSourceBtn);
		
		JButton groundConnBtn = new JButton("");
		groundConnBtn.setToolTipText("\u63A5\u5730");
		componentToolBar_1.add(groundConnBtn);
		
		JButton inductanceBtn = new JButton("");
		inductanceBtn.setToolTipText("\u7535\u611F");
		componentToolBar_1.add(inductanceBtn);
		
		JToolBar componentToolBar_2 = new JToolBar();
		componentToolBar_2.setOrientation(SwingConstants.VERTICAL);
		componentToolBar_2.setFloatable(false);
		componentBtnBar.add(componentToolBar_2);
		
		JButton amperemeterBtn = new JButton("");
		amperemeterBtn.setIcon(new ImageIcon("F:\\GitHubCirSimu\\icons\\amperemeter.png"));
		amperemeterBtn.setToolTipText("\u7535\u6D41\u8868");
		componentToolBar_2.add(amperemeterBtn);
		
		JButton capicititanceBtn = new JButton("");
		capicititanceBtn.setIcon(new ImageIcon("F:\\GitHubCirSimu\\icons\\capicititance.png"));
		capicititanceBtn.setToolTipText("\u7535\u5BB9");
		componentToolBar_2.add(capicititanceBtn);
		
		JButton amplifierBtn = new JButton("");
		amplifierBtn.setIcon(new ImageIcon("F:\\GitHubCirSimu\\icons\\amplifier.png"));
		amplifierBtn.setToolTipText("\u8FD0\u7B97\u653E\u5927\u5668");
		componentToolBar_2.add(amplifierBtn);
		
		JButton currentSourceBtn = new JButton("");
		currentSourceBtn.setToolTipText("\u7535\u6D41\u6E90");
		componentToolBar_2.add(currentSourceBtn);
		
		JButton switchBtn = new JButton("");
		switchBtn.setToolTipText("\u5F00\u5173");
		componentToolBar_2.add(switchBtn);
		
		JButton wireBtn = new JButton("");
		wireBtn.setToolTipText("\u5BFC\u7EBF");
		componentToolBar_2.add(wireBtn);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(fileMenu);
		
		JMenuItem openMenuItem = new JMenuItem("\u6253\u5F00");
		fileMenu.add(openMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("\u4FDD\u5B58");
		fileMenu.add(saveMenuItem);
		
		JMenu editMenu = new JMenu("\u7F16\u8F91");
		menuBar.add(editMenu);
	}

}
