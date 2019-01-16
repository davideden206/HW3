package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.Manager;
import src.Program;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	static Manager maneger;
	private JPanel contentPane;

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
		
		// נשאר להוסיף ליסינר ליציאה ןעידכון הקובץ וליסינר להוספת מנהל חדש
		JButton btnAddManager = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05E0\u05D4\u05DC");
		btnAddManager.setBounds(242, 104, 178, 25);
		btnAddManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(btnAddManager);
		
		JButton btnSaveExit = new JButton("\u05E9\u05DE\u05D5\u05E8 \u05D5\u05E6\u05D0");
		btnSaveExit.setBounds(12, 202, 115, 38);
		contentPane.add(btnSaveExit);
		
		JButton disply_schduale = new JButton("\u05D4\u05E6\u05D2\u05EA \u05DC\u05D5\u05D6");
		disply_schduale.setBounds(242, 32, 178, 23);
		contentPane.add(disply_schduale);
		
		disply_schduale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowSchedualeByQuery show = new ShowSchedualeByQuery();
				show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				show.setVisible(true);
				
			}
		});
		
		JButton displayByDay = new JButton("\u05D4\u05E6\u05D2\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA \u05DC\u05E4\u05D9 \u05D9\u05D5\u05DD");
		displayByDay.setBounds(242, 68, 178, 23);
		contentPane.add(displayByDay);
		
		
		
		displayByDay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowSchedualeByQuery show = new ShowSchedualeByQuery();
				show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				show.setVisible(true);
				
			}
		});
		
		
		
		if (m!=null) {
			
		
		JButton updat_delet_program = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4 / \u05E2\u05D3\u05DB\u05D5\u05DF \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		updat_delet_program.setBounds(242, 140, 178, 23);
		contentPane.add(updat_delet_program);
		
		updat_delet_program.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Update_delete_program ud = new Update_delete_program();
				ud.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				ud.setVisible(true);
				
			}
		});

		
		    
		JButton addProgram = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		addProgram.setBounds(242, 104, 178, 23);
		contentPane.add(addProgram);
		
		addProgram.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddPogramsFrame addprogram = new AddPogramsFrame(null, null);
				addprogram.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				addprogram.setVisible(true);
			}
		});
		
		}
		else {
		
		JButton display_by_price = new JButton("\u05D4\u05E6\u05D2\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA \u05DC\u05E4\u05D9 \u05DE\u05D7\u05D9\u05E8");
		display_by_price.setBounds(24, 32, 178, 23);
		contentPane.add(display_by_price);
		
		JButton btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05E0\u05D4\u05DC");
		btnNewButton.setBounds(24, 67, 178, 25);
		contentPane.add(btnNewButton);
		
		display_by_price.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowSchedualeByQuery show = new ShowSchedualeByQuery();
				show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				show.setVisible(true);
				
			}
		});
		
	}
}
}
