package Frames;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import src.BCM;
import src.Program;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class DisplaySchedualeByPrice extends JFrame {

	private JPanel contentPane;
	private JTextField textCost;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplaySchedualeByPrice frame = new DisplaySchedualeByPrice();
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
	public DisplaySchedualeByPrice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05EA\u05D5\u05DB\u05E0\u05D9\u05EA \u05DC\u05E4\u05D9 \u05E1\u05DB\u05D5\u05DD:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(445, 11, 127, 21);
		contentPane.add(lblNewLabel);
		
		textCost = new JTextField();
		textCost.setBounds(349, 13, 86, 20);
		contentPane.add(textCost);
		textCost.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 800, 211);
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
						"id", "name", "duration", "startHour", "endHour", "geners", "broadcaster/dayScheduled"
				}
				);
		
		table.setEnabled(false);
		table.setModel(model);
		
		
		
				
				DefaultTableModel tmodel =  new DefaultTableModel(o,
						new String[] {
								"id", "name", "duration", "startHour", "endHour", "geners", "broadcaster/dayScheduled"
						}
						);
		int y=0;
		
		while(y<7) {
			int i =0;
			for (Program p : BCM.sch.getProgramsByPrice(Integer.parseInt(textCost.getText()))) {
				tmodel.insertRow(i,new Object[]{p.getId(),p.getName(),p.getDuration()
						,p.getStartHour(),p.getEndHour(),p.getGeners().toString(),null});
				//tmodel.setValueAt(program.getName(),i++, y);
			}
			y++;
		}	
				table.setModel(tmodel);
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(6).setPreferredWidth(120);
			}
		
	}

