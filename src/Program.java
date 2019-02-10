package src;
import java.io.Serializable;

import javax.swing.JOptionPane;

public abstract class Program implements Serializable {

	private int id;
	private String Name;
	private int duration;
	private double startHour;
	private double endHour;
	private Manager manager;
	private Genres geners;



	public Program(int id, String name, int duration, double startHour, double endHour,Genres geners) {
		super();
		this.setId(id);
		this.setName(name);
		this.setDuration(duration);
		this.setEndHour(endHour);
		this.setStartHour(startHour);
		this.setGeners(geners);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		try {
			if(String.valueOf(id).matches("[0-9]+"))
				this.id = id;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The id not valide must be number");
			e.getMessage();
		}
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		try {
			if(name.matches(".*"))
				Name = name;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The name not valide must be latters");
			e.getMessage();
		}
		
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		try {
			if(String.valueOf(duration).matches("[1-9]+"))
				this.duration = duration;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The duration not valide must be number");
			e.getMessage();
		}
		
	}

	public double getStartHour() {
		return startHour;
	}

	public void setStartHour(double startHour) {
		try {
			if(startHour<this.getEndHour()&&String.valueOf(endHour).matches("(\\d+\\.\\d+)"))
				this.startHour = startHour;
			else
				throw new Exception("start hoer not ligule");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The startHour not valide must be double");
			e.getMessage();
		}
	}

	public double getEndHour() {
		return endHour;
	}

	public void setEndHour(double endHour) {
		try {
			if(String.valueOf(endHour).matches("(\\d+\\.\\d+)"))
				this.endHour = endHour;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The startHour not valide must be double");
			e.getMessage();
		}
		
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Genres getGeners() {
		return geners;
	}

	public void setGeners(Genres geners) {
		try {
			if(checkGeners(geners)) {
				this.geners = geners;
			}
			else
				throw new Exception("gener dont exsist");
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		}


	@Override
	public String toString() {
		return "\n"+this.getClass().getSimpleName()+" id=" + id + ", Name=" + Name + ", duration=" + duration + ", startHour=" + startHour
				+ ", endHour=" + endHour + ", manager=" + manager + ", geners=" + geners + " ";
	}

	public boolean checkGeners(Genres geners) {
		for(Genres gen : Genres.values()) {
			if(gen == geners) {
				return true;
			}
		}
		return false;
	}

}




