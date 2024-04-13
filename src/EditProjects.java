
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditProjects extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldProjId;
	private JTextField textFieldProjName;
	private JTextField textFieldProjSubj;
	private JTextField textFieldProjStatus;
	private JTable table;
	public EditProjects() {
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
		JPanel panelEditProjects= new JPanel();
		panelEditProjects.setBackground(SystemColor.controlHighlight);
		panelEditProjects.setBounds(0, 0, 171, 650);
		contentPane.add(panelEditProjects);
		panelEditProjects.setLayout(null);
		
		JLabel lblProjId = new JLabel("Project ID");
		lblProjId.setBounds(10, 65, 76, 13);
		panelEditProjects.add(lblProjId);
		
		textFieldProjId = new JTextField();
		textFieldProjId.setBounds(10, 88, 140, 19);
		panelEditProjects.add(textFieldProjId);
		textFieldProjId.setColumns(10);
		
		JLabel lblProjName = new JLabel("Name");
		lblProjName.setBounds(10, 118, 76, 13);
		panelEditProjects.add(lblProjName);
		
		textFieldProjName = new JTextField();
		textFieldProjName.setBounds(10, 134, 140, 19);
		panelEditProjects.add(textFieldProjName);
		textFieldProjName.setColumns(10);
		
		JLabel lblProjSubj = new JLabel("Subject");
		lblProjSubj.setBounds(10, 163, 76, 13);
		panelEditProjects.add(lblProjSubj);
		
		textFieldProjSubj = new JTextField();
		textFieldProjSubj.setBounds(10, 176, 140, 19);
		panelEditProjects.add(textFieldProjSubj);
		textFieldProjSubj.setColumns(10);
		
		JLabel lblProjStatus = new JLabel("Status");
		lblProjStatus.setBounds(10, 205, 55, 13);
		panelEditProjects.add(lblProjStatus);
		
		textFieldProjStatus = new JTextField();
		textFieldProjStatus.setBounds(10, 216, 140, 19);
		panelEditProjects.add(textFieldProjStatus);
		textFieldProjStatus.setColumns(10);
		
		JButton btnInsertProjSubmit = new JButton("Insert");			
		btnInsertProjSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="insert into research_projects (proj_id, proj_name, proj_subj, proj_status) values (?, ?, ?, ?)";
			          		PreparedStatement stmt=con.prepareStatement(query);
			    			stmt.setInt(1, Integer.parseInt(textFieldProjId.getText()));
			          		stmt.setString(2, textFieldProjName.getText());
			    			stmt.setString(3, textFieldProjSubj.getText());
			    			stmt.setString(4, textFieldProjStatus.getText());   			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Insert completed" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnInsertProjSubmit.setBounds(31, 446, 103, 21);
		panelEditProjects.add(btnInsertProjSubmit);
		
		JPanel panelExitFromEditProjects = new JPanel();
		panelExitFromEditProjects.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromEditProjects.setBounds(10, 586, 151, 27);
		panelEditProjects.add(panelExitFromEditProjects);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditProjects.this.dispose();
				SignInAsAdmin signInAsAdmin = new SignInAsAdmin();
				signInAsAdmin.setVisible(true);
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelExitFromEditProjects.add(lblBack);
		
		JButton btnDelete_1_1 = new JButton("Delete");
		btnDelete_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="delete from research_projects where proj_id='"+textFieldProjId.getText()+"'" ;
			          		PreparedStatement stmt=con.prepareStatement(query);
			    				    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data deleted" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnDelete_1_1.setBounds(31, 502, 103, 21);
		panelEditProjects.add(btnDelete_1_1);
		
		
		
		
		
		JButton btnUpdateProjects = new JButton("Update");
		btnUpdateProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="update research_projects set proj_id='"+textFieldProjId.getText()+"',proj_name='"+textFieldProjName.getText()+"',proj_subj='"+textFieldProjSubj.getText()+"',proj_status='"+textFieldProjStatus.getText()+"' where proj_id='"+textFieldProjId.getText()+"' ";
			          		PreparedStatement stmt=con.prepareStatement(query);
			    				    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data updated" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnUpdateProjects.setBounds(31, 471, 103, 21);
		panelEditProjects.add(btnUpdateProjects);
		
		JButton btnLoadProjects = new JButton("Load");
		btnLoadProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
				  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
					   ResultSet myRs = null;	
				          myRs=stmt.executeQuery("select * from research_projects");		      	
				          table.setModel(DbUtils.resultSetToTableModel(myRs));
				  } catch (SQLException e1) {
							e1.printStackTrace();
				  }
			}
		});
		btnLoadProjects.setBounds(1046, 4, 129, 21);
		contentPane.add(btnLoadProjects);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 35, 975, 592);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}

}
