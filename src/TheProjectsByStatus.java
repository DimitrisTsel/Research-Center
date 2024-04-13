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

public class TheProjectsByStatus extends JFrame {

	private JPanel contentPane;
	private JTable table;  
	public TheProjectsByStatus() {
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
			
			JPanel panelExitFromProjectsByStatus = new JPanel();
			panelExitFromProjectsByStatus.setBackground(SystemColor.activeCaptionBorder);
			panelExitFromProjectsByStatus.setBounds(10, 566, 187, 27);
			panelMenu.add(panelExitFromProjectsByStatus);
			
			JLabel lblExitFromProjectsByStatus = new JLabel("Back");
			lblExitFromProjectsByStatus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TheProjectsByStatus.this.dispose();
					ShowProjects showProjects = new ShowProjects();
					showProjects.setVisible(true);
				}
			});
			panelExitFromProjectsByStatus.add(lblExitFromProjectsByStatus);
			
					JButton btnLoadTheProjectsByStatus = new JButton("Load projects by status ");
					btnLoadTheProjectsByStatus.setBounds(10, 37, 187, 27);
					panelMenu.add(btnLoadTheProjectsByStatus);
					btnLoadTheProjectsByStatus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
						  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
							   ResultSet myRs = null;	
						          myRs=stmt.executeQuery(" EXEC viewProjectsByStatus");		      	
						          table.setModel(DbUtils.resultSetToTableModel(myRs));
						  } catch (SQLException e1) {
									e1.printStackTrace();
						  }
							}
						});
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(217, 10, 973, 630);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
		
	}
	}


