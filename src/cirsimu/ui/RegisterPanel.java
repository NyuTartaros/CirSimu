package cirsimu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;

public class RegisterPanel extends JFrame {

	private JPanel contentPane;
	private JLabel lab1;
	private JLabel stuId;
	private JLabel stuName;
	private JLabel passwd;
	private JLabel passwddouble;
	private JLabel email;
	private JTextField idType;
	private JTextField nameType;
	private JTextField passwdType;
	private JTextField sureType;
	private JTextField emailType;
	private JLabel idPs;
	private JLabel namePs;
	private JLabel passwdPs;
	private JLabel passsurePs;
	private JLabel emailPs;
	
	public RegisterPanel(JDialog loginDialog) {
		loginDialog.setEnabled(false);
		loginDialog.setFocusable(true);
		setAlwaysOnTop(true);
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lab1 = new JLabel("�� �� �� �� �� Ϣ");
		lab1.setForeground(new Color(0, 0, 0));
		lab1.setFont(new Font("����", Font.PLAIN, 20));
		lab1.setBounds(175, 9, 184, 25);
		contentPane.add(lab1);
		
		stuId = new JLabel("ѧ ��");
		stuId.setFont(new Font("����", Font.PLAIN, 12));
		stuId.setHorizontalAlignment(SwingConstants.CENTER);
		stuId.setBounds(67, 58, 54, 15);
		contentPane.add(stuId);
		
		stuName = new JLabel("�� ��");
		stuName.setFont(new Font("����", Font.PLAIN, 12));
		stuName.setHorizontalAlignment(SwingConstants.CENTER);
		stuName.setBounds(67, 96, 54, 15);
		contentPane.add(stuName);
		
		passwd = new JLabel("�� ��");
		passwd.setHorizontalAlignment(SwingConstants.CENTER);
		passwd.setBounds(67, 139, 54, 15);
		contentPane.add(passwd);
		
		passwddouble = new JLabel("ȷ ��");
		passwddouble.setHorizontalAlignment(SwingConstants.CENTER);
		passwddouble.setBounds(67, 184, 54, 15);
		contentPane.add(passwddouble);
		
		email = new JLabel("�� ��");
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(67, 229, 54, 15);
		contentPane.add(email);
		
		idType = new JTextField();
		idType.setBounds(149, 55, 184, 21);
		contentPane.add(idType);
		idType.setColumns(10);
		
		nameType = new JTextField();
		nameType.setBounds(149, 93, 184, 21);
		contentPane.add(nameType);
		nameType.setColumns(10);
		
		passwdType = new JTextField();
		passwdType.setBounds(149, 136, 184, 21);
		contentPane.add(passwdType);
		passwdType.setColumns(10);
		
		sureType = new JTextField();
		sureType.setBounds(149, 181, 184, 21);
		contentPane.add(sureType);
		sureType.setColumns(10);
		
		emailType = new JTextField();
		emailType.setBounds(149, 226, 184, 21);
		contentPane.add(emailType);
		emailType.setColumns(10);
		
		idPs=new JLabel("* (��ȥ�ո�4-10λ)");
		idPs.setBounds(350, 55, 184, 21);
		contentPane.add(idPs);

		namePs=new JLabel("* (�Լ�����ʵ����)");
		namePs.setBounds(350, 93, 184, 21);
		contentPane.add(namePs);
		
		passwdPs=new JLabel("* (��ȥ�ո�4-10λ)");
		passwdPs.setBounds(350, 136, 184, 21);
		contentPane.add(passwdPs);
		
		passsurePs=new JLabel("* (��������һ��)");
		passsurePs.setBounds(350, 181, 184, 21);
		contentPane.add(passsurePs);

		emailPs=new JLabel("* (����ȷ��������)");
		emailPs.setBounds(350, 226, 184, 21);
		contentPane.add(emailPs);

		JButton button = new JButton("ע��");
		button.setBounds(191, 293, 93, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginDialog.setVisible(true);
				loginDialog.setEnabled(true);
			}
		});
		contentPane.add(button);
	}
}
