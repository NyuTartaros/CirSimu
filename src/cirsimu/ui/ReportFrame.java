package cirsimu.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import cirsimu.util.DocUtil;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;

public class ReportFrame extends JFrame {
	private JTextField exName;
	private JTextField classname;
	private JTextField name;
	private JTextField number;
	private JTextField location;
	private JTextField date;
	private JTextPane motivation;
	private JTextPane environment;
	private JTextPane content;
	private JTextPane procedure;
	private JTextPane result;
	
	
	private int lineNum1=2;
	private int lineNum2=6;
	private int lineHeight=21;
	private JTextField title;
	
	public ReportFrame(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\GitHub\\CirSimu\\icons\\icon.png"));
		setTitle("\u5B9E\u9A8C\u62A5\u544A");
		setVisible(true);
		setSize(600, 750);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B9E\u9A8C\u540D\u79F0");
		lblNewLabel.setBounds(10, 10+31, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u73ED\u7EA7");
		label.setBounds(10, 35+31, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(10, 69+31, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u5B66\u53F7");
		label_2.setBounds(10, 100+31, 54, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u5B9E\u9A8C\u5730\u70B9");
		label_3.setBounds(10, 131+31, 54, 15);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u65E5\u671F");
		label_4.setBounds(10, 162+31, 54, 15);
		getContentPane().add(label_4);
		
		exName = new JTextField();
		exName.setBounds(74, 7+31, 500, 21);
		getContentPane().add(exName);
		exName.setColumns(10);
		
		classname = new JTextField();
		classname.setBounds(74, 35+31, 500, 21);
		getContentPane().add(classname);
		classname.setColumns(10);
		
		name = new JTextField();
		name.setBounds(74, 66+31, 500, 21);
		getContentPane().add(name);
		name.setColumns(10);
		
		number = new JTextField();
		number.setBounds(74, 97+31, 500, 21);
		getContentPane().add(number);
		number.setColumns(10);
		
		location = new JTextField();
		location.setBounds(74, 128+31, 500, 21);
		getContentPane().add(location);
		location.setColumns(10);
		
		date = new JTextField();
		date.setBounds(74, 159+31, 500, 21);
		getContentPane().add(date);
		date.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 190+31, 500, 42);
		getContentPane().add(scrollPane);
		
		motivation = new JTextPane();
		scrollPane.setViewportView(motivation);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B9E\u9A8C\u76EE\u7684");
		lblNewLabel_1.setBounds(10, 190+31, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 242+31
				, 500, 42);
		getContentPane().add(scrollPane_1);
		
		environment = new JTextPane();
		scrollPane_1.setViewportView(environment);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(74, 294+31
				, 500, 3*lineHeight);
		getContentPane().add(scrollPane_2);
		
		content = new JTextPane();
		scrollPane_2.setViewportView(content);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(74, scrollPane_2.getY()+scrollPane_2.getHeight()+10
				, 500, 126);
		getContentPane().add(scrollPane_3);
		
		procedure = new JTextPane();
		scrollPane_3.setViewportView(procedure);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(74, scrollPane_3.getY()+scrollPane_3.getHeight()+10
				, 500, 126);
		getContentPane().add(scrollPane_4);
		
		result = new JTextPane();
		scrollPane_4.setViewportView(result);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B9E\u9A8C\u73AF\u5883");
		lblNewLabel_2.setBounds(10, 242+31, 54, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel label_5 = new JLabel("<html>\u5B9E\u9A8C\u5185\u5BB9<br>\u548C\u8981\u6C42<html>");
		label_5.setBounds(10, 325, 54, 42);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u5B9E\u9A8C\u6B65\u9AA4");
		label_6.setBounds(10, 398, 54, 15);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u5B9E\u9A8C\u7ED3\u679C");
		label_7.setBounds(10, 534, 54, 15);
		getContentPane().add(label_7);
		
		JButton button = new JButton("\u751F\u6210");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				generateReport(title.getText(), exName.getText(), classname.getText()
						, name.getText(), number.getText(), location.getText()
						, date.getText(), motivation.getText()
						, environment.getText(), content.getText()
						, procedure.getText(), result.getText());
			}
		});
		button.setBounds(246, 670, 93, 23);
		getContentPane().add(button);
		
		title = new JTextField();
		title.setBounds(74, 7, 500, 21);
		getContentPane().add(title);
		title.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u9898\u76EE");
		lblNewLabel_3.setBounds(10, 10, 54, 15);
		getContentPane().add(lblNewLabel_3);
	}
	
	public void generateReport(String title, String experimentName
			, String className, String name, String number
			, String location, String date, String motivation
			, String environment, String content
			, String procedure, String result){
		DocUtil docUtil = new DocUtil();
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("title", title);
		dataMap.put("experimentName", experimentName);
		dataMap.put("class", className);
		dataMap.put("name", name);
		dataMap.put("number", number);
		dataMap.put("location", location);
		dataMap.put("date", date);
		dataMap.put("motivation", motivation);
		dataMap.put("environment", environment);
		dataMap.put("content", content);
		dataMap.put("procedure", procedure);
		dataMap.put("result", result);
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("保存实验报告");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int fileChooseResult = fileChooser.showSaveDialog(this);
		File file;
		if(fileChooseResult == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
		}else{
			return;
		}
		docUtil.createDoc(dataMap, "report", file);
	}
}
