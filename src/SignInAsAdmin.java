
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

public class SignInAsAdmin extends JFrame {
	private JPanel contentPane;
	public SignInAsAdmin() {
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
		panelMenu.setBounds(0, 0, 228, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelEditMembers = new JPanel();
		panelEditMembers.setBackground(SystemColor.activeCaptionBorder);
		panelEditMembers.setBounds(56, 54, 116, 27);
		panelMenu.add(panelEditMembers);
		
		JLabel lblEditMembers = new JLabel("Members");
		lblEditMembers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsAdmin.this.dispose();
				EditMembers editMembers = new EditMembers();
				editMembers.setVisible(true);
			}
		});
		panelEditMembers.add(lblEditMembers);
		
		JPanel panelEditPublications = new JPanel();
		panelEditPublications.setBackground(SystemColor.activeCaptionBorder);
		panelEditPublications.setBounds(56, 104, 116, 27);
		panelMenu.add(panelEditPublications);
		
		JLabel lblEditPublications = new JLabel("Publications");
		lblEditPublications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsAdmin.this.dispose();
				EditPublications editPublications= new EditPublications();
				editPublications.setVisible(true);
			}
		});
		panelEditPublications.add(lblEditPublications);
		
		JPanel panelEditProjects = new JPanel();
		panelEditProjects.setBackground(SystemColor.activeCaptionBorder);
		panelEditProjects.setBounds(56, 160, 116, 27);
		panelMenu.add(panelEditProjects);
		
		JLabel lblEditProjects = new JLabel("Projects");
		lblEditProjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsAdmin.this.dispose();
				EditProjects editProjects = new EditProjects();
				editProjects.setVisible(true);
			}
		});

		panelEditProjects.add(lblEditProjects);
		
	
		
		JPanel panelControlPanel = new JPanel();
		panelControlPanel.setBackground(SystemColor.activeCaptionBorder);
		panelControlPanel.setBounds(56, 321, 116, 27);
		panelMenu.add(panelControlPanel);
		
		JLabel lblControlPanel = new JLabel("Control panel");
		lblControlPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsAdmin.this.dispose();
				TheMembersControlPanel theMembersControlPanel = new TheMembersControlPanel();
				theMembersControlPanel.setVisible(true);

			}
		});

		panelControlPanel.add(lblControlPanel);
		
		JPanel panelExitFromAdmin = new JPanel();
		panelExitFromAdmin.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromAdmin.setBounds(56, 523, 116, 27);
		panelMenu.add(panelExitFromAdmin);
		
		JLabel lblExitFromAdmin = new JLabel("Log out");
		lblExitFromAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?","confirmation",JOptionPane.YES_NO_OPTION)==0) {
					SignInAsAdmin.this.dispose();
					MainMenu mainMenu = new MainMenu();
					mainMenu.setVisible(true);
				}
			}
		});
		panelExitFromAdmin.add(lblExitFromAdmin);
		
		JPanel panelEditClasses = new JPanel();
		panelEditClasses.setBackground(SystemColor.activeCaptionBorder);
		panelEditClasses.setBounds(56, 215, 116, 27);
		panelMenu.add(panelEditClasses);
		
		JLabel lblEditClasses = new JLabel("Classes");
		lblEditClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsAdmin.this.dispose();
				EditClasses editClasses = new EditClasses();
				editClasses.setVisible(true);

			}
		});
		panelEditClasses.add(lblEditClasses);
		
		JPanel panelEditAnnouncements = new JPanel();
		panelEditAnnouncements.setBackground(SystemColor.activeCaptionBorder);
		panelEditAnnouncements.setBounds(56, 269, 116, 27);
		panelMenu.add(panelEditAnnouncements);
		
		JLabel lblEditAnnouncements = new JLabel("Announcements");
		lblEditAnnouncements.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsAdmin.this.dispose();
				EditAnnouncements editAnnouncements = new EditAnnouncements();
				editAnnouncements.setVisible(true);

			}
		});
		panelEditAnnouncements.add(lblEditAnnouncements);
		
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
