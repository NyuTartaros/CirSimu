package cirsimu.ui;

import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public LoginPanel(JDialog loginDialog) {
		setLayout(null);
//		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		
		setSize(300, 250);
		usernameField = new JTextField();
		usernameField.setBounds(112, 43, 126, 28);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(112, 89, 127, 28);
		add(passwordField);
		passwordField.setColumns(10);
		
		JLabel label = new JLabel("用户名");
		label.setBounds(66, 49, 36, 15);
		add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(78, 95, 24, 15);
		add(label_1);
		
		JButton loginBtn = new JButton("登陆");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean loginFlag = login(usernameField.getText()
						, passwordField.getText());
				if(loginFlag){
					loginDialog.dispose();
				}else{
					JOptionPane.showMessageDialog(e.getComponent(), "用户名或密码错误.");
				}
			}
		});
		loginBtn.setBounds(66, 156, 57, 23);
		add(loginBtn);
		JButton button = new JButton("注册");
		button.setBounds(169, 156, 57, 23);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterPanel registerPanel=new RegisterPanel(loginDialog);
				registerPanel.setVisible(true);	
				loginDialog.setVisible(false);
			}
		});
		add(button);
	}
	
	public boolean login(String username, String password){
		if(username.equals("admin") && password.equals("admin")){
			return true;
		}else{
			return false;
		}
	}
}
