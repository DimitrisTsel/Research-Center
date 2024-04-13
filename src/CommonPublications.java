import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CommonPublications extends JFrame {
	private JPanel contentPane;
	private JTable table;  
	private JTextField textFieldCommonPub;
	public CommonPublications() {
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
			
			JPanel panelExitFromShowPublicationsOfAMember = new JPanel();
			panelExitFromShowPublicationsOfAMember.setBackground(SystemColor.activeCaptionBorder);
			panelExitFromShowPublicationsOfAMember.setBounds(10, 535, 187, 27);
			panelMenu.add(panelExitFromShowPublicationsOfAMember);
			
			JLabel lblExitFromShowPublicationsOfAMember = new JLabel("Back");
			lblExitFromShowPublicationsOfAMember.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CommonPublications.this.dispose();
					ShowPublications showPublications = new ShowPublications();
					showPublications.setVisible(true);
				}
			});
			panelExitFromShowPublicationsOfAMember.add(lblExitFromShowPublicationsOfAMember);
			
			textFieldCommonPub = new JTextField();
			textFieldCommonPub.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
					  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
						   ResultSet myRs = null;	
					          String query= "EXEC CommonPublications @pub_id=?";
					        		  PreparedStatement pst=con.prepareStatement(query);	
					         pst.setString(1, textFieldCommonPub.getText());
					          table.setModel(DbUtils.resultSetToTableModel(myRs));
					          myRs=pst.executeQuery();
					  } catch (SQLException e1) {
								e1.printStackTrace();
					  }
				}
				
			});
			textFieldCommonPub.setBounds(10, 92, 187, 19);
			panelMenu.add(textFieldCommonPub);
			textFieldCommonPub.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Select the ID of a Publication");
			lblNewLabel.setBounds(10, 73, 170, 13);
			panelMenu.add(lblNewLabel);
			
					JButton btnLoadTheCommonPubs= new JButton("Load members ");
					btnLoadTheCommonPubs.setBounds(0, 138, 207, 45);
					panelMenu.add(btnLoadTheCommonPubs);
					btnLoadTheCommonPubs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
						  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
							   ResultSet myRs = null;	
						          myRs=stmt.executeQuery("EXEC CommonPublications @pub_id="+textFieldCommonPub.getText());		      	
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


