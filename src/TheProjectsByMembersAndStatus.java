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
import java.awt.Font;

public class TheProjectsByMembersAndStatus extends JFrame {

	private JPanel contentPane;
	private JTable table;  
	public TheProjectsByMembersAndStatus() {
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
		panelMenu.setBounds(0, 0, 227, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
			
			JPanel panelExitFromProjectsByMembersAndStatus = new JPanel();
			panelExitFromProjectsByMembersAndStatus.setBackground(SystemColor.activeCaptionBorder);
			panelExitFromProjectsByMembersAndStatus.setBounds(10, 613, 207, 27);
			panelMenu.add(panelExitFromProjectsByMembersAndStatus);
			
			JLabel lblExitFromProjectsByMembersAndStatus = new JLabel("Back");
			lblExitFromProjectsByMembersAndStatus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TheProjectsByMembersAndStatus.this.dispose();
					ShowProjects showProjects = new ShowProjects();
					showProjects.setVisible(true);
				}
			});
			panelExitFromProjectsByMembersAndStatus.add(lblExitFromProjectsByMembersAndStatus);
			
					JButton btnLoadTheProjectsByMembersAndStatus = new JButton("Load projects by members and status ");
					btnLoadTheProjectsByMembersAndStatus.setFont(new Font("Tahoma", Font.BOLD, 9));
					btnLoadTheProjectsByMembersAndStatus.setBounds(0, 61, 225, 35);
					panelMenu.add(btnLoadTheProjectsByMembersAndStatus);
					btnLoadTheProjectsByMembersAndStatus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
						  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
							   ResultSet myRs = null;	
						          myRs=stmt.executeQuery(" EXEC viewAllProjectsByNameAndStatus");		      	
						          table.setModel(DbUtils.resultSetToTableModel(myRs));
						  } catch (SQLException e1) {
									e1.printStackTrace();
						  }
							}
						});
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(237, 10, 953, 630);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
		
	}
	}


