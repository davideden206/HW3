package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.BCM;
import src.Manager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class AddManager extends JFrame {

	private JPanel contentPane;
	private JTextField nameManger;
	private JTextField idManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManager frame = new AddManager();
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
	public AddManager() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nameManger = new JTextField();
		nameManger.setBounds(90, 87, 116, 22);
		contentPane.add(nameManger);
		nameManger.setColumns(10);

		idManager = new JTextField();
		idManager.setBounds(90, 137, 116, 22);
		contentPane.add(idManager);
		idManager.setColumns(10);

		JLabel label = new JLabel("\u05E9\u05DD \u05D4\u05DE\u05E0\u05D4\u05DC");
		label.setBounds(236, 90, 101, 16);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA");
		label_1.setBounds(236, 140, 88, 16);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05E0\u05D4\u05DC \u05D7\u05D3\u05E9");
		label_2.setBounds(160, 40, 110, 16);
		contentPane.add(label_2);

		JButton btnAddManager = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05DE\u05E0\u05D4\u05DC");
		btnAddManager.setBounds(154, 194, 116, 25);
		contentPane.add(btnAddManager);
		btnAddManager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = nameManger.getText();
				String Password = idManager.getText();
				
				if((Password!=null && userName!=null) &&( userName.matches("[a-zA-Z]*")&&
						Password.matches("[0-9]*"))) {
					
					Manager m = new Manager(Integer.parseInt(Password) , userName);
					BCM.managers.add(m);
					BCM.saveSchedule();
					JOptionPane.showMessageDialog(null, "Succeeded");
					dispose();
					

				}
				else {
					JOptionPane.showMessageDialog(null, "All details must be entered");
				}
			}
		}
				);
		
	}
}