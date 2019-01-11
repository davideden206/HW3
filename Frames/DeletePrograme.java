package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class DeletePrograme extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePrograme frame = new DeletePrograme();
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
	public DeletePrograme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList<Integer>();
		list.setBounds(317, 85, 105, 145);
		list.setVisibleRowCount(8);
		contentPane.add(list);
		
		JLabel label = new JLabel("\u05DE\u05D7\u05D9\u05E7\u05EA \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(160, 11, 155, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u05D1\u05D7\u05E8 \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA \u05DC\u05DE\u05D7\u05D9\u05E7\u05D4");
		label_1.setBounds(317, 60, 115, 14);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u05DE\u05D7\u05E7 \u05EA\u05D5\u05DB\u05E0\u05D9\u05EA");
		button.setBounds(160, 235, 100, 23);
		contentPane.add(button);
	}
}
