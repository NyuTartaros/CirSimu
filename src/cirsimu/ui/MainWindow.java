package cirsimu.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cirsimu.util.FileHelper;

import javax.swing.JToolBar;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainWindow extends JFrame {
	
	private JPanel componentBtnBar = new JPanel();
	private JToolBar componentToolBar_1;
	private JButton voltmeterBtn;
	private JButton resistanceBtn;
	private JButton diodeBtn;
	private JButton voltageSourceBtn;
	private JButton groundConnBtn;
	private JButton inductanceBtn;
	private JToolBar componentToolBar_2;
	private JButton amperemeterBtn;
	private JButton capicititanceBtn;
	private JButton amplifierBtn;
	private JButton currentSourceBtn;
	private JButton switchBtn;
	private JButton wireBtn;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem openMenuItem;
	private JMenuItem saveMenuItem;
	private JMenu editMenu;
	private DrawArea drawArea;
	private JMenuItem reportMenuItem;
	
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\GitHub\\CirSimu\\icons\\icon.png"));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u7535\u8DEF\u7F16\u8F91\u4EFF\u771F");
		setLocationRelativeTo(null);
		setSize(1000,800);
		
		getContentPane().add(componentBtnBar, BorderLayout.WEST);
		
		componentToolBar_1 = new JToolBar();
		componentToolBar_1.setFloatable(false);
		componentToolBar_1.setOrientation(SwingConstants.VERTICAL);
		componentBtnBar.add(componentToolBar_1);
		
		voltmeterBtn = new JButton("\u7535\u538B\u8868");
		voltmeterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drawArea.startEditing("voltmeter");
			}
		});
		voltmeterBtn.setIcon(null);
		voltmeterBtn.setToolTipText("\u7535\u538B\u8868");
		componentToolBar_1.add(voltmeterBtn);
		
		resistanceBtn = new JButton("\u7535\u963B");
		resistanceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing("resistance");
			}
		});
		resistanceBtn.setIcon(null);
		resistanceBtn.setToolTipText("\u7535\u963B");
		componentToolBar_1.add(resistanceBtn);
		
		diodeBtn = new JButton("\u4E8C\u6781\u7BA1");
		diodeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing("diode");
			}
		});
		diodeBtn.setIcon(null);
		diodeBtn.setToolTipText("\u4E8C\u6781\u7BA1");
		componentToolBar_1.add(diodeBtn);
		
		voltageSourceBtn = new JButton("\u7535\u538B\u6E90");
		voltageSourceBtn.setToolTipText("\u7535\u538B\u6E90");
		componentToolBar_1.add(voltageSourceBtn);
		
		groundConnBtn = new JButton("\u63A5\u5730");
		groundConnBtn.setToolTipText("\u63A5\u5730");
		componentToolBar_1.add(groundConnBtn);
		
		inductanceBtn = new JButton("\u7535\u611F");
		inductanceBtn.setToolTipText("\u7535\u611F");
		componentToolBar_1.add(inductanceBtn);
		
		componentToolBar_2 = new JToolBar();
		componentToolBar_2.setOrientation(SwingConstants.VERTICAL);
		componentToolBar_2.setFloatable(false);
		componentBtnBar.add(componentToolBar_2);
		
		amperemeterBtn = new JButton("\u7535\u6D41\u8868");
		amperemeterBtn.setIcon(null);
		amperemeterBtn.setToolTipText("\u7535\u6D41\u8868");
		componentToolBar_2.add(amperemeterBtn);
		
		capicititanceBtn = new JButton("\u7535\u5BB9");
		capicititanceBtn.setIcon(null);
		capicititanceBtn.setToolTipText("\u7535\u5BB9");
		componentToolBar_2.add(capicititanceBtn);
		
		amplifierBtn = new JButton("\u653E\u5927\u5668");
		amplifierBtn.setIcon(null);
		amplifierBtn.setToolTipText("\u8FD0\u7B97\u653E\u5927\u5668");
		componentToolBar_2.add(amplifierBtn);
		
		currentSourceBtn = new JButton("\u7535\u6D41\u6E90");
		currentSourceBtn.setToolTipText("\u7535\u6D41\u6E90");
		componentToolBar_2.add(currentSourceBtn);
		
		switchBtn = new JButton("\u5F00\u5173");
		switchBtn.setToolTipText("\u5F00\u5173");
		componentToolBar_2.add(switchBtn);
		
		wireBtn = new JButton("\u5BFC\u7EBF");
		wireBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drawArea.startLinking();
			}
		});
		wireBtn.setToolTipText("\u5BFC\u7EBF");
		componentToolBar_2.add(wireBtn);
		
		drawArea = new DrawArea();
		getContentPane().add(drawArea, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(fileMenu);
		
		openMenuItem = new JMenuItem("\u6253\u5F00");
		fileMenu.add(openMenuItem);
		
		saveMenuItem = new JMenuItem("\u4FDD\u5B58");
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					saveComponentListToCsv();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		fileMenu.add(saveMenuItem);
		
		editMenu = new JMenu("\u7F16\u8F91");
		menuBar.add(editMenu);
		
		reportMenuItem = new JMenuItem("\u751F\u6210\u5B9E\u9A8C\u62A5\u544A");
		reportMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportFrame reportFrame = new ReportFrame();
			}
		});
		editMenu.add(reportMenuItem);
		
		menuBar.setVisible(true);
		this.setJMenuBar(menuBar);
		
	}
	
	public void saveComponentListToCsv() throws IOException{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("±£¥ÊCir");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showSaveDialog(getContentPane());
		if(result == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			FileHelper.saveComponentListToCsv(file
					, drawArea.getComponentList());
		}
	}

}
