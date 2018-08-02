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
	private ArrayList<JTextField> attriFieldList;
	/**
	 * Create the dialog.
	 */
	public AttributeLog(CirComponent parentCirComponent) {
		int attributeNum = parentCirComponent.getAttributeNum();
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icons\\icon.png"));
		setTitle("\u5143\u4EF6\u5C5E\u6027");
		setBounds(100, 100, 255, 181);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel attriLabel = new JLabel("\u5143\u4EF6\u5C5E\u6027\uFF1A");
			attriLabel.setBounds(28, 23, 60, 15);
			contentPanel.add(attriLabel);
		}
		
		attriFieldList = new ArrayList<JTextField>();
		int leftBound = 38;
		int sumWidth = 172;
		int upperBound = 57;
		int height = 21;
		int fieldGap = 10;
		int gapNum = attributeNum-1;
		int fieldWidth = Math.round((sumWidth-gapNum*fieldGap)/(float)attributeNum);
		System.out.println("attributeNum: "+attributeNum);
		System.out.println("fieldWidth: "+fieldWidth);
		int xtmp = leftBound;
		for(int i=0; i<attributeNum; i++){
			System.out.println("xtmp: "+xtmp);
			JTextField attriFiled = new JTextField();
			attriFiled.setBounds(xtmp, upperBound, fieldWidth, height);
			contentPanel.add(attriFiled);
			attriFiled.setColumns(10);
			attriFieldList.add(attriFiled);
			xtmp += fieldWidth + fieldGap;
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u8BA4");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Float> attriList = new ArrayList<Float>();
						for(int i=0; i<attributeNum; i++){
							String attribute = attriFieldList.get(i).getText();
							if(attribute.equals("")){
								attriList.add((float) -1.0);
							}else{
								attriList.add(new Float(attribute));
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
