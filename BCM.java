

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.plaf.synth.SynthStyle;


public class BCM {
	public static void main(String[] args) throws Exception {
		
		Schedule sch = new Schedule();
		Schedule newsch = new Schedule();
		
		// read programs from txt file
		filein.openFile();
		filein.readRecords();
		filein.closeFile();
		
		
		// add programs to Schedule
		System.out.println("<<<<< add programs to Schedule from txt file >>>>>");
		
		addNews(sch);
		addTvshow(sch);
		addMove(sch);
		addSerise(sch);
	
		// save Schedule to ser file
		System.out.println("<<<< Schedule to ser file >>>>");
		
		FileOut.openFileSer();
		FileOut.addRecordsSer(sch.ScheduletoArry());
		FileOut.closeFileSer();
		
		// open ser file in new Schedule
		System.out.println("<<<<<< open ser file in new Schedule >>>>>>");
		
		OpenSer.openFile();
		newsch = OpenSer.readRecords();
		OpenSer.closeFile();
		
		// print Schedule
		System.out.println("\n<<<<<<< print Schedule >>>>>>> \n");
		
		System.out.println(newsch);
		System.out.println(" print all pogram  cost more 10000");
		newsch.PrintPerCost();
		
	// end mane	
	}
	
	// Mutates for add program
	
	
	public static void addNews(Schedule sch)
	{
		for (News n: filein.news)
		{
			try {
				filein.manager.get(0).addProgramByManger(n,sch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void addMove(Schedule sch)
	{
		for (Movie m : filein.movie)
		{
			try {
				filein.manager.get(1).addProgramByManger(m, sch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void addSerise(Schedule sch)
	{
		for(Series s : filein.series)
		{
			try {
				filein.manager.get(2).addProgramByManger(s, sch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void addTvshow(Schedule sch)
	{
		for (TVShow t : filein.tvShow)
		{
			try {
				filein.manager.get(3).addProgramByManger(t, sch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
