package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.BCM;
import src.Manager;
import src.Program;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	public static Manager maneger;
	private JPanel contentPane;
	private JButton btnAddManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu(Manager m ) {
		this.maneger = m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnSaveExit = new JButton("\u05E9\u05DE\u05D5\u05E8 \u05D5\u05E6\u05D0");
		btnSaveExit.setBounds(12, 202, 115, 38);
		contentPane.add(btnSaveExit);
		
		//When you click the button, it exits the system and saves the data
		btnSaveExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BCM.saveSchedule();
				setDefaultLookAndFeelDecorated(getFocusTraversalKeysEnabled());
				dispose();
				
			}
		});
		
		
		JButton disply_schduale = new JButton("\u05D4\u05E6\u05D2\u05EA \u05DC\u05D5\u05D6");
		disply_schduale.setBounds(242, 32, 178, 23);
		contentPane.add(disply_schduale);
		
		//When you click the button, a page displays the weekly programs
		disply_schduale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowScheduale s = new ShowScheduale();
				s.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				s.setVisible(true);
				
			}
		});
		
		JButton displayByDay = new JButton("\u05D4\u05E6\u05D2\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA \u05DC\u05E4\u05D9 \u05D9\u05D5\u05DD");
		displayByDay.setBounds(242, 68, 178, 23);
		contentPane.add(displayByDay);
		
		//Clicking the button moves to the program display page by day
		displayByDay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowSchedualeByDay show = new ShowSchedualeByDay();
				show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				show.setVisible(true);
				
			}
		});
		
		JButton updat_delet_program = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4 / \u05E2\u05D3\u05DB\u05D5\u05DF \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		updat_delet_program.setBounds(242, 140, 178, 23);
		contentPane.add(updat_delet_program);
		updat_delet_program.setVisible(false);
		
		JButton addProgram = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		addProgram.setBounds(242, 104, 178, 23);
		contentPane.add(addProgram);
		addProgram.setVisible(false);
		
		btnAddManager = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05E0\u05D4\u05DC");
		btnAddManager.setBounds(24, 67, 178, 25);
		contentPane.add(btnAddManager);
		btnAddManager.setVisible(false);
		
		
		JButton display_by_price = new JButton("\u05D4\u05E6\u05D2\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA \u05DC\u05E4\u05D9 \u05DE\u05D7\u05D9\u05E8");
		display_by_price.setBounds(24, 32, 178, 23);
		contentPane.add(display_by_price);
		display_by_price.setVisible(false);
		
		if (m!=null) {
			
			updat_delet_program.setVisible(true);

		//By pressing the button moves to the delete page or program update
		updat_delet_program.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Update_delete_program ud = new Update_delete_program();
				ud.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				ud.setVisible(true);
				
			}
		});

		addProgram.setVisible(true);
		
		//Clicking the button moves to the page of adding a new program
		addProgram.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddPogramsFrame addprogram = new AddPogramsFrame(maneger, null);
				addprogram.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				addprogram.setVisible(true);
			}
		});
		
		}
		else {
			btnAddManager.setVisible(true);
			//Clicking the button moves to the Add New Manager page
			btnAddManager.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AddManager am = new AddManager();
					am.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					am.setVisible(true);
					
				}
			});
			
			
			display_by_price.setVisible(true);
			
		//When you click the button, you move to the program display page based on the price a user enters	
		display_by_price.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DisplaySchedualeByPrice bp = new DisplaySchedualeByPrice();
				bp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				bp.setVisible(true);
				
			}
		});
		
	}
}
}
