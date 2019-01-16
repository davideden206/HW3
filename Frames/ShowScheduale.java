package Frames;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import src.BCM;
import src.Program;
import java.awt.Font;

public class ShowScheduale extends JFrame {
	private JTable table;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowScheduale frame = new ShowScheduale();
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
	public ShowScheduale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label = new JLabel("\u05DB\u05DC \u05D4\u05EA\u05D5\u05DB\u05E0\u05D9\u05D5\u05EA \u05D1\u05E9\u05D1\u05D5\u05E2");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(148, 11, 191, 21);
		contentPane.add(label);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 422, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		Object[][] o = new Object[50][8];
		for(int k = 0;k<50;k++) {
			for(int j = 0;j<8;j++) {
				o[k][j]=null;
			}
		}	
		
		DefaultTableModel model = new DefaultTableModel(o,
				new String[] {
						"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
				}
				);
		
		table.setEnabled(false);
		table.setModel(model);
		
		
		
				
				DefaultTableModel tmodel =  new DefaultTableModel(o,
						new String[] {
								"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
						}
						);
		int y=0;
		
		while(y<7) {
			int i =0;
			for (Program program : BCM.sch.getProgramsByDay(y)) {
				tmodel.setValueAt(program.getName(),i++, y);
			}
			y++;
		}	
				table.setModel(tmodel);

			}
			
			
	
		
		

	

}
