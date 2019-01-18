package Frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.DayOfWeek;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import src.BCM;
import src.DaysOfTheWeek;
import src.Genres;
import src.Languages;
import src.Manager;
import src.Movie;
import src.News;
import src.Program;
import src.Series;
import src.TVShow;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AddPogramsFrame extends JFrame {

	//public AddPogramsFrame frame;
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
	private JLabel lable5;
	private JLabel lable6;
	private JButton btnAdd;
	private JComboBox comboBox_1, comboBox_2,comboBox_3,comboBox4,comboBoxType;
	private JList starsList,starsList2;
	private Manager m;
	private Program p;
	JScrollPane scrollPane,scrollPane2;
	String[] dataliststar = {"mose-ivgi", "gal-gadut", "bar-refaeli","miki-mause","mose-zocnik"};
	String [] typeOfPrograms = {"chose","TVShow","Movie","Series","News"};
	
	private int pid;
	private String pname;
	private int duration ;
	private double startHour ;
	private double endHour ;
	private String pgenres ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPogramsFrame frame = new AddPogramsFrame(null,null);
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
	public AddPogramsFrame(Manager m, Program p) {
		this.m = m;
		this.p = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 497);
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
		if(p!=null)
		programId.setText(String.valueOf(p.getId()));



		programName = new JTextField();
		programName.setBounds(289, 138, 86, 20);
		contentPane.add(programName);
		programName.setColumns(10);
		if(p!=null)
		programName.setText(p.getName());


		programDuration = new JTextField();
		programDuration.setColumns(10);
		programDuration.setBounds(289, 166, 86, 20);
		contentPane.add(programDuration);
		if(p!=null)
		programDuration.setText(String.valueOf(p.getDuration()));

		programStartHour = new JTextField();
		programStartHour.setColumns(10);
		programStartHour.setBounds(289, 194, 86, 20);
		contentPane.add(programStartHour);
		if(p!=null)
		programStartHour.setText(String.valueOf(p.getStartHour()));

		programEndHour = new JTextField();
		programEndHour.setColumns(10);
		programEndHour.setBounds(289, 225, 86, 20);
		contentPane.add(programEndHour);
		if(p!=null)
		programEndHour.setText(String.valueOf(p.getEndHour()));

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
		
		 comboBoxType = new JComboBox(typeOfPrograms);
		comboBoxType.setBounds(224, 64, 151, 24);
		contentPane.add(comboBoxType);
		comboBoxType.getAlignmentX();
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 253, 100, 142);
		contentPane.add(scrollPane);
		
		 starsList = new JList(DayOfWeek.values());
		scrollPane.setViewportView(starsList);
		starsList.setMaximumSize(getSize());
		starsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setVisible(false);
		starsList.setVisible(false);
		
		 scrollPane2 = new JScrollPane();
			scrollPane2.setBounds(89, 253, 100, 142);
			contentPane.add(scrollPane2);
			
			 starsList2 = new JList(dataliststar);
			scrollPane2.setViewportView(starsList2);
			starsList2.setMaximumSize(getSize());
			starsList2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			scrollPane2.setVisible(false);
			starsList2.setVisible(false);
		
		
		
		if(p!=null) {
		int po = getPosion(typeOfPrograms,p.getClass().getName().substring(4));
		comboBoxType.setSelectedIndex(po);
		}
		
		
			
			
		//Adjusts the type of program to input by selecting the program type of the user
		comboBoxType.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String s = e.getItem().toString();
				if(s=="TVShow") {
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
					
					
					lable1.setVisible(true);
					lable2.setVisible(true);
					lable3.setVisible(true);
					
				}
				else if(s=="Movie") {
					clear();
					
					scrollPane2.setVisible(true);
					starsList2.setVisible(true);
					
					
					item1.setVisible(true);
					lable1.setText("IMDB");
					lable2.setText("day scheduled");
					lable6.setVisible(true);
					lable6.setText("stars");
					lable4.setText("subtitle lenguges");
					lable1.setVisible(true);
					lable2.setVisible(true);
					lable4.setVisible(true);
					comboBox_2 = new JComboBox<>(DayOfWeek.values());
					comboBox_2.setBounds(73, 138, 102, 20);
					contentPane.add(comboBox_2);
					comboBox_3 = new JComboBox<>(Languages.values());
					comboBox_3.setBounds(73, 194, 102, 20);
					contentPane.add(comboBox_3);


				}
				else if(s=="Series") {
					clear();
					scrollPane.setVisible(true);
					starsList.setVisible(true);
					
					lable6.setVisible(true);
					lable6.setText("day scheduled");

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
		item4.setVisible(false);

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
		lable4.setVisible(false);

		lable5 = new JLabel("genres");
		lable5.setHorizontalAlignment(SwingConstants.CENTER);
		lable5.setBounds(376, 253, 102, 17);
		contentPane.add(lable5);

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
		
		 comboBox4 = new JComboBox(Genres.values());
		comboBox4.setBounds(289, 250, 86, 20);
		contentPane.add(comboBox4);
		
		 btnAdd = new JButton("add");
		btnAdd.setBounds(190, 414, 89, 23);
		contentPane.add(btnAdd);
		
		
		
		lable6= new JLabel("");
		lable6.setBounds(89, 225, 100, 16);
		contentPane.add(lable6);
		getContentPane().add(new JScrollPane());
		
		
		//Adds a program after clicking the button
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				addProgram();
				
			}
		});

	}

	//Resets the clipboard programs to re-select before booting by type
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
		comboBox_3.setVisible(false);
		starsList.setVisible(false);
		lable6.setVisible(false);
		scrollPane.setVisible(false);
		starsList.setVisible(false);
		scrollPane2.setVisible(false);
		starsList2.setVisible(false);
	}
	
	//Creates a program by type and data from the user
	public void addProgram() {
		
		 pid =Integer.valueOf(programId.getText());
		 pname = programName.getText().toString();
		 duration = Integer.valueOf(programDuration.getText());
		 startHour = Double.valueOf(programStartHour.getText());
		 endHour = Double.valueOf(programEndHour.getText());
		 pgenres  =comboBox4.getSelectedItem().toString();
		
			
		
		if (comboBoxType.getSelectedItem().toString().equals("TVShow")) {
			int day= comboBox_1.getSelectedIndex();
			String guest= item2.getText();
			String host= item3.getText();
			
			TVShow tv = new TVShow(pid, pname, duration, startHour, endHour, day, guest, host,Genres.valueOf(pgenres));
			try {
				m.addProgramByManger(tv, BCM.sch);
				BCM.saveSchedule();
				dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "The TVShow has not been added");
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "TVShow add Succeeded");
			
		}
		
		if(comboBoxType.getSelectedItem().toString().equals("Movie")) {
			double IMDB = Double.parseDouble(item1.getText());
			int daySchasuled = comboBox_2.getSelectedIndex();
			ArrayList<String> stars = new ArrayList<>();
			int[] selected = starsList2.getSelectedIndices();
			for(int i:selected) {
				stars.add(dataliststar[i]);
			}
			
			
			String subtitleLenguage = comboBox_3.getSelectedItem().toString();
			
			Movie mo = new Movie(pid, pname, duration, startHour, endHour, IMDB, daySchasuled, stars, Languages.valueOf(subtitleLenguage), Genres.valueOf(pgenres));
		
		try {
			m.addProgramByManger(mo, BCM.sch);
			BCM.saveSchedule();
			dispose();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The Movie has not been added");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Movie add Succeeded");
		}
		
		if (comboBoxType.getSelectedItem().toString().equals("Series")) {
			
			ArrayList<Integer>daySchasuledList = new ArrayList<>();
			int[] selected = starsList.getSelectedIndices();
			
			for(int i:selected) {
				daySchasuledList.add(i);
			}
			
			
			Series ss  = new Series(pid, pname, duration, startHour, endHour, Genres.valueOf(pgenres),daySchasuledList);
			
			try {
				m.addProgramByManger(ss, BCM.sch);
				BCM.saveSchedule();
				dispose();
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "The Series has not been added");
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Series add Succeeded");
		}
		
		if (comboBoxType.getSelectedItem().toString().equals("News")) {
			String broadcaster = item1.getText();
			News n = new News(pid, pname, duration, startHour, endHour, Genres.valueOf(pgenres), broadcaster);
			try {
				m.addProgramByManger(n, BCM.sch);
				BCM.saveSchedule();
				dispose();
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "The News has not been added");
				e.printStackTrace();
			}JOptionPane.showMessageDialog(null, "News add Succeeded");
		}
	}
	
	
	
	public int getPosion(String [] list,String value) {
		int cont = 0;
		for (String l :list) {
			if(l.equals(value)) {
				return cont;
				}
			cont++;
		}
		return -2;
	}
	
	//Performs a valid input test for user data
	public boolean chackREG() {
		if(String.valueOf(pid).matches("[0-9]+")&&
				pname.matches("[a-zA-z]+")&&
				String.valueOf(duration).matches("[1-9]+")&&
				String.valueOf(startHour).matches("(\\d+\\.\\d+)")&&
				String.valueOf(endHour).matches("(\\d+\\.\\d+)")&&
				pgenres.matches("[a-zA-z]+")	
					) {
			return true;
		}
		return false;
	}
}
