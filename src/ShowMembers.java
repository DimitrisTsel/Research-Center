import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ShowMembers extends JFrame {

	private JPanel contentPane;

	public ShowMembers() {
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
		panelMenu.setBounds(0, 0, 207, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelShowTheMembers = new JPanel();
		panelShowTheMembers.setBackground(SystemColor.activeCaptionBorder);
		panelShowTheMembers.setBounds(10, 134, 187, 27);
		panelMenu.add(panelShowTheMembers);
		
		JLabel lblShowTheMembers = new JLabel("Show the Members");
		lblShowTheMembers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowMembers.this.dispose();
				TheMembers theMembers = new TheMembers();
				theMembers.setVisible(true);
			}
		});
		panelShowTheMembers.add(lblShowTheMembers);
		
		JPanel panelShowTheMembersByDept = new JPanel();
		panelShowTheMembersByDept.setBackground(SystemColor.activeCaptionBorder);
		panelShowTheMembersByDept.setBounds(10, 235, 187, 27);
		panelMenu.add(panelShowTheMembersByDept);
		
		JLabel lblShowTheMembersByDept = new JLabel("Show the Members by dept");
		panelShowTheMembersByDept.add(lblShowTheMembersByDept);
		lblShowTheMembersByDept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowMembers.this.dispose();
				TheMembersByDept theMembersByDept = new TheMembersByDept();
				theMembersByDept.setVisible(true);
			}
		});
		
		JPanel panelExitFromMembers = new JPanel();
		panelExitFromMembers.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromMembers.setBounds(10, 600, 187, 27);
		panelMenu.add(panelExitFromMembers);
		
		JLabel lblExitFromMembers = new JLabel("Exit from Members");
		lblExitFromMembers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowMembers.this.dispose();
				SignInAsUser signInAsUser = new SignInAsUser();
				signInAsUser.setVisible(true);
			}
		});
		panelExitFromMembers.add(lblExitFromMembers);
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
