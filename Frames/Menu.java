package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		button.setBounds(47, 22, 112, 23);
		contentPane.add(button);
		

		
		    
		JButton button_1 = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		button_1.setBounds(169, 22, 106, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05E0\u05D4\u05DC");
		button_2.setBounds(286, 22, 99, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u05D4\u05E6\u05D2\u05EA \u05DC\u05D5\u05D6");
		button_3.setBounds(76, 56, 89, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u05D4\u05E6\u05D2\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA \u05DC\u05E4\u05D9 \u05D9\u05D5\u05DD");
		button_4.setBounds(179, 56, 168, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\u05D4\u05E6\u05D2\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA \u05DC\u05E4\u05D9 \u05DE\u05D7\u05D9\u05E8");
		button_5.setBounds(169, 90, 178, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u05E2\u05D9\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		button_6.setBounds(10, 90, 149, 23);
		contentPane.add(button_6);
		
		
	}

}
