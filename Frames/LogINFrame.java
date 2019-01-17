package Frames;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import src.BCM;
import src.Manager;

import java.awt.Font;
import javax.swing.JPasswordField;

public class LogINFrame extends JFrame {

	public JFrame frame;
	private JTextField username;
	
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */



	/**
	 * Create the application.
	 */
	public LogINFrame() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 350, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("שם משתמש");
		lblNewLabel.setBounds(224, 83, 80, 16);
		frame.getContentPane().add(lblNewLabel);

		username = new JTextField();
		username.setBounds(98, 80, 116, 22);
		frame.getContentPane().add(username);
		username.setColumns(10);

		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 113, 116, 22);
		frame.getContentPane().add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("סיסמא");
		lblNewLabel_1.setBounds(224, 116, 66, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("\u05DB\u05E0\u05D9\u05E1\u05D4");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(117, 27, 97, 30);
		frame.getContentPane().add(label);

		JButton button = new JButton("\u05D4\u05D9\u05DB\u05E0\u05E1");
		button.setBounds(108, 146, 97, 25);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(username.getText().matches("[a-zA-z]+(['-][a-zA-Z]+)*")&&
						(passwordField.getText().equals("ADMIN")||passwordField.getText().equals("admin")||passwordField.getText().matches("[0-9]*"))) {
					
				if((username.getText().equals("admin")||username.getText().equals("ADMIN"))
						&&(passwordField.getText().equals("admin")||passwordField.getText().equals("ADMIN"))){
					Menu m = new Menu(null);
					JOptionPane.showMessageDialog(null, "Succeeded");
					m.setVisible(true);
					frame.dispose();
				}
				
				else if(checkUsername(Integer.valueOf(passwordField.getText()), username.getText())) {
					Menu m = new Menu(getManager(Integer.valueOf(passwordField.getText())));
					JOptionPane.showMessageDialog(null, "Succeeded");
					m.setVisible(true);
					frame.dispose();

				}

				else {
					JOptionPane.showMessageDialog(null, "the user it not exsist");
				}





			}
				else {
					JOptionPane.showMessageDialog(null, "you need entr name whit only english Letters and password with only number");
				}
			}
		});
		
		frame.getContentPane().add(button);
		
		
	}
	
	public boolean checkUsername(int id,String name) {
		for (Manager m: BCM.managers) {
			if (m.getId() == id && m.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public Manager getManager(int id) {
		for (Manager m: BCM.managers){
			if (m.getId()==id) {
				return m;
			}
		}
		return null;
	}
}