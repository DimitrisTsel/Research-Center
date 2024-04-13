import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;

public class TheInfo extends JFrame {

	private JPanel contentPane;
	public TheInfo() {
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
		panelMenu.setBounds(0, 0, 232, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelExitFromClasses = new JPanel();
		panelExitFromClasses.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromClasses.setBounds(10, 589, 212, 27);
		panelMenu.add(panelExitFromClasses);
		
		JLabel lblExitFromClasses = new JLabel("Exit from Info");
		lblExitFromClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TheInfo.this.dispose();
				MainMenu mainMenu = new MainMenu();
				mainMenu.setVisible(true);
			}
		});
		panelExitFromClasses.add(lblExitFromClasses);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 10, 948, 630);
		contentPane.add(scrollPane);
		
		JLabel lblTitle = new JLabel("\"ZELIOS RESEARCH CENTER");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setColumnHeaderView(lblTitle);
		
		JTextPane txtpnVrvrrv = new JTextPane();
		scrollPane.setRowHeaderView(txtpnVrvrrv);
		txtpnVrvrrv.setText("HISTORY AND OVERVIEW\r\n\t\t\t\t\r\nOur research center  was established in 1990.\r\nThe research areas are: Artificial Intelligence, Networks, Robotics, Big Data, Anntenas.\r\nThe research center is characterized by its involvement in data science and business intelligence, which aim to find artificial intelligence techniques in\r\nbusiness sectors, as well as many other fields. ZELIOS research center has invested in research around Artificial Intelligence, networks, big data, robotics and anntenas with significant results in each area.\r\n\r\nFinally, our research has been applied in many fields such as data analysis, cloud computing, neural networks and 5G through various research projects, especially in recent years.\r\n\t\r\n\t\t\t\r\nCLASSES\r\n\t\t\t\t\r\nWe attach great importance to the transmission of knowledge aiming at the evolution of the new generation to continue our work for this reason we have created classes at undergraduate and postgraduate level where they will receive the necessary scientific knowledge for individual and social technological development the classes we maintain in the laboratory are:\n\n"+"\r\n\t\t\t\t\t\r\nUndergraduate level:\r\n\tMathematics\r\n\tPhysics\r\n\tComputer Science\r\n\t\t\t\t\r\nPostgraduate level:\r\n\tMsc in Artificial Intelligence\r\n\tMsc in Data Science\r\n\tMsc in Technologies for Health");
		
		
	}
}