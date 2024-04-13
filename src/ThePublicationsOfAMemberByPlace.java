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

public class ThePublicationsOfAMemberByPlace extends JFrame {
	
	private JPanel contentPane;
	private JTable table;  
	private JTextField textField;
	public ThePublicationsOfAMemberByPlace() {
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
		panelMenu.setBounds(0, 0, 242, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
			
			JPanel panelExitFromPublicationsOfAMemberByPlace = new JPanel();
			panelExitFromPublicationsOfAMemberByPlace.setBackground(SystemColor.activeCaptionBorder);
			panelExitFromPublicationsOfAMemberByPlace.setBounds(10, 598, 222, 27);
			panelMenu.add(panelExitFromPublicationsOfAMemberByPlace);
			
			JLabel lblExitFromShowPublicationsByPlace = new JLabel("Back");
			lblExitFromShowPublicationsByPlace.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ThePublicationsOfAMemberByPlace.this.dispose();
					ShowPublications showPublications = new ShowPublications();
					showPublications.setVisible(true);
				}
			});
			panelExitFromPublicationsOfAMemberByPlace.add(lblExitFromShowPublicationsByPlace);
			
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
					  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
						   ResultSet myRs = null;	
					          String query= "EXEC viewIndividualPublicationsByPlace @mid=?";
					        		  PreparedStatement pst=con.prepareStatement(query);	
					         pst.setString(1, textField.getText());
					          table.setModel(DbUtils.resultSetToTableModel(myRs));
					          myRs=pst.executeQuery();
					  } catch (SQLException e1) {
								e1.printStackTrace();
					  }
				}
				
			});
			textField.setBounds(10, 50, 222, 19);
			panelMenu.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Select the ID of the member");
			lblNewLabel.setBounds(10, 31, 222, 13);
			panelMenu.add(lblNewLabel);
			
					JButton btnLoadThePublicationsOfAMemberByPlace= new JButton("Load pubs of a member by place");
					btnLoadThePublicationsOfAMemberByPlace.setBounds(0, 270, 242, 39);
					panelMenu.add(btnLoadThePublicationsOfAMemberByPlace);
					btnLoadThePublicationsOfAMemberByPlace.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
						  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
							   ResultSet myRs = null;	
						          myRs=stmt.executeQuery("EXEC viewIndividualPublicationsByPlace @mid="+textField.getText());		      	
						          table.setModel(DbUtils.resultSetToTableModel(myRs));
						  } catch (SQLException e1) {
									e1.printStackTrace();
						  }
							}
						});
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(252, 10, 938, 630);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
		
	}
	}


