
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

public class EditPublications extends JFrame {


	private JPanel contentPane;
	private JTextField textFieldPubId;
	private JTextField textFieldPubSubj;
	private JTextField textFieldPubDate;
	private JTextField textFieldPubPlace;
	private JTextField textFieldPubTitle;
	private JTextField textFieldPubText;
	private JTextField textFieldPubAbstract;
	private JTable table;
	public EditPublications() {
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
		JPanel panelEditPublications= new JPanel();
		panelEditPublications.setBackground(SystemColor.controlHighlight);
		panelEditPublications.setBounds(0, 0, 171, 650);
		contentPane.add(panelEditPublications);
		panelEditPublications.setLayout(null);
		
		JLabel lblInsertPubId = new JLabel("Publication ID");
		lblInsertPubId.setBounds(10, 31, 76, 13);
		panelEditPublications.add(lblInsertPubId);
		
		textFieldPubId = new JTextField();
		textFieldPubId.setBounds(10, 42, 140, 19);
		panelEditPublications.add(textFieldPubId);
		textFieldPubId.setColumns(10);
		
		JLabel lblPubSubj = new JLabel("Subject");
		lblPubSubj.setBounds(10, 72, 76, 13);
		panelEditPublications.add(lblPubSubj);
		
		textFieldPubSubj = new JTextField();
		textFieldPubSubj.setBounds(10, 88, 140, 19);
		panelEditPublications.add(textFieldPubSubj);
		textFieldPubSubj.setColumns(10);
		
		JLabel lblPubDate = new JLabel("Date");
		lblPubDate.setBounds(10, 117, 76, 13);
		panelEditPublications.add(lblPubDate);
		
		textFieldPubDate = new JTextField();
		textFieldPubDate.setBounds(10, 130, 140, 19);
		panelEditPublications.add(textFieldPubDate);
		textFieldPubDate.setColumns(10);
		
		JLabel lblPubPlace = new JLabel("Published in");
		lblPubPlace.setBounds(10, 159, 55, 13);
		panelEditPublications.add(lblPubPlace);
		
		textFieldPubPlace = new JTextField();
		textFieldPubPlace.setBounds(10, 170, 140, 19);
		panelEditPublications.add(textFieldPubPlace);
		textFieldPubPlace.setColumns(10);
		
		JLabel lblPubTitle = new JLabel("Title");
		lblPubTitle.setBounds(10, 200, 55, 13);
		panelEditPublications.add(lblPubTitle);
		
		textFieldPubTitle = new JTextField();
		textFieldPubTitle.setBounds(10, 212, 140, 19);
		panelEditPublications.add(textFieldPubTitle);
		textFieldPubTitle.setColumns(10);
		
		JLabel lblPubText = new JLabel("Text");
		lblPubText.setBounds(10, 241, 45, 13);
		panelEditPublications.add(lblPubText);
		
		textFieldPubText = new JTextField();
		textFieldPubText.setBounds(10, 255, 140, 19);
		panelEditPublications.add(textFieldPubText);
		textFieldPubText.setColumns(10);
		
		JLabel lblPubAbstract = new JLabel("Abstract");
		lblPubAbstract.setBounds(10, 284, 89, 13);
		panelEditPublications.add(lblPubAbstract);
		
		textFieldPubAbstract = new JTextField();
		textFieldPubAbstract.setColumns(10);
		textFieldPubAbstract.setBounds(10, 298, 140, 19);
		panelEditPublications.add(textFieldPubAbstract);
		
		JButton btnInsertPubSubmit = new JButton("Insert");			
		btnInsertPubSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="insert into publications (pub_id, pub_subj, pub_date, pub_place, pub_title ,pub_text, pub_abstract) values (?, ?, ?, ?, ?, ?, ?)";
			          		PreparedStatement stmt=con.prepareStatement(query);
			    			stmt.setInt(1, Integer.parseInt(textFieldPubId.getText()));
			          		stmt.setString(2, textFieldPubSubj.getText());
			    			stmt.setString(3, textFieldPubDate.getText());
			    			stmt.setString(4, textFieldPubPlace.getText());
			    			stmt.setString(5, textFieldPubTitle.getText());
			    			stmt.setString(6, textFieldPubText.getText());
			    			stmt.setString(7, textFieldPubAbstract.getText());		    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Insert completed" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnInsertPubSubmit.setBounds(29, 445, 103, 21);
		panelEditPublications.add(btnInsertPubSubmit);
		
		JPanel panelExitFromEditPublications = new JPanel();
		panelExitFromEditPublications.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromEditPublications.setBounds(10, 598, 151, 27);
		panelEditPublications.add(panelExitFromEditPublications);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditPublications.this.dispose();
				SignInAsAdmin signInAsAdmin = new SignInAsAdmin();
				signInAsAdmin.setVisible(true);
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelExitFromEditPublications.add(lblBack);
		
		JButton btnDelete_1_1 = new JButton("Delete");
		btnDelete_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="delete from publications where pub_id='"+textFieldPubId.getText()+"'" ;
			          		PreparedStatement stmt=con.prepareStatement(query);
			    				    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data deleted" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnDelete_1_1.setBounds(29, 501, 103, 21);
		panelEditPublications.add(btnDelete_1_1);
		
		
		
		
		
		JButton btnUpdatePublications = new JButton("Update");
		btnUpdatePublications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="update publications set pub_id='"+textFieldPubId.getText()+"',pub_subj='"+textFieldPubSubj.getText()+"',pub_date='"+textFieldPubDate.getText()+"',pub_place='"+textFieldPubPlace.getText()+"',pub_title='"+textFieldPubTitle.getText()+"',pub_text='"+textFieldPubText.getText()+"',pub_abstract='"+textFieldPubAbstract.getText()+"' where pub_id='"+textFieldPubId.getText()+"' ";
			          		PreparedStatement stmt=con.prepareStatement(query);
			    				    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data updated" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnUpdatePublications.setBounds(29, 470, 103, 21);
		panelEditPublications.add(btnUpdatePublications);
		
		JButton btnLoadPubs = new JButton("Load");
		btnLoadPubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
				  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
					   ResultSet myRs = null;	
				          myRs=stmt.executeQuery("select * from publications");		      	
				          table.setModel(DbUtils.resultSetToTableModel(myRs));
				  } catch (SQLException e1) {
							e1.printStackTrace();
				  }
			}
		});
		btnLoadPubs.setBounds(1046, 10, 129, 21);
		contentPane.add(btnLoadPubs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 34, 986, 594);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
}
