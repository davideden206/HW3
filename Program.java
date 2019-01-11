import java.io.Serializable;

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
		this.id = id;
		Name = name;
		this.duration = duration;
		this.endHour = endHour;
		this.setStartHour(startHour);
		this.geners = geners;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getStartHour() {
		return startHour;
	}

	public void setStartHour(double startHour) {
		try {
			if(startHour<this.getEndHour())
				this.startHour = startHour;
			else
				throw new Exception("start hoer not ligule");
		}
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public double getEndHour() {
		return endHour;
	}

	public void setEndHour(double endHour) {
		this.endHour = endHour;
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




