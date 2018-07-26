package cirsimu.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cirsimu.entity.CirComponent;
import cirsimu.util.FileHelper;

import javax.swing.JToolBar;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
	
	private JPanel componentBtnBar = new JPanel();
	private JToolBar componentToolBar_1;
	private JButton voltmeterBtn;
	private JButton resistanceBtn;
	private JButton diodeBtn;
	private JButton voltageSourceBtn;
	private JButton groundConnBtn;
	private JButton inductanceBtn;
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
	private JMenuItem menuItem;
	private JMenuItem saveItem;
	private JMenu zujianMenu;
	private JMenuItem dianyaItem;
	private JMenuItem dianliuItem;
	private JMenuItem dianzuItem;
	private JMenuItem dianrongItem;
	private JMenuItem erjiguanItem;
	private JMenuItem fangdaqiItem;
	private JMenuItem dianyayuanItem;
	private JMenuItem dianliuyuanItem;
	private JMenuItem jiediItem;
	private JMenuItem kaiguanItem;
	private JMenuItem dianganItem;
	private JMenuItem daoxianItem;
	private JMenuItem exitItem;
	private JMenuItem diaoyongItem;
	private JMenuItem chakanItem;
	private JMenu fangzhenMenu;
	private JMenu viewMenu;
	private JMenuItem dianlutumiaoshuItem;
	private JMenuItem dianlutudaimaItem;
	private JMenuItem daimabianjiItem;
	private JMenu shiyanMenu;
	private JMenuItem moveItem;
	private JMenuItem tijiaoresultItem;
	private JMenuItem copyItem;
	private JMenuItem pasteItem;
	private JMenuItem deleteItem;
	private JMenuItem rotateItem;
	private JMenuItem propertyItem;
	private JMenu setMenu;
	private JMenuItem serverSetitem;
	private JMenu helpMenu;
	private JMenuItem aboutItem;
	private JMenuItem softwareItem;
	private JMenuItem checkupdateItem;
	private JMenuItem pathSetItem;
	
	public MainWindow() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./icons/icon.png"));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u7535\u5DE5\u7535\u5B50\u5B9E\u9A8C\u5BA4\u6559\u5B66\u7CFB\u7EDF  \u7248\u6743\u6240\u6709\uFF1A\u5434\u76FC");
//		setLocationRelativeTo(null);
		setSize(1000,800);
		
		menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		fileMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(fileMenu);
		
		menuItem = new JMenuItem("\u65B0\u5EFA\u5B9E\u9A8C");
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.newGraph();
			}
		});
		fileMenu.add(menuItem);
		
		openMenuItem = new JMenuItem("\u6253\u5F00\u5B9E\u9A8C");
		fileMenu.add(openMenuItem);
		
		saveMenuItem = new JMenuItem("\u5BFC\u51FACir");
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					saveComponentListToCir();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		saveItem = new JMenuItem("\u4FDD\u5B58\u5B9E\u9A8C");
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					saveComponentListToGar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		fileMenu.add(saveItem);
		fileMenu.add(saveMenuItem);
		
		exitItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		fileMenu.add(exitItem);
		
		editMenu = new JMenu("\u7F16\u8F91");
		menuBar.add(editMenu);
		
		moveItem = new JMenuItem("\u62D6\u52A8");
		editMenu.add(moveItem);
		
		copyItem = new JMenuItem("\u590D\u5236");
		editMenu.add(copyItem);
		
		pasteItem = new JMenuItem("\u7C98\u8D34");
		editMenu.add(pasteItem);
		
		deleteItem = new JMenuItem("\u5220\u9664");
		editMenu.add(deleteItem);
		
		rotateItem = new JMenuItem("\u65CB\u8F6C");
		editMenu.add(rotateItem);
		
		propertyItem = new JMenuItem("\u5C5E\u6027");
		editMenu.add(propertyItem);
		
		zujianMenu = new JMenu("\u7EC4\u4EF6");
		menuBar.add(zujianMenu);
		
		dianyaItem = new JMenuItem("\u7535\u538B\u8868");
		zujianMenu.add(dianyaItem);
		
		dianliuItem = new JMenuItem("\u7535\u6D41\u8868");
		zujianMenu.add(dianliuItem);
		
		dianzuItem = new JMenuItem("\u7535\u963B");
		zujianMenu.add(dianzuItem);
		
		dianrongItem = new JMenuItem("\u7535\u5BB9");
		zujianMenu.add(dianrongItem);
		
		erjiguanItem = new JMenuItem("\u4E8C\u6781\u7BA1");
		zujianMenu.add(erjiguanItem);
		
		fangdaqiItem = new JMenuItem("\u8FD0\u7B97\u653E\u5927\u5668");
		zujianMenu.add(fangdaqiItem);
		
		dianyayuanItem = new JMenuItem("\u7535\u538B\u6E90");
		zujianMenu.add(dianyayuanItem);
		
		dianliuyuanItem = new JMenuItem("\u7535\u6D41\u6E90");
		zujianMenu.add(dianliuyuanItem);
		
		jiediItem = new JMenuItem("\u63A5\u5730");
		zujianMenu.add(jiediItem);
		
		kaiguanItem = new JMenuItem("\u5F00\u5173");
		zujianMenu.add(kaiguanItem);
		
		dianganItem = new JMenuItem("\u7535\u611F");
		zujianMenu.add(dianganItem);
		
		daoxianItem = new JMenuItem("\u5BFC\u7EBF");
		zujianMenu.add(daoxianItem);
		
		fangzhenMenu = new JMenu("\u4EFF\u771F");
		menuBar.add(fangzhenMenu);
		
		diaoyongItem = new JMenuItem("\u8C03\u7528PSpice\u4EFF\u771F");
		diaoyongItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pspicePath = FileHelper.readPspicePath();
				try {
					Runtime.getRuntime().exec("\"" + pspicePath + "\"");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fangzhenMenu.add(diaoyongItem);
		
		chakanItem = new JMenuItem("\u67E5\u770B\u5B9E\u9A8C\u7ED3\u679C");
		fangzhenMenu.add(chakanItem);
		
		viewMenu = new JMenu("\u89C6\u56FE");
		menuBar.add(viewMenu);
		
		dianlutumiaoshuItem = new JMenuItem("\u67E5\u770BSPICE\u7535\u8DEF\u63CF\u8FF0");
		viewMenu.add(dianlutumiaoshuItem);
		
		dianlutudaimaItem = new JMenuItem("\u67E5\u770B\u7535\u8DEF\u56FE\u4EE3\u7801");
		viewMenu.add(dianlutudaimaItem);
		
		daimabianjiItem = new JMenuItem("SPICE\u4EE3\u7801\u7F16\u8F91");
		viewMenu.add(daimabianjiItem);
		
		shiyanMenu = new JMenu("\u5B9E\u9A8C\u62A5\u544A");
		menuBar.add(shiyanMenu);
		
		reportMenuItem = new JMenuItem("\u751F\u6210\u5B9E\u9A8C\u62A5\u544A");
		shiyanMenu.add(reportMenuItem);
		reportMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportFrame reportFrame = new ReportFrame();
			}
		});
		
		tijiaoresultItem = new JMenuItem("\u63D0\u4EA4\u5B9E\u9A8C\u62A5\u544A");
		shiyanMenu.add(tijiaoresultItem);
		
		setMenu = new JMenu("\u8BBE\u7F6E");
		menuBar.add(setMenu);
		
		serverSetitem = new JMenuItem("\u670D\u52A1\u5668\u7AEF\u8BBE\u7F6E");
		setMenu.add(serverSetitem);
		
		pathSetItem = new JMenuItem("PSPICE\u8C03\u7528\u8DEF\u5F84\u8BBE\u7F6E");
		pathSetItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pspicePath = JOptionPane.showInputDialog(getContentPane(), "请输入Pspice的绝对路径：", "设置Pspice路径", JOptionPane.INFORMATION_MESSAGE);
				FileHelper.savePspicePath(pspicePath);
			}
		});
		setMenu.add(pathSetItem);
		
		helpMenu = new JMenu("\u5E2E\u52A9");
		menuBar.add(helpMenu);
		
		aboutItem = new JMenuItem("\u5173\u4E8E");
		helpMenu.add(aboutItem);
		
		softwareItem = new JMenuItem("\u8F6F\u4EF6\u5E2E\u52A9");
		helpMenu.add(softwareItem);
		
		checkupdateItem = new JMenuItem("\u68C0\u67E5\u66F4\u65B0");
		helpMenu.add(checkupdateItem);
		
		menuBar.setVisible(true);
		
		getContentPane().add(componentBtnBar, BorderLayout.WEST);
		
		componentToolBar_1 = new JToolBar();
		componentToolBar_1.setFloatable(false);
		componentToolBar_1.setOrientation(SwingConstants.VERTICAL);
		componentBtnBar.add(componentToolBar_1);
		
		voltmeterBtn = new JButton("\u7535\u538B\u8868");
		voltmeterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drawArea.startEditing(CirComponent.voltmeter);
			}
		});
		voltmeterBtn.setIcon(null);
		voltmeterBtn.setToolTipText("\u7535\u538B\u8868");
		componentToolBar_1.add(voltmeterBtn);
		
		resistanceBtn = new JButton("\u7535\u963B");
		resistanceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.resistance);
			}
		});
		
		amperemeterBtn = new JButton("\u7535\u6D41\u8868");
		componentToolBar_1.add(amperemeterBtn);
		amperemeterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.amperemeter);
			}
		});
		amperemeterBtn.setIcon(null);
		amperemeterBtn.setToolTipText("\u7535\u6D41\u8868");
		resistanceBtn.setIcon(null);
		resistanceBtn.setToolTipText("\u7535\u963B");
		componentToolBar_1.add(resistanceBtn);
		
		diodeBtn = new JButton("\u4E8C\u6781\u7BA1");
		diodeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.diode);
			}
		});
		
		capicititanceBtn = new JButton("\u7535\u5BB9");
		componentToolBar_1.add(capicititanceBtn);
		capicititanceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.capicititance);
			}
		});
		capicititanceBtn.setIcon(null);
		capicititanceBtn.setToolTipText("\u7535\u5BB9");
		diodeBtn.setIcon(null);
		diodeBtn.setToolTipText("\u4E8C\u6781\u7BA1");
		componentToolBar_1.add(diodeBtn);
		
		voltageSourceBtn = new JButton("\u7535\u538B\u6E90");
		voltageSourceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drawArea.startEditing(CirComponent.voltageSource);
			}
		});
		
		amplifierBtn = new JButton("\u653E\u5927\u5668");
		componentToolBar_1.add(amplifierBtn);
		amplifierBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.amplifier);
			}
		});
		amplifierBtn.setIcon(null);
		amplifierBtn.setToolTipText("\u8FD0\u7B97\u653E\u5927\u5668");
		voltageSourceBtn.setToolTipText("\u7535\u538B\u6E90");
		componentToolBar_1.add(voltageSourceBtn);
		
		currentSourceBtn = new JButton("\u7535\u6D41\u6E90");
		componentToolBar_1.add(currentSourceBtn);
		currentSourceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.currentSource);
			}
		});
		currentSourceBtn.setToolTipText("\u7535\u6D41\u6E90");
		
		switchBtn = new JButton("\u5F00\u5173");
		componentToolBar_1.add(switchBtn);
		switchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.switchComp);
			}
		});
		switchBtn.setToolTipText("\u5F00\u5173");
		
		inductanceBtn = new JButton("\u7535\u611F");
		inductanceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		inductanceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.inductance);
			}
		});
		inductanceBtn.setToolTipText("\u7535\u611F");
		componentToolBar_1.add(inductanceBtn);
		
		groundConnBtn = new JButton("\u63A5\u5730");
		groundConnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		groundConnBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawArea.startEditing(CirComponent.groundConn);
			}
		});
		groundConnBtn.setToolTipText("\u63A5\u5730");
		componentToolBar_1.add(groundConnBtn);
		
		wireBtn = new JButton("\u5BFC\u7EBF");
		componentToolBar_1.add(wireBtn);
		wireBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drawArea.startLinking();
			}
		});
		wireBtn.setToolTipText("\u5BFC\u7EBF");
		
		drawArea = new DrawArea();
		getContentPane().add(drawArea, BorderLayout.CENTER);
		
		JDialog loginDialog = new JDialog(this,"\u767B\u9646",true);
		loginDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		loginDialog.setSize(300, 250);
		loginDialog.setResizable(false);
		loginDialog.setLocationRelativeTo(this);
		
		LoginPanel loginPanel = new LoginPanel(loginDialog);
		loginDialog.setContentPane(loginPanel);
		loginDialog.setVisible(true);
	}
	
	public void saveComponentListToGar() throws IOException{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("保存实验");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showSaveDialog(getContentPane());
		if(result == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			FileHelper.saveComponentListToCsv(file
					,  drawArea.getComponentList());
		}
	}
	
	public void saveComponentListToCir() throws IOException{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("保存Cir");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showSaveDialog(getContentPane());
		if(result == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			FileHelper.saveComponentListToCir(file
					, drawArea.getComponentList());
		}
	}
}
