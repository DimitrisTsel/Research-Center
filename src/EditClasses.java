
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

public class EditClasses extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldClassId;
	private JTextField textFieldClassName;
	private JTextField textFieldClassType;
	private JTable table;
	public EditClasses() {
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
		JPanel panelEditClasses= new JPanel();
		panelEditClasses.setBackground(SystemColor.controlHighlight);
		panelEditClasses.setBounds(0, 0, 171, 650);
		contentPane.add(panelEditClasses);
		panelEditClasses.setLayout(null);
		
		JLabel lblClassId = new JLabel("Class ID");
		lblClassId.setBounds(10, 126, 76, 13);
		panelEditClasses.add(lblClassId);
		
		textFieldClassId = new JTextField();
		textFieldClassId.setBounds(10, 137, 140, 19);
		panelEditClasses.add(textFieldClassId);
		textFieldClassId.setColumns(10);
		
		JLabel lblClassName = new JLabel("Name");
		lblClassName.setBounds(10, 178, 76, 13);
		panelEditClasses.add(lblClassName);
		
		textFieldClassName = new JTextField();
		textFieldClassName.setBounds(10, 194, 140, 19);
		panelEditClasses.add(textFieldClassName);
		textFieldClassName.setColumns(10);
		
		JLabel lblType = new JLabel("Level");
		lblType.setBounds(10, 234, 76, 13);
		panelEditClasses.add(lblType);
		
		textFieldClassType = new JTextField();
		textFieldClassType.setBounds(10, 247, 140, 19);
		panelEditClasses.add(textFieldClassType);
		textFieldClassType.setColumns(10);
		
		JButton btnInsertClassSubmit = new JButton("Insert");			
		btnInsertClassSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="insert into classes (class_id, class_name, class_type) values (?, ?, ?)";
			          		PreparedStatement stmt=con.prepareStatement(query);
			    			stmt.setInt(1, Integer.parseInt(textFieldClassId.getText()));
			          		stmt.setString(2, textFieldClassName.getText());
			    			stmt.setString(3, textFieldClassType.getText());  			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Insert completed" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnInsertClassSubmit.setBounds(32, 437, 103, 21);
		panelEditClasses.add(btnInsertClassSubmit);
		
		JPanel panelExitFromEditClasses = new JPanel();
		panelExitFromEditClasses.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromEditClasses.setBounds(10, 591, 151, 27);
		panelEditClasses.add(panelExitFromEditClasses);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditClasses.this.dispose();
				SignInAsAdmin signInAsAdmin = new SignInAsAdmin();
				signInAsAdmin.setVisible(true);
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelExitFromEditClasses.add(lblBack);
		
		JButton btnDelete_1_1 = new JButton("Delete");
		btnDelete_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="delete from classes where class_id='"+textFieldClassId.getText()+"'" ;
			          		PreparedStatement stmt=con.prepareStatement(query);
			    				    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data deleted" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnDelete_1_1.setBounds(32, 493, 103, 21);
		panelEditClasses.add(btnDelete_1_1);
		
		
		
		
		
		JButton btnUpdateClasses = new JButton("Update");
		btnUpdateClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="update classes set class_id='"+textFieldClassId.getText()+"',class_name='"+textFieldClassName.getText()+"',class_type='"+textFieldClassType.getText()+"' where class_id='"+textFieldClassId.getText()+"' ";
			          		PreparedStatement stmt=con.prepareStatement(query);
			    				    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data updated" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnUpdateClasses.setBounds(32, 462, 103, 21);
		panelEditClasses.add(btnUpdateClasses);
		
		JButton btnLoadClasses = new JButton("Load");
		btnLoadClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
				  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
					   ResultSet myRs = null;	
				          myRs=stmt.executeQuery("select * from classes");		      	
				          table.setModel(DbUtils.resultSetToTableModel(myRs));
				  } catch (SQLException e1) {
							e1.printStackTrace();
				  }
			}
		});
		btnLoadClasses.setBounds(1061, 0, 129, 21);
		contentPane.add(btnLoadClasses);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 24, 990, 604);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}

}
