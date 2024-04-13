
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
		public Login() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(contentPane);
			setUndecorated(true);
			setBounds(100, 100, 1200, 650);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.activeCaptionBorder);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			getContentPane().setLayout(null);
			getContentPane().setLayout(null);
			setVisible(true);
			JPanel panelMenu = new JPanel();
			panelMenu.setBackground(SystemColor.controlHighlight);
			panelMenu.setBounds(0, 0, 237, 650);
			contentPane.add(panelMenu);
			panelMenu.setLayout(null);
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblUsername.setBounds(613, 94, 130, 37);
			contentPane.add(lblUsername);
			
			textField = new JTextField();
			textField.setBounds(612, 132, 165, 31);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPassword.setBounds(613, 173, 109, 29);
			contentPane.add(lblPassword);
			JPanel panelExitFromLogin = new JPanel();
			panelExitFromLogin.setBackground(SystemColor.activeCaptionBorder);
			panelExitFromLogin.setBounds(56, 485, 103, 27);
			panelMenu.add(panelExitFromLogin);
			
			JLabel lblExitFromSignIn = new JLabel("Exit from Sign In");
			lblExitFromSignIn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Login.this.dispose();
					MainMenu mainMenu = new MainMenu();
					mainMenu.setVisible(true);
				}
			});
			panelExitFromLogin.add(lblExitFromSignIn);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(613, 205, 164, 31);
			contentPane.add(passwordField);
			
			JPanel panelSignIn = new JPanel();
			panelSignIn.setBackground(SystemColor.controlHighlight);
			panelSignIn.setBounds(640, 272, 103, 27);
			contentPane.add(panelSignIn);
			
			JLabel lblSignIn = new JLabel("Sign In");
			lblSignIn.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("deprecation")
				@Override
				public void mouseClicked(MouseEvent e) {
					if(textField.getText().contains("admin")&& (passwordField.getText().contains("123"))){
							Login.this.dispose();
							SignInAsAdmin signInAsAdmin = new SignInAsAdmin();
							signInAsAdmin.setVisible(true);				
					}else {
						JOptionPane.showMessageDialog(null,"Invalid login details, please try again!","Login Error",JOptionPane.ERROR_MESSAGE);
						passwordField.setText(null);
						textField.setText(null);
					}
				}
			});
			panelSignIn.add(lblSignIn);
			
			
		}
}