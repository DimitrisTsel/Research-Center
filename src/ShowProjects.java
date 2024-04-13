import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShowProjects extends JFrame {

	private JPanel contentPane;
	public ShowProjects() {
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
		panelMenu.setBounds(0, 0, 258, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelShowTheProjects = new JPanel();
		panelShowTheProjects.setBackground(SystemColor.activeCaptionBorder);
		panelShowTheProjects.setBounds(10, 135, 238, 27);
		panelMenu.add(panelShowTheProjects);
		
		JLabel lblShowTheProjects = new JLabel("Show the projects");
		lblShowTheProjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowProjects.this.dispose();
				TheProjects theProjects  = new TheProjects();
				theProjects.setVisible(true);
			}
		});
		panelShowTheProjects.add(lblShowTheProjects);
		
		JPanel panelShowProjectsByStatus = new JPanel();
		panelShowProjectsByStatus.setBackground(SystemColor.activeCaptionBorder);
		panelShowProjectsByStatus.setBounds(10, 217, 238, 27);
		panelMenu.add(panelShowProjectsByStatus);
		
		JLabel lblShowProjectsByStatus = new JLabel("Show the projects by status");
		lblShowProjectsByStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowProjects.this.dispose();
				TheProjectsByStatus theProjectsByStatus  = new TheProjectsByStatus();
				theProjectsByStatus.setVisible(true);
			}
		});
		panelShowProjectsByStatus.add(lblShowProjectsByStatus);
		
		JPanel panelShowAllProjectsByMembersAndStatus = new JPanel();
		panelShowAllProjectsByMembersAndStatus.setBackground(SystemColor.activeCaptionBorder);
		panelShowAllProjectsByMembersAndStatus.setBounds(10, 298, 238, 27);
		panelMenu.add(panelShowAllProjectsByMembersAndStatus);
		
		JLabel lblShowAllProjectsByMembersAndStatus = new JLabel("Show all projects by members and status");
		lblShowAllProjectsByMembersAndStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowProjects.this.dispose();
				TheProjectsByMembersAndStatus theProjectsByMembersAndStatus  = new TheProjectsByMembersAndStatus();
				theProjectsByMembersAndStatus.setVisible(true);
			}
		});
		panelShowAllProjectsByMembersAndStatus.add(lblShowAllProjectsByMembersAndStatus);
		
		
		
		JPanel panelExitFromProjects = new JPanel();
		panelExitFromProjects.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromProjects.setBounds(10, 548, 238, 27);
		panelMenu.add(panelExitFromProjects);
		
		JLabel lblExitFromProjects = new JLabel("Exit from Projects");
		lblExitFromProjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowProjects.this.dispose();
				SignInAsUser signInAsUser  = new SignInAsUser();
				signInAsUser.setVisible(true);
			}
		});
		panelExitFromProjects.add(lblExitFromProjects);
}
}