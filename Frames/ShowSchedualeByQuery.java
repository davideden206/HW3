package Frames;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import src.BCM;
import src.DaysOfTheWeek;
import src.Program;

import javax.swing.JLabel;
import javax.swing.JTable;

public class ShowSchedualeByQuery extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowSchedualeByQuery frame = new ShowSchedualeByQuery();
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
	public ShowSchedualeByQuery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u05D1\u05D7\u05E8 \u05D9\u05D5\u05DD \u05DC\u05D4\u05E6\u05D2\u05D4");
		label.setBounds(325, 11, 87, 14);
		contentPane.add(label);
		JComboBox choseDay = new JComboBox<>(DaysOfTheWeek.values());//
		choseDay.setSelectedIndex(0);
		choseDay.setBounds(213, 8, 102, 20);
		contentPane.add(choseDay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 422, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		Object[][] o = new Object[20][8];
		for(int k = 0;k<20;k++) {
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
		
		
		choseDay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i =0;
				DefaultTableModel tmodel =  new DefaultTableModel(o,
						new String[] {
								"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
						}
						);
			
				for (Program program : BCM.sch.getProgramsByDay(choseDay.getSelectedIndex())) {
					tmodel.setValueAt(program.getName(),i++, choseDay.getSelectedIndex());
				}
				table.setModel(tmodel);

			}
		});
		
		

	}
}
