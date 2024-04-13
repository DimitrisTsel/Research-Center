import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ThePublicationsOfAllMembersByPlace extends JFrame {

	private JPanel contentPane;
	private JTable table;  
	public ThePublicationsOfAllMembersByPlace() {
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
		panelMenu.setBounds(0, 0, 263, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
			
			JPanel panelExitFromPublicationsOfAllMembersByPlace = new JPanel();
			panelExitFromPublicationsOfAllMembersByPlace.setBackground(SystemColor.activeCaptionBorder);
			panelExitFromPublicationsOfAllMembersByPlace.setBounds(10, 589, 226, 27);
			panelMenu.add(panelExitFromPublicationsOfAllMembersByPlace);
			
			JLabel lblExitFromPublicationsOfAllMembersByPlace = new JLabel("Back");
			lblExitFromPublicationsOfAllMembersByPlace.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ThePublicationsOfAllMembersByPlace.this.dispose();
					ShowPublications showPublications = new ShowPublications();
					showPublications.setVisible(true);
				}
			});
			panelExitFromPublicationsOfAllMembersByPlace.add(lblExitFromPublicationsOfAllMembersByPlace);
			
					JButton btnLoadThePublicationsOfAllMembersByPlace = new JButton("Load  pubs of members by place ");
					btnLoadThePublicationsOfAllMembersByPlace.setBounds(0, 79, 263, 38);
					panelMenu.add(btnLoadThePublicationsOfAllMembersByPlace);
					btnLoadThePublicationsOfAllMembersByPlace.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
						  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
							   ResultSet myRs = null;	
						          myRs=stmt.executeQuery(" EXEC viewAllPublicationsByPlace");		      	
						          table.setModel(DbUtils.resultSetToTableModel(myRs));
						  } catch (SQLException e1) {
									e1.printStackTrace();
						  }
							}
						});
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(272, 10, 918, 630);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
		
	}
	}


