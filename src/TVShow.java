package src;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class TVShow extends Program implements Serializable {


	private int DayScheduled;
	private String Guest;
	private String Host;


	public TVShow(int id, String name, int duration, double startHour, double endHour,
			int dayScheduled, String guest, String host,Genres geners) {
		super(id, name, duration, startHour, endHour, geners);
		DayScheduled = dayScheduled;
		Guest = guest;
		Host = host;
	}


	public int getDayScheduled() {
		return DayScheduled;
	}


	public void setDayScheduled(int dayScheduled) {
		DayScheduled = dayScheduled;
	}


	public String getGuest() {
		return Guest;
	}


	public void setGuest(String guest) {
		try{
			if (guest.matches("[a-zA-z]+(['-][a-zA-Z]+)*"))
				Guest = guest;
			else
				throw new Exception("aliugal name");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The guest not valide");
			System.err.println(e.getMessage()+ ", you mast first and end char letars.");
		}

	}


	public String getHost() {
		return Host;
	}


	public void setHost(String host) {
		try{
			if (host.matches("[a-zA-z]+(['-][a-zA-Z]+)*"))
				Host = host;
			else
				throw new Exception("aliugal name");
		}
		catch (Exception e) {
			System.err.println(e.getMessage()+ ", you mast first and end char letars.");
		}

	}





	@Override
	public String toString() {
		return super.toString()+" DayScheduled=" + DayScheduled + ", Guest=" + Guest + ", Host=" + Host + " ";
	}




}
