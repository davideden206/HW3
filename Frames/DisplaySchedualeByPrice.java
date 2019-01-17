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
import src.News;
import src.Program;
import src.Series;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton btnfindbyprice = new JButton("\u05DE\u05E6\u05D0 \u05EA\u05D5\u05DB\u05E0\u05D9\u05D5\u05EA");
		btnfindbyprice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnfindbyprice.setBounds(242, 12, 97, 23);
		contentPane.add(btnfindbyprice);
		
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
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(6).setPreferredWidth(120);
		
		
				
		
				
				btnfindbyprice.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(textCost.getText()!=null) {
							DefaultTableModel tmodel =  new DefaultTableModel(o,
									new String[] {
											"id", "name", "duration", "startHour", "endHour", "geners", "broadcaster/dayScheduled"
									}
									);
							
					int i =0;
					for (Program p : BCM.sch.getProgramsByPrice(Integer.parseInt(textCost.getText()))) {
						if(p instanceof News) {
						tmodel.insertRow(i++,new Object[]{p.getId(),p.getName(),p.getDuration()
								,p.getStartHour(),p.getEndHour(),p.getGeners().toString(),(News.class.cast(p).getBroadcaster())});
						}
						else if(p instanceof Series) {
							tmodel.insertRow(i++,new Object[]{p.getId(),p.getName(),p.getDuration()
									,p.getStartHour(),p.getEndHour(),p.getGeners().toString(),(Series.class.cast(p).getDayScheduled())});
						}
						
					}
					
						table.setModel(tmodel);
						textCost.setText("");
						  
						}
						
					}
				});
				
			}
	}

