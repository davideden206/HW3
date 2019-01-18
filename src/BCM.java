package src;


import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthStyle;

import Frames.LogINFrame;


public class BCM  {



	public static ArrayList<Manager> managers = new ArrayList<>();
	public ArrayList<Program> programs;
	public static Schedule sch = new Schedule();
	public static Schedule newsch = new Schedule();

	public static void main(String[] args) throws Exception {

		/*
		 * mangers of the system
		 *  id=203898309, Name=eden 
 			id=203589453, Name=yosi 
 			id=456898733, Name=ram 
 			id=364548975, Name=dan 
 			id=321456518, Name=yishai 
 			id=123585463, Name=ran 
 			
 			admin
 			id=admin , name =admin
 			id=ADMIN , name =ADMIN
		 */

		OpenSer.openFile();
		sch = OpenSer.readRecords();
		OpenSer.closeFile();
		saveSchedule();

		System.out.println(sch);

		// end mane	



		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					LogINFrame window = new LogINFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Mutates for add program

	public static void saveSchedule() {
		FileOut.openFileSer();
		FileOut.addRecordsSer(sch.ScheduletoArry());
		FileOut.closeFileSer();
	}


	public static void addNews(Schedule sch)
	{
		for (News n: Filein.news)
		{
			try {
				Filein.manager.get(0).addProgramByManger(n,sch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void addMove(Schedule sch)
	{
		for (Movie m : Filein.movie)
		{
			try {
				Filein.manager.get(1).addProgramByManger(m, sch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void addSerise(Schedule sch)
	{
		for(Series s : Filein.series)
		{
			try {
				Filein.manager.get(2).addProgramByManger(s, sch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void addTvshow(Schedule sch)
	{
		for (TVShow t : Filein.tvShow)
		{
			try {
				Filein.manager.get(3).addProgramByManger(t, sch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}






}