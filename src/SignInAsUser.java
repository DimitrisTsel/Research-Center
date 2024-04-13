import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class SignInAsUser extends JFrame {
	private JPanel contentPane;
	public SignInAsUser() {
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
		panelMenu.setBounds(0, 0, 176, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelShowMembers = new JPanel();
		panelShowMembers.setBackground(SystemColor.activeCaptionBorder);
		panelShowMembers.setBounds(23, 33, 116, 27);
		panelMenu.add(panelShowMembers);
		
		JLabel lblShowMembers = new JLabel("Show members");
		lblShowMembers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsUser.this.dispose();
				ShowMembers showMembers = new ShowMembers();
				showMembers.setVisible(true);
			}
		});
		panelShowMembers.add(lblShowMembers);
		
		JPanel panelShowPublications = new JPanel();
		panelShowPublications.setBackground(SystemColor.activeCaptionBorder);
		panelShowPublications.setBounds(23, 97, 116, 27);
		panelMenu.add(panelShowPublications);
		
		JLabel lblShowPublications = new JLabel("Show publications");
		lblShowPublications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsUser.this.dispose();
				ShowPublications showPublications = new ShowPublications();
				showPublications.setVisible(true);
			}
		});
		panelShowPublications.add(lblShowPublications);
		
		JPanel panelShowClasses = new JPanel();
		panelShowClasses.setBackground(SystemColor.activeCaptionBorder);
		panelShowClasses.setBounds(23, 177, 116, 27);
		panelMenu.add(panelShowClasses);
		
		JLabel lblShowClasses = new JLabel("Show classes");
		lblShowClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsUser.this.dispose();
				TheClasses theClasses = new TheClasses();
				theClasses.setVisible(true);
			}
		});

		panelShowClasses.add(lblShowClasses);
		
		JPanel panelShowProjects = new JPanel();
		panelShowProjects.setBackground(SystemColor.activeCaptionBorder);
		panelShowProjects.setBounds(23, 255, 116, 27);
		panelMenu.add(panelShowProjects);
		
		JLabel lblShowProjects = new JLabel("Show projects");
		lblShowProjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsUser.this.dispose();
				ShowProjects showProjects = new ShowProjects();
				showProjects.setVisible(true);
			}
		});

		panelShowProjects.add(lblShowProjects);
		
		JPanel panelShowAnnouncements = new JPanel();
		panelShowAnnouncements.setBackground(SystemColor.activeCaptionBorder);
		panelShowAnnouncements.setBounds(23, 332, 116, 27);
		panelMenu.add(panelShowAnnouncements);
		
		JLabel lblShowAnnouncements = new JLabel("Show announcements");
		lblShowAnnouncements.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsUser.this.dispose();
				TheAnnouncements theAnnouncements = new TheAnnouncements();
				theAnnouncements.setVisible(true);
			}
		});
		panelShowAnnouncements.add(lblShowAnnouncements);
		
		JPanel panelExitFromUser = new JPanel();
		panelExitFromUser.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromUser.setBounds(23, 583, 132, 27);
		panelMenu.add(panelExitFromUser);
		
		JLabel lblExitFromUser = new JLabel("Exit from user mode");
		lblExitFromUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInAsUser.this.dispose();
				MainMenu mainMenu = new MainMenu();
				mainMenu.setVisible(true);
			}
		});
		panelExitFromUser.add(lblExitFromUser);
		
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
