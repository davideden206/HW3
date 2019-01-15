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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowSchedualeByQuery extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowSchedualeByQuery frame = new ShowSchedualeByQuery();
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
	public ShowSchedualeByQuery() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(208, 11, 46, 14);
		contentPane.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 432, 258);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("update program", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("delete program", null, panel_1, null);
		panel_1.setLayout(null);
		
		String [] id = {};
		
		JList<String> list = new JList<String>(id);
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setBounds(383, 52, 34, 167);
		list.getScrollableTracksViewportHeight();
	
	
		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(370, 32, 34, 14);
		panel_1.add(lblId);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(list);
		scrollPane.setBounds(364, 52, 53, 168);
		panel_1.add(scrollPane);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		
	}

	
}
