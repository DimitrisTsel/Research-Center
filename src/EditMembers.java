
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

public class EditMembers extends JFrame {


	private JPanel contentPane;
	private JTextField textFieldMemberId;
	private JTextField textFieldFirstName;
	private JTextField textFieldMemberLname;
	private JTextField textFieldMemberWebPage;
	private JTextField textFieldMemberEmail;
	private JTextField textFieldMemberCv;
	private JTextField textFieldMemberDepId;
	private JTextField textFieldMemberTeacherId;
	private JTable table;
	public EditMembers() {
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
		JPanel panelEditMembers = new JPanel();
		panelEditMembers.setBackground(SystemColor.controlHighlight);
		panelEditMembers.setBounds(0, 0, 171, 650);
		contentPane.add(panelEditMembers);
		panelEditMembers.setLayout(null);
		
		JLabel lblInsertMemberId = new JLabel("Member ID");
		lblInsertMemberId.setBounds(10, 10, 55, 13);
		panelEditMembers.add(lblInsertMemberId);
		
		textFieldMemberId = new JTextField();
		textFieldMemberId.setBounds(10, 21, 140, 19);
		panelEditMembers.add(textFieldMemberId);
		textFieldMemberId.setColumns(10);
		
		JLabel lblMemberFname = new JLabel("First Name");
		lblMemberFname.setBounds(10, 51, 76, 13);
		panelEditMembers.add(lblMemberFname);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(10, 67, 140, 19);
		panelEditMembers.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblMemberLastName = new JLabel("Last Name");
		lblMemberLastName.setBounds(10, 96, 76, 13);
		panelEditMembers.add(lblMemberLastName);
		
		textFieldMemberLname = new JTextField();
		textFieldMemberLname.setBounds(10, 109, 140, 19);
		panelEditMembers.add(textFieldMemberLname);
		textFieldMemberLname.setColumns(10);
		
		JLabel lblWebPage = new JLabel("Web page");
		lblWebPage.setBounds(10, 138, 55, 13);
		panelEditMembers.add(lblWebPage);
		
		textFieldMemberWebPage = new JTextField();
		textFieldMemberWebPage.setBounds(10, 149, 140, 19);
		panelEditMembers.add(textFieldMemberWebPage);
		textFieldMemberWebPage.setColumns(10);
		
		JLabel lblMemberEmail = new JLabel("Email");
		lblMemberEmail.setBounds(10, 179, 55, 13);
		panelEditMembers.add(lblMemberEmail);
		
		textFieldMemberEmail = new JTextField();
		textFieldMemberEmail.setBounds(10, 191, 140, 19);
		panelEditMembers.add(textFieldMemberEmail);
		textFieldMemberEmail.setColumns(10);
		
		JLabel lblMemberCv = new JLabel("CV");
		lblMemberCv.setBounds(10, 220, 45, 13);
		panelEditMembers.add(lblMemberCv);
		
		textFieldMemberCv = new JTextField();
		textFieldMemberCv.setBounds(10, 234, 140, 19);
		panelEditMembers.add(textFieldMemberCv);
		textFieldMemberCv.setColumns(10);
		
		JLabel lblMemberDepartmentId = new JLabel("Department ID");
		lblMemberDepartmentId.setBounds(10, 273, 89, 13);
		panelEditMembers.add(lblMemberDepartmentId);
		
		textFieldMemberDepId = new JTextField();
		textFieldMemberDepId.setColumns(10);
		textFieldMemberDepId.setBounds(10, 287, 140, 19);
		panelEditMembers.add(textFieldMemberDepId);
		
		JButton btnInsertMemberSubmit = new JButton("Insert");			
		btnInsertMemberSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="insert into members (member_id, first_name, last_name, web_page, e_mail, cv, dep_id, teacher_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
			          		PreparedStatement stmt=con.prepareStatement(query);
			    			stmt.setInt(1, Integer.parseInt(textFieldMemberId.getText()));
			          		stmt.setString(2, textFieldFirstName.getText());
			    			stmt.setString(3, textFieldMemberLname.getText());
			    			stmt.setString(4, textFieldMemberWebPage.getText());
			    			stmt.setString(5, textFieldMemberEmail.getText());
			    			stmt.setString(6, textFieldMemberCv.getText());
			    			stmt.setInt(7, Integer.parseInt(textFieldMemberDepId.getText()));	
			    			stmt.setString(8, textFieldMemberTeacherId.getText());
			    			if(textFieldMemberTeacherId.getText().equals("")) {
			    				stmt.setNull(8, java.sql.Types.NULL);
			    			}else {
			    				stmt.setString(8, textFieldMemberTeacherId.getText());
			    			}
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Insert completed" );
			    			
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnInsertMemberSubmit.setBounds(31, 364, 103, 21);
		panelEditMembers.add(btnInsertMemberSubmit);
		
		JPanel panelExitFromInsertMembers = new JPanel();
		panelExitFromInsertMembers.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromInsertMembers.setBounds(10, 463, 140, 27);
		panelEditMembers.add(panelExitFromInsertMembers);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditMembers.this.dispose();
				SignInAsAdmin signInAsAdmin = new SignInAsAdmin();
				signInAsAdmin.setVisible(true);
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelExitFromInsertMembers.add(lblBack);
		
		JButton btnDelete_1_1 = new JButton("Delete");
		btnDelete_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="delete from members where member_id='"+textFieldMemberId.getText()+"'" ;
			          		PreparedStatement stmt=con.prepareStatement(query);
			    				    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data deleted" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnDelete_1_1.setBounds(31, 420, 103, 21);
		panelEditMembers.add(btnDelete_1_1);
		
		textFieldMemberTeacherId = new JTextField();
		textFieldMemberTeacherId.setColumns(10);
		textFieldMemberTeacherId.setBounds(10, 335, 140, 19);
		panelEditMembers.add(textFieldMemberTeacherId);
		
		JLabel lblMemberTeacherId = new JLabel("Teacher ID");
		lblMemberTeacherId.setBounds(10, 324, 89, 13);
		panelEditMembers.add(lblMemberTeacherId);
		
		JButton btnUpdateMember = new JButton("Update");
		btnUpdateMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="update members set member_id=?,first_name=?,last_name=?,web_page=?,e_mail=?,cv=?,dep_id=?,teacher_id=? where  member_id='"+textFieldMemberId.getText()+"' ";
			          		PreparedStatement stmt=con.prepareStatement(query);
			          		stmt.setInt(1, Integer.parseInt(textFieldMemberId.getText()));
			          		stmt.setString(2, textFieldFirstName.getText());
			    			stmt.setString(3, textFieldMemberLname.getText());
			    			stmt.setString(4, textFieldMemberWebPage.getText());
			    			stmt.setString(5, textFieldMemberEmail.getText());
			    			stmt.setString(6, textFieldMemberCv.getText());
			    			stmt.setInt(7, Integer.parseInt(textFieldMemberDepId.getText()));	
			    			stmt.setString(8, textFieldMemberTeacherId.getText()); 			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data updated" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnUpdateMember.setBounds(31, 389, 103, 21);
		panelEditMembers.add(btnUpdateMember);
		
		JButton btnLoadMembers = new JButton("Load");
		btnLoadMembers.addActionListener(new ActionListener() {
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
		btnLoadMembers.setBounds(1061, 10, 129, 21);
		contentPane.add(btnLoadMembers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(211, 40, 979, 588);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}

}
