package cirsimu.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cirsimu.entity.CirComponent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AttributeLog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList<JLabel> attriLabelList;
	private JLabel attriLabel1;
	private JLabel attriLabel2;
	private ArrayList<JTextField> attriFieldList;
	private JTextField nameField;
	private JTextField attriField1;
	private JTextField attriField2;
	/**
	 * Create the dialog.
	 */
	public AttributeLog(CirComponent parentCirComponent) {
		int attributeNum = parentCirComponent.getAttributeNum();
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icons\\icon.png"));
		setTitle("\u5143\u4EF6\u5C5E\u6027");
		setBounds(100, 100, 255, 277);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		if(parentCirComponent.getType() == CirComponent.groundConn){
			return;
		}
		JLabel nameLabel = new JLabel("\u5143\u4EF6\u540D\u79F0\uFF1A");
		nameLabel.setBounds(28, 23, 60, 15);
		contentPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(38, 48, 142, 21);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		attriLabel1 = new JLabel("\u5143\u4EF6\u5C5E\u60271\uFF1A");
		attriLabel1.setBounds(28, 81, 110, 15);
		contentPanel.add(attriLabel1);
		
		attriField1 = new JTextField();
		attriField1.setBounds(38, 106, 142, 21);
		contentPanel.add(attriField1);
		attriField1.setColumns(10);
		
		attriLabel2 = new JLabel("\u5143\u4EF6\u5C5E\u60272\uFF1A");
		attriLabel2.setBounds(28, 137, 135, 15);
		contentPanel.add(attriLabel2);
		
		attriField2 = new JTextField();
		attriField2.setBounds(38, 162, 142, 21);
		contentPanel.add(attriField2);
		attriField2.setColumns(10);
		
		attriLabelList = new ArrayList<JLabel>();
		attriLabelList.add(attriLabel1);
		attriLabelList.add(attriLabel2);
		attriFieldList = new ArrayList<JTextField>();
		attriFieldList.add(attriField1);
		attriFieldList.add(attriField2);
		
		String[] attriNameList = parentCirComponent.getAttriName();
		for(int i=0; i<attriNameList.length; i++){
			attriLabelList.get(i).setText(attriNameList[i]);
		}
		
		for(int i=attributeNum; i<attriLabelList.size(); i++){
			attriLabelList.get(i).setVisible(false);
			attriFieldList.get(i).setVisible(false);
		}
		
		if(parentCirComponent.getCompName() != null){
			nameField.setText(parentCirComponent.getCompName());
		}
		if(parentCirComponent.getAttriArraylist() != null){
			for(int i=0; i<parentCirComponent.getAttriArraylist().size(); i++){
				attriFieldList.get(i).setText(""+parentCirComponent.getAttriArraylist().get(i));
			}
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u8BA4");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String compName = nameField.getText();
						parentCirComponent.setCompName(compName);
						ArrayList<String> attriList = new ArrayList<String>();
						for(int i=0; i<attributeNum; i++){
							String attribute = attriFieldList.get(i).getText();
							if(attribute.equals("")){
								attriList.add("-1.0 ");
							}else{
								attriList.add(attribute);
							}
						}
						parentCirComponent.setAttributeList(attriList);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
