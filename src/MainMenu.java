
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
public class MainMenu extends JFrame {

		private JPanel contentPane;
		
		//private SignInAsUser signInAsUser;
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MainMenu frame = new MainMenu();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public MainMenu() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(contentPane);
			setUndecorated(true);
			setBounds(100, 100, 1200, 650);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.activeCaptionBorder);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panelMenu = new JPanel();
			panelMenu.setBackground(SystemColor.controlHighlight);
			panelMenu.setBounds(0, 0, 200, 650);
			contentPane.add(panelMenu);
			panelMenu.setLayout(null);
			
			JPanel panelExit = new JPanel();
			panelExit.addMouseListener(new panelButtonMouseAdapter(panelExit));
			panelExit.setBackground(SystemColor.activeCaptionBorder);
			panelExit.setBounds(40, 388, 116, 27);
			panelMenu.add(panelExit);
			
			JLabel lblExit = new JLabel("Exit");
			panelExit.add(lblExit);
			lblExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","confirmation",JOptionPane.YES_NO_OPTION)==0) {
						MainMenu.this.dispose();
					}
				}
			});
			
			JPanel panelInfo = new JPanel();
			panelInfo.addMouseListener(new panelButtonMouseAdapter(panelInfo));
			panelInfo.setBackground(SystemColor.activeCaptionBorder);
			panelInfo.setBounds(40, 259, 116, 27);
			panelMenu.add(panelInfo);
			
			JLabel lblInfo = new JLabel("Information about RC");
			lblInfo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainMenu.this.dispose();
					TheInfo theInfo = new TheInfo();
					theInfo.setVisible(true);
				}
			});
			panelInfo.add(lblInfo);
			
			JPanel panelSignInUser = new JPanel();
			
			panelSignInUser.setBackground(SystemColor.activeCaptionBorder);
			panelSignInUser.addMouseListener(new panelButtonMouseAdapter(panelSignInUser));
			panelSignInUser.setBounds(40, 205, 116, 27);
			panelMenu.add(panelSignInUser);
			
			JLabel lblSignInUser = new JLabel("Sign In as User");
			lblSignInUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainMenu.this.dispose();
					SignInAsUser signInAsUser = new SignInAsUser();
					signInAsUser.setVisible(true);
				}
			});
			panelSignInUser.add(lblSignInUser);
			
			JPanel panelSignInAdmin = new JPanel();
			panelSignInAdmin.addMouseListener(new panelButtonMouseAdapter(panelSignInAdmin));
			panelSignInAdmin.setBackground(SystemColor.activeCaptionBorder);
			panelSignInAdmin.setBounds(40, 149, 116, 27);
			panelMenu.add(panelSignInAdmin);
			
			JLabel lblSignInAdmin = new JLabel("Sign In as Admin");
			lblSignInAdmin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainMenu.this.dispose();
					Login login = new Login();
					login.setVisible(true);
				}
			});
			panelSignInAdmin.add(lblSignInAdmin);

		}
		
		private class panelButtonMouseAdapter extends MouseAdapter{
			JPanel panel;
			public panelButtonMouseAdapter(JPanel panel) {
				this.panel=panel;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(SystemColor.controlHighlight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(SystemColor.activeCaptionBorder);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setBackground(SystemColor.activeCaptionBorder);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.setBackground(SystemColor.activeCaptionBorder);
			}
		}
	}



