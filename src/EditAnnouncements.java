
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

public class EditAnnouncements extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAnnouncementId;
	private JTextField textFieldAnnouncementDate;
	private JTextField textFieldAnnDesc;
	private JTable table;
	private JTextField textFieldAnnText;
	private JTextField textFieldClassId;
	private JTextField textFieldPubId;
	private JTextField textFieldProjId;
	public EditAnnouncements() {
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
		JPanel panelEditAnnouncements= new JPanel();
		panelEditAnnouncements.setBackground(SystemColor.controlHighlight);
		panelEditAnnouncements.setBounds(0, 0, 171, 650);
		contentPane.add(panelEditAnnouncements);
		panelEditAnnouncements.setLayout(null);
		
		JLabel lblAnnouncementId = new JLabel("Announcement ID");
		lblAnnouncementId.setBounds(10, 85, 124, 13);
		panelEditAnnouncements.add(lblAnnouncementId);
		
		textFieldAnnouncementId = new JTextField();
		textFieldAnnouncementId.setBounds(10, 96, 140, 19);
		panelEditAnnouncements.add(textFieldAnnouncementId);
		textFieldAnnouncementId.setColumns(10);
		
		JLabel lblAnnDate = new JLabel("Date");
		lblAnnDate.setBounds(10, 125, 76, 13);
		panelEditAnnouncements.add(lblAnnDate);
		
		textFieldAnnouncementDate = new JTextField();
		textFieldAnnouncementDate.setBounds(10, 141, 140, 19);
		panelEditAnnouncements.add(textFieldAnnouncementDate);
		textFieldAnnouncementDate.setColumns(10);
		
		JLabel lblAnnDesc = new JLabel("Description");
		lblAnnDesc.setBounds(10, 182, 76, 13);
		panelEditAnnouncements.add(lblAnnDesc);
		
		textFieldAnnDesc = new JTextField();
		textFieldAnnDesc.setBounds(10, 195, 140, 19);
		panelEditAnnouncements.add(textFieldAnnDesc);
		textFieldAnnDesc.setColumns(10);
		
		JButton btnInsertAnnouncementSubmit = new JButton("Insert");			
		btnInsertAnnouncementSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="insert into announcements (announcement_id, announcement_date, announcement_desc, announcement_text, class_id, pub_id, proj_id) values (?, ?, ?, ?, ?, ?, ?)";
			          		PreparedStatement stmt=con.prepareStatement(query);
			    			stmt.setInt(1, Integer.parseInt(textFieldAnnouncementId.getText()));
			          		stmt.setString(2, textFieldAnnouncementDate.getText());
			    			stmt.setString(3, textFieldAnnDesc.getText());  
			    			stmt.setString(4, textFieldAnnText.getText());
			    			stmt.setString(5, textFieldClassId.getText());
			    			stmt.setString(6, textFieldPubId.getText());
			    			stmt.setString(7, textFieldProjId.getText());
			    			if(textFieldClassId.getText().equals("")) {
			    				stmt.setNull(5, java.sql.Types.NULL);
			    			}else {
			    				stmt.setString(5, textFieldClassId.getText());
			    			}
			    			if(textFieldPubId.getText().equals("")) {
			    				stmt.setNull(6, java.sql.Types.NULL);
			    			}else {
			    				stmt.setString(6, textFieldPubId.getText());
			    			}
			    			if(textFieldProjId.getText().equals("")) {
			    				stmt.setNull(7, java.sql.Types.NULL);
			    			}else {
			    				stmt.setString(7, textFieldProjId.getText());
			    			}
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Insert completed" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnInsertAnnouncementSubmit.setBounds(31, 441, 103, 21);
		panelEditAnnouncements.add(btnInsertAnnouncementSubmit);
		
		JPanel panelExitFromEditClasses = new JPanel();
		panelExitFromEditClasses.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromEditClasses.setBounds(10, 599, 151, 27);
		panelEditAnnouncements.add(panelExitFromEditClasses);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditAnnouncements.this.dispose();
				SignInAsAdmin signInAsAdmin = new SignInAsAdmin();
				signInAsAdmin.setVisible(true);
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelExitFromEditClasses.add(lblBack);
		
		JButton btnDeleteAnnouncement = new JButton("Delete");
		btnDeleteAnnouncement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="delete from announcements where announcement_id='"+textFieldAnnouncementId.getText()+"'" ;
			          		PreparedStatement stmt=con.prepareStatement(query);
			    				    			
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data deleted" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnDeleteAnnouncement.setBounds(31, 497, 103, 21);
		panelEditAnnouncements.add(btnDeleteAnnouncement);
		
		
		
		
		
		JButton btnUpdateAnnouncement = new JButton("Update");
		btnUpdateAnnouncement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
			        try (Connection con = DriverManager.getConnection(connectionUrl); ) {
			        				      
			        	  String query="update announcements set announcement_id=?,announcement_date=?,announcement_desc=? ,announcement_text=?,class_id=? ,pub_id=? ,proj_id=? where announcement_id='"+textFieldAnnouncementId.getText()+"' ";
			        	  PreparedStatement stmt=con.prepareStatement(query);
			    			stmt.setInt(1, Integer.parseInt(textFieldAnnouncementId.getText()));
			          		stmt.setString(2, textFieldAnnouncementDate.getText());
			    			stmt.setString(3, textFieldAnnDesc.getText());  
			    			stmt.setString(4, textFieldAnnText.getText());
			    			stmt.setString(5, textFieldClassId.getText());
			    			stmt.setString(6, textFieldPubId.getText());
			    			stmt.setString(7, textFieldProjId.getText());
			    			if(textFieldClassId.getText().equals("")) {
			    				stmt.setNull(5, java.sql.Types.NULL);
			    			}else {
			    				stmt.setString(5, textFieldClassId.getText());
			    			}
			    			if(textFieldPubId.getText().equals("")) {
			    				stmt.setNull(6, java.sql.Types.NULL);
			    			}else {
			    				stmt.setString(6, textFieldPubId.getText());
			    			}
			    			if(textFieldProjId.getText().equals("")) {
			    				stmt.setNull(7, java.sql.Types.NULL);
			    			}else {
			    				stmt.setString(7, textFieldProjId.getText());
			    			}
			      
			    			stmt.executeUpdate();
			    			JOptionPane.showMessageDialog(null,"Data updated" );
			       
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
			
		});
		btnUpdateAnnouncement.setBounds(31, 466, 103, 21);
		panelEditAnnouncements.add(btnUpdateAnnouncement);
		
		textFieldAnnText = new JTextField();
		textFieldAnnText.setColumns(10);
		textFieldAnnText.setBounds(10, 247, 140, 19);
		panelEditAnnouncements.add(textFieldAnnText);
		
		JLabel lblAnnText = new JLabel("Text");
		lblAnnText.setBounds(10, 234, 76, 13);
		panelEditAnnouncements.add(lblAnnText);
		
		textFieldClassId = new JTextField();
		textFieldClassId.setColumns(10);
		textFieldClassId.setBounds(10, 292, 140, 19);
		panelEditAnnouncements.add(textFieldClassId);
		
		textFieldPubId = new JTextField();
		textFieldPubId.setColumns(10);
		textFieldPubId.setBounds(10, 333, 140, 19);
		panelEditAnnouncements.add(textFieldPubId);
		
		textFieldProjId = new JTextField();
		textFieldProjId.setColumns(10);
		textFieldProjId.setBounds(10, 385, 140, 19);
		panelEditAnnouncements.add(textFieldProjId);
		
		JLabel lblAnnClassId = new JLabel("Class ID");
		lblAnnClassId.setBounds(10, 276, 76, 13);
		panelEditAnnouncements.add(lblAnnClassId);
		
		JLabel lblAnnPubId = new JLabel("Publication ID");
		lblAnnPubId.setBounds(10, 321, 124, 13);
		panelEditAnnouncements.add(lblAnnPubId);
		
		JLabel lblAnnProjId = new JLabel("Research_Project ID");
		lblAnnProjId.setBounds(10, 372, 124, 13);
		panelEditAnnouncements.add(lblAnnProjId);
		
		JButton btnLoadAnnouncements = new JButton("Load");
		btnLoadAnnouncements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ResearchLab;integratedSecurity=true;";
				  try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
					   ResultSet myRs = null;	
				          myRs=stmt.executeQuery("select * from announcements");		      	
				          table.setModel(DbUtils.resultSetToTableModel(myRs));
				  } catch (SQLException e1) {
							e1.printStackTrace();
				  }
			}
		});
		btnLoadAnnouncements.setBounds(1061, 2, 129, 21);
		contentPane.add(btnLoadAnnouncements);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 33, 999, 594);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
}