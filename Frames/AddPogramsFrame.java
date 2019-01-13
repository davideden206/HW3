package Frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.DayOfWeek;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import src.Languages;

public class AddPogramsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField programId;
	private JTextField programName;
	private JTextField programDuration;
	private JTextField programStartHour;
	private JTextField programEndHour;
	private JLabel label_2;
	private JLabel lblName;
	private JLabel lblDuration;
	private JLabel lblStartHour;
	private JLabel lblEndHour;
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JTextField item4;
	private JLabel lable1;
	private JLabel lable2;
	private JLabel lable3;
	private JLabel lable4;
	private JComboBox comboBox_1, comboBox_2,comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPogramsFrame frame = new AddPogramsFrame();
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
	public AddPogramsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(147, 11, 132, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u05E4\u05E8\u05D8\u05D9 \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		label_1.setBounds(394, 85, 68, 20);
		contentPane.add(label_1);
		
		programId = new JTextField();
		programId.setBounds(289, 110, 86, 20);
		contentPane.add(programId);
		programId.setColumns(10);
		
		
		
		programName = new JTextField();
		programName.setBounds(289, 138, 86, 20);
		contentPane.add(programName);
		programName.setColumns(10);
		
		
		programDuration = new JTextField();
		programDuration.setColumns(10);
		programDuration.setBounds(289, 166, 86, 20);
		contentPane.add(programDuration);
		
		programStartHour = new JTextField();
		programStartHour.setColumns(10);
		programStartHour.setBounds(289, 194, 86, 20);
		contentPane.add(programStartHour);
		
		programEndHour = new JTextField();
		programEndHour.setColumns(10);
		programEndHour.setBounds(289, 225, 86, 20);
		contentPane.add(programEndHour);
		
		label_2 = new JLabel("id");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(376, 112, 77, 17);
		contentPane.add(label_2);
		
		lblName = new JLabel("name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(376, 140, 77, 17);
		contentPane.add(lblName);
		
		lblDuration = new JLabel("duration");
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setBounds(376, 169, 77, 17);
		contentPane.add(lblDuration);
		
		lblStartHour = new JLabel("start hour");
		lblStartHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartHour.setBounds(376, 197, 77, 17);
		contentPane.add(lblStartHour);
		
		lblEndHour = new JLabel("end hour");
		lblEndHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndHour.setBounds(376, 228, 77, 17);
		contentPane.add(lblEndHour);
		String [] typeOfPrograms = {"chose","TVshow","Movie","Series","News"};
		JComboBox comboBox = new JComboBox(typeOfPrograms);
		comboBox.setBounds(224, 64, 151, 24);
		contentPane.add(comboBox);
		comboBox.getAlignmentX();
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String s = e.getItem().toString();
				if(s=="TVshow") {
					clear();
					comboBox_1 = new JComboBox<>(DayOfWeek.values());
					comboBox_1.setBounds(73, 110, 102, 20);
					contentPane.add(comboBox_1);
					comboBox_1.setVisible(true);
			
					lable1.setText("day scheduled");
					item2.setVisible(true);
					lable2.setText("guest");
					item3.setVisible(true);
					lable3.setText("host");
					lable4.setVisible(false);
					lable1.setVisible(true);
					lable2.setVisible(true);
					lable3.setVisible(true);
					
				}
				else if(s=="Movie") {
					clear();
					comboBox_2 = new JComboBox<>(DayOfWeek.values());
					comboBox_2.setBounds(73, 138, 102, 20);
					contentPane.add(comboBox_2);
					item1.setVisible(true);
					lable1.setText("IMDB");
					lable2.setText("day scheduled");
					item3.setVisible(true);
					lable3.setText("stars");
				
					lable4.setText("subtitle lenguges");
					lable1.setVisible(true);
					lable2.setVisible(true);
					lable3.setVisible(true);
					lable4.setVisible(true);
					
					comboBox_3 = new JComboBox<>(Languages.values());
					comboBox_3.setBounds(73, 194, 102, 20);
					contentPane.add(comboBox_3);
				}
				else if(s=="Series") {
					clear();
					comboBox_1 = new JComboBox<>(DayOfWeek.values());
					comboBox_1.setBounds(73, 110, 102, 20);
					contentPane.add(comboBox_1);
					comboBox_1.setVisible(true);
					lable1.setVisible(true);
					lable1.setText("day scheduled");

				}
				else if(s=="chose") {
					clear();
				}
				else {
					clear();
					item1.setVisible(true);
					lable1.setVisible(true);
					lable1.setText("broadcaster");

				}
			}
		});
		
		
		
		JLabel label_3 = new JLabel("\u05E1\u05D5\u05D2 \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(384, 66, 69, 20);
		contentPane.add(label_3);
		
		item1 = new JTextField();
		item1.setColumns(10);
		item1.setBounds(89, 110, 86, 20);
		contentPane.add(item1);
		item1.setVisible(false);
		
		item2 = new JTextField();
		item2.setColumns(10);
		item2.setBounds(89, 138, 86, 20);
		contentPane.add(item2);
		item2.setVisible(false);
		
		item3 = new JTextField();
		item3.setColumns(10);
		item3.setBounds(89, 166, 86, 20);
		contentPane.add(item3);
		item3.setVisible(false);
		
		item4 = new JTextField();
		item4.setColumns(10);
		item4.setBounds(89, 194, 86, 20);
		contentPane.add(item4);
		
		 lable1 = new JLabel("");
		lable1.setHorizontalAlignment(SwingConstants.CENTER);
		lable1.setBounds(177, 112, 102, 17);
		contentPane.add(lable1);
		lable1.setVisible(false);
		
		 lable2 = new JLabel("");
		lable2.setHorizontalAlignment(SwingConstants.CENTER);
		lable2.setBounds(177, 141, 102, 17);
		contentPane.add(lable2);
		lable2.setVisible(false);
		
		lable3 = new JLabel("");
		lable3.setHorizontalAlignment(SwingConstants.CENTER);
		lable3.setBounds(177, 169, 102, 17);
		contentPane.add(lable3);
		lable3.setVisible(false);
		
		lable4 = new JLabel("");
		lable4.setHorizontalAlignment(SwingConstants.CENTER);
		lable4.setBounds(177, 197, 102, 17);
		contentPane.add(lable4);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setBounds(73, 110, 102, 20);
		contentPane.add(comboBox_1);
		comboBox_1.setVisible(false);
		
		 comboBox_2 = new JComboBox();
		comboBox_2.setBounds(73, 138, 102, 20);
		contentPane.add(comboBox_2);
		comboBox_2.setVisible(false);
		 comboBox_3 = new JComboBox();
		comboBox_3.setBounds(73, 194, 102, 20);
		contentPane.add(comboBox_3);
		comboBox_3.setVisible(false);
		
		item4.setVisible(false);
		lable4.setVisible(false);
		
	}
	
	public void clear() {
		item1.setVisible(false);
		lable1.setVisible(false);
		item2.setVisible(false);
		lable2.setVisible(false);
		item3.setVisible(false);
		lable3.setVisible(false);
		item4.setVisible(false);
		lable4.setVisible(false);
		comboBox_1.setVisible(false);
		comboBox_2.setVisible(false);
	}
}
