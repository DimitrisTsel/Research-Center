import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TheMembers extends JFrame {
private JPanel contentPane;
private JTable table;  
public TheMembers() {
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
		
		JPanel panelExitFromMembers = new JPanel();
		panelExitFromMembers.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromMembers.setBounds(10, 600, 187, 27);
		panelMenu.add(panelExitFromMembers);
		
		JLabel lblExitFromMembers = new JLabel("Back");
		lblExitFromMembers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TheMembers.this.dispose();
				ShowMembers showMembers = new ShowMembers();
				showMembers.setVisible(true);
			}
		});
		panelExitFromMembers.add(lblExitFromMembers);
		
			JButton btnLoadTheMembers = new JButton("Load The Members");
			btnLoadTheMembers.setBounds(10, 43, 187, 21);
			panelMenu.add(btnLoadTheMembers);
			btnLoadTheMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
				  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
					   ResultSet myRs = null;	
				          myRs=stmt.executeQuery("select * from members");		      	
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


