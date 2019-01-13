package src;


import java.util.ArrayList;

public class Series extends Program implements ProgramsManager {
	private double cost;
	private int FrequencyPerWeek;
	private ArrayList<Integer> DayScheduled;
	private int numBroadcasted;
	private boolean Flag;
	

	public Series(int id, String name, int duration, double startHour, double endHour, Genres geners,
			 ArrayList<Integer> dayScheduled) {
		super(id, name, duration, startHour, endHour, geners);
		FrequencyPerWeek =dayScheduled.size() ;
		this.DayScheduled = dayScheduled;
		this.cost = (endHour-startHour)*60*120;
		this.numBroadcasted = 0;
		this.Flag = false;
	}
	
	public Series(int id, String name, int duration, double startHour, double endHour, Genres geners) {
		super(id, name, duration, startHour, endHour, geners);
		
		this.DayScheduled = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			this.DayScheduled.add(i+1);
		}
		FrequencyPerWeek = this.DayScheduled.size();
		this.cost = (endHour-startHour)*60*120;
		this.numBroadcasted = 0;
		this.Flag = false;
	}

	public int getFrequencyPerWeek() {
		return FrequencyPerWeek;
	}

	public void setFrequencyPerWeek(int frequencyPerWeek) {
		FrequencyPerWeek = frequencyPerWeek;
	}

	public ArrayList<Integer> getDayScheduled() {
		return DayScheduled;
	}

	public void setDayScheduled(ArrayList<Integer> dayScheduled) {
		DayScheduled = dayScheduled;
	}

	@Override
	public String toString() {
		return super.toString()+" FrequencyPerWeek=" + FrequencyPerWeek + ", DayScheduled=" + DayScheduled + " ";
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getNumBroadcasted() {
		return numBroadcasted;
	}

	public void setNumBroadcasted(int numBroadcasted) {
		this.numBroadcasted = numBroadcasted;
	}

	public boolean isFlag() {
		return Flag;
	}

	public void setFlag(boolean flag) {
		Flag = flag;
	}
	
	
}
