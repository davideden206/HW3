

import java.util.ArrayList;

public class Movie extends Program{

	private double IMDB;
	private int DayScheduled;
	private ArrayList<String> stars;
	private Languages leng;

	public Movie(int id, String name, int duration, double startHour, double endHour, double iMDB,
			int dayScheduled, ArrayList<String> stars, Languages leng,Genres geners) {
		super(id, name, duration, startHour, endHour, geners);
		IMDB = iMDB;
		DayScheduled = dayScheduled;
		setStars(stars);
		this.leng = leng;
	}

	public double getIMDB() {
		return IMDB;
	}

	public void setIMDB(double iMDB) {
		try {
			if (iMDB>=0 && iMDB<=10) 
			{
				IMDB = iMDB;
			}
			else
				throw new Exception("iMDB not ligule");

		}
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public int getDayScheduled() {
		return DayScheduled;
	}

	public void setDayScheduled(int dayScheduled) {
		DayScheduled = dayScheduled;
	}

	public ArrayList<String> getStars() {
		return stars;
	}

	public void setStars(ArrayList<String> stars) {
		try {
			for(String st : stars) {
				if (st.matches("[a-zA-z]+(['-][a-zA-Z]+)*"))
					continue;
				else
					throw new Exception();
			}
			this.stars = stars;
		}
		catch (Exception e) {
			System.err.println("aligle star name");

		}
	}


	public Languages getLeng() {

		return leng;
	}

	public void setLeng(Languages leng) {
		try {
			for (Languages lengu :Languages.values()) {
				if(leng==lengu) {
					this.leng = leng;
				}
			}
			throw new Exception("leng dont ligule");
		}
		catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public String toString() {
		return super.toString()+" IMDB=" + IMDB + ", DayScheduled=" + DayScheduled + ", stars=" + stars + ", leng=" + leng + " ";
	}




}
