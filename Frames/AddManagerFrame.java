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
import java.awt.Font;

public class AddManagerFrame extends JFrame {

	JFrame frame;
	private JTextField username;
	private JTextField password;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AddManagerFrame window = new AddManagerFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddManagerFrame() {
		
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
		
		password = new JTextField();
		password.setBounds(98, 113, 116, 22);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
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
				AddPogramsFrame a = new AddPogramsFrame();
				if(username.getText()=="admin") {
					JOptionPane.showMessageDialog(null, "Succeeded");
					a.setVisible(true);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "the user it not exsist");
				}
				
				
				
				
				
			}
		});
		frame.getContentPane().add(button);
	}
}
