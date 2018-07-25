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
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AttributeLog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField attriField;

	/**
	 * Create the dialog.
	 */
	public AttributeLog(CirComponent parentCirComponent) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icons\\icon.png"));
		setTitle("\u5143\u4EF6\u5C5E\u6027");
		setBounds(100, 100, 255, 181);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel attriLabel = new JLabel("\u5143\u4EF6\u5C5E\u6027\uFF1A");
			attriLabel.setBounds(43, 23, 60, 15);
			contentPanel.add(attriLabel);
		}
		
		attriField = new JTextField();
		attriField.setBounds(50, 58, 114, 21);
		contentPanel.add(attriField);
		attriField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u8BA4");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String attribute = attriField.getText();
						if (attribute.equals("")) {
							return;
						}else{
							parentCirComponent.setProperty(new Double(attribute));
							dispose();
						}
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
