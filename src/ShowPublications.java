import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ShowPublications extends JFrame {

	private JPanel contentPane;
	public ShowPublications() {
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
		panelMenu.setBounds(0, 0, 256, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelShowThePublications = new JPanel();
		panelShowThePublications.setBackground(SystemColor.activeCaptionBorder);
		panelShowThePublications.setBounds(10, 33, 236, 27);
		panelMenu.add(panelShowThePublications);
		
		JLabel lblShowThePublications = new JLabel("Show the publications");
		lblShowThePublications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowPublications.this.dispose();
				ThePublications thePublications  = new ThePublications();
				thePublications.setVisible(true);
			}
		});
		panelShowThePublications.add(lblShowThePublications);
		
		JPanel panelShowMembers_1 = new JPanel();
		panelShowMembers_1.setBackground(SystemColor.activeCaptionBorder);
		panelShowMembers_1.setBounds(10, 93, 236, 27);
		panelMenu.add(panelShowMembers_1);
		
		JLabel lblShowThePublicationsOfAMember = new JLabel("Show the publications of a member");
		lblShowThePublicationsOfAMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowPublications.this.dispose();
				ThePublicationsOfAMember thePublicationsOfAMember  = new ThePublicationsOfAMember();
				thePublicationsOfAMember.setVisible(true);
			}
		});
		panelShowMembers_1.add(lblShowThePublicationsOfAMember);
		
		JPanel panelShowAllPublicationsByMember = new JPanel();
		panelShowAllPublicationsByMember.setBackground(SystemColor.activeCaptionBorder);
		panelShowAllPublicationsByMember.setBounds(10, 156, 236, 27);
		panelMenu.add(panelShowAllPublicationsByMember);
		
		JLabel lblShowAllPublicationsByMember = new JLabel("Show all publications by member");
		lblShowAllPublicationsByMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowPublications.this.dispose();
				ThePublicationsByAllMembers thePublicationsByAllMembers  = new ThePublicationsByAllMembers();
				thePublicationsByAllMembers.setVisible(true);
			}
		});
		panelShowAllPublicationsByMember.add(lblShowAllPublicationsByMember);
		
		JPanel panelShowPublicationsOfAMemberByPlace = new JPanel();
		panelShowPublicationsOfAMemberByPlace.setBackground(SystemColor.activeCaptionBorder);
		panelShowPublicationsOfAMemberByPlace.setBounds(10, 224, 236, 27);
		panelMenu.add(panelShowPublicationsOfAMemberByPlace);
		
		JLabel lblShowPublicationsOfAMemberByPlace = new JLabel("Show publications of a member by place");
		lblShowPublicationsOfAMemberByPlace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowPublications.this.dispose();
				ThePublicationsOfAMemberByPlace thePublicationsOfAMemberByPlace  = new ThePublicationsOfAMemberByPlace();
				thePublicationsOfAMemberByPlace.setVisible(true);
			}
		});
		panelShowPublicationsOfAMemberByPlace.add(lblShowPublicationsOfAMemberByPlace);
		
		JPanel panelShowAllPublicationsByPlace = new JPanel();
		panelShowAllPublicationsByPlace.setBackground(SystemColor.activeCaptionBorder);
		panelShowAllPublicationsByPlace.setBounds(10, 296, 236, 27);
		panelMenu.add(panelShowAllPublicationsByPlace);
		
		JLabel lblShowPublicationsOfAllMembersByPlace = new JLabel("Show all publications by place");
		lblShowPublicationsOfAllMembersByPlace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowPublications.this.dispose();
				ThePublicationsOfAllMembersByPlace thePublicationsOfAllMembersByPlace  = new ThePublicationsOfAllMembersByPlace();
				thePublicationsOfAllMembersByPlace.setVisible(true);
			}
		});
		panelShowAllPublicationsByPlace.add(lblShowPublicationsOfAllMembersByPlace);
		
		JPanel panelExitFromPublications = new JPanel();
		panelExitFromPublications.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromPublications.setBounds(10, 580, 236, 27);
		panelMenu.add(panelExitFromPublications);
		
		JLabel lblExitFromPublications = new JLabel("Exit from Publications");
		lblExitFromPublications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowPublications.this.dispose();
				SignInAsUser signInAsUser  = new SignInAsUser();
				signInAsUser.setVisible(true);
			}
		});
		panelExitFromPublications.add(lblExitFromPublications);
		
		JPanel panelShowAllPublicationsByPlace_1 = new JPanel();
		panelShowAllPublicationsByPlace_1.setBackground(SystemColor.activeCaptionBorder);
		panelShowAllPublicationsByPlace_1.setBounds(10, 363, 236, 27);
		panelMenu.add(panelShowAllPublicationsByPlace_1);
		
		JLabel lblCommonPublicationsBy = new JLabel("Common publiations by members");
		lblCommonPublicationsBy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowPublications.this.dispose();
				CommonPublications commonPublications = new CommonPublications();
				commonPublications.setVisible(true);
			}
		});
		panelShowAllPublicationsByPlace_1.add(lblCommonPublicationsBy);
}
}