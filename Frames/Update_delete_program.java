package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import src.BCM;
import src.Program;
import src.Schedule;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Update_delete_program extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_delete_program frame = new Update_delete_program();
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
	public Update_delete_program() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//���� �� �� ���� �� �� �������� ������ ����� �� ������ ����� ������� ����� �������
		ArrayList<Program> listProgram = BCM.sch.ScheduletoArry();
		String [] id = new String[listProgram.size()];
		for(int i =0;i<listProgram.size();i++) {
			id[i] =String.valueOf(listProgram.get(i).getId());
		}
		
		JLabel label = new JLabel("");
		label.setBounds(208, 11, 46, 14);
		contentPane.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 240, 280);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("update program", null, panel, null);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("id");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(166, 54, 34, 14);
		panel.add(label_1);
		
		JList<String> list2 = new JList<String>();
		list2.setVisibleRowCount(5);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list2.setBounds(383, 52, 34, 167);
		list2.getScrollableTracksViewportHeight();
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.add(list2);
		scrollPane_1.setBounds(160, 74, 53, 168);
		panel.add(scrollPane_1);
		
		JButton button = new JButton("\u05E2\u05D3\u05DB\u05DF");
		button.setBounds(49, 219, 89, 23);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("delete program", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		
		JList<String> list = new JList<String>();
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setBounds(383, 52, 34, 167);
		list.getScrollableTracksViewportHeight();
	
	
		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(167, 53, 34, 14);
		panel_1.add(lblId);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(list);
		scrollPane.setBounds(161, 73, 53, 168);
		panel_1.add(scrollPane);
		
		JButton btnDelete = new JButton("\u05DE\u05D7\u05E7");
		btnDelete.setBounds(59, 218, 89, 23);
		panel_1.add(btnDelete);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
	}
}