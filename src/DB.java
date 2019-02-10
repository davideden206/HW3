package src;

import java.io.EOFException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DB {
	public static  Connection connection;
	private static  Statement statement;
	private static ResultSet resultSet;
	private static PreparedStatement insertManager;
	private static PreparedStatement insertMovie; 
	private static PreparedStatement insertNews; 
	private static PreparedStatement insertSeries; 
	private static PreparedStatement insertTVShow;
	private static PreparedStatement selectManager;
	private static PreparedStatement selectMovie; 
	private static PreparedStatement selectNews;
	private static PreparedStatement selectSeries;
	private static PreparedStatement selectTVShow;
	private static PreparedStatement delete;




	public static void openDB() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=HomeWork4DB;integratedSecurity=true;");
			System.out.println("CONNECTED");

		}catch (Exception e) {
			System.err.println("Error opening DB. Terminating.");
		}
	}

	public static void addRecordsDB(Schedule sc)
	{

		try {

			// delete all old DB.
			delete = connection.prepareStatement("DELETE FROM Manager");
			delete.execute();

			delete = connection.prepareStatement("DELETE FROM Movie");
			delete.execute();
			delete = connection.prepareStatement("DELETE FROM News");
			delete.execute();
			delete = connection.prepareStatement("DELETE FROM Series");
			delete.execute();
			delete = connection.prepareStatement("DELETE FROM TVShow");
			delete.execute();

			insertManager = connection.prepareStatement(
					"INSERT INTO Manager " + 
							"(id, name) " + 
					"VALUES (?, ?)");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for (Manager m : BCM.managers) {
			try {
				insertManager.setInt(1, m.getId());
				insertManager.setString(2, m.getName());
				insertManager.executeUpdate(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		for (int i =0;i<7;i++ )
		{
			int day = i+1;
			ArrayList<Program> pro = sc.WeeklySchedule[i];



			try {
				connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=HomeWork4DB;integratedSecurity=true;");

				insertMovie = connection.prepareStatement(
						"INSERT INTO Movie " + 
								"(id, name,duration,startHour,endHour,iMDB,dayScheduled,Languages,Genres,idManager) " + 
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

				insertTVShow = connection.prepareStatement(
						"INSERT INTO TVShow " + 
								"(id, name,duration,startHour,endHour,dayScheduled,guest,host,Genres,idManager) " + 
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");



				insertNews = connection.prepareStatement(
						"INSERT INTO News " + 
								"(id, name,duration,startHour,endHour,Genres,broadcaster,dayScheduled,idManager) " + 
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

				insertSeries = connection.prepareStatement(
						"INSERT INTO Series " + 
								"(id, name,duration,startHour,endHour,Genres,dayScheduled,idManager) " + 
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?)");


			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			for (Program p : pro) 
			{
				if(p instanceof Movie) {
					Movie mov = (Movie)p;
					try {
						insertMovie.setInt(1, mov.getId());
						insertMovie.setString(2, mov.getName());
						insertMovie.setInt(3, mov.getDuration());
						insertMovie.setDouble(4, mov.getStartHour());
						insertMovie.setDouble(5, mov.getEndHour());
						insertMovie.setDouble(6, mov.getIMDB());
						insertMovie.setInt(7, day);
						insertMovie.setString(8, mov.getLeng().toString());
						insertMovie.setString(9, mov.getGeners().toString());
						insertMovie.setInt(10, mov.getManager().getId());
						insertMovie.executeUpdate(); 
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println("CRASH Movie");
					}
				} 
				if(p instanceof TVShow) {
					TVShow tv = (TVShow)p;
					try {
						insertTVShow.setInt(1, tv.getId());
						insertTVShow.setString(2, tv.getName());
						insertTVShow.setInt(3, tv.getDuration());
						insertTVShow.setDouble(4, tv.getStartHour());
						insertTVShow.setDouble(5, tv.getEndHour());
						insertTVShow.setInt(6, day);
						insertTVShow.setString(7, tv.getGuest());
						insertTVShow.setString(8, tv.getHost());
						insertTVShow.setString(9, tv.getGeners().toString());
						insertTVShow.setInt(10, tv.getManager().getId());
						insertTVShow.executeUpdate(); 
					}catch (Exception e) {

						System.out.println("CRASH TVShow");
					}
				}

				if(p instanceof Series) {
					Series s = (Series)p;
					try {
						insertSeries.setInt(1, s.getId());
						insertSeries.setString(2, s.getName());
						insertSeries.setInt(3, s.getDuration());
						insertSeries.setDouble(4, s.getStartHour());
						insertSeries.setDouble(5, s.getEndHour());
						insertSeries.setString(6, s.getGeners().toString());
						insertSeries.setInt(7, day);
						insertSeries.setInt(8, s.getManager().getId());
						insertSeries.executeUpdate(); 
					}catch (Exception e) {
						System.out.println("CRASH Series");
					}
				}

				if(p instanceof News) {
					News n = (News)p;
					try {
						insertNews.setInt(1, n.getId());
						insertNews.setString(2, n.getName());
						insertNews.setInt(3, n.getDuration());
						insertNews.setDouble(4, n.getStartHour());
						insertNews.setDouble(5, n.getEndHour());
						insertNews.setString(6, n.getGeners().toString());
						insertNews.setString(7, n.getBroadcaster());
						insertNews.setInt(8, day);
						insertNews.setInt(9, n.getManager().getId());
						insertNews.executeUpdate(); 
					}catch (Exception e) {
						e.printStackTrace();
						System.out.println("CRASH News");
					}
				}



			}
		}

	}
	
	
	

	public static Schedule readRecords()
	{
		Schedule SchSer = new Schedule();

		ResultSet resultSetManager = null;
		ResultSet resultSetMovie = null;
		ResultSet resultSetNews = null;
		ResultSet resultSetSeries = null;
		ResultSet resultSetTVShow = null;


		try 
		{
			selectManager = 
					connection.prepareStatement("SELECT * FROM Manager");
			resultSetManager = selectManager.executeQuery(); 
			selectMovie = 
					connection.prepareStatement("SELECT * FROM Movie");
			resultSetMovie = selectMovie.executeQuery(); 
			selectNews = 
					connection.prepareStatement("SELECT * FROM News");
			resultSetNews = selectNews.executeQuery(); 
			selectSeries = 
					connection.prepareStatement("SELECT * FROM Series");
			resultSetSeries = selectSeries.executeQuery(); 
			selectTVShow = 
					connection.prepareStatement("SELECT * FROM TVShow");
			resultSetTVShow = selectTVShow.executeQuery(); 
			//readManager from db
			
			while (resultSetManager.next())
			{
				
				Manager m =new Manager(resultSetManager.getInt(1),resultSetManager.getString(2));
				BCM.managers.add(m);
			} 

			//read movie from db
			Movie mo = null;
			while (resultSetMovie.next())
			{
				ArrayList<String> a = new ArrayList<>();
				a.add(resultSetMovie.getString(8));
				mo =new Movie(resultSetMovie.getInt(1)
						,resultSetMovie.getString(2)
						,resultSetMovie.getInt(3)
						,resultSetMovie.getDouble(4)
						,resultSetMovie.getDouble(5)
						,resultSetMovie.getDouble(6)
						,resultSetMovie.getInt(7)
						,a
						,Languages.valueOf(resultSetMovie.getString(9))
						,Genres.valueOf(resultSetMovie.getString(10)));
				mo.setManager(getManagerById(resultSetMovie.getInt(11)));


				Program p =mo;
				Manager m1 = p.getManager();
				m1.addProgramByManger(p, SchSer);
			}
			//read News from db
			News n = null;
			while (resultSetNews.next())
			{

				n =new News(resultSetNews.getInt(1)
						,resultSetNews.getString(2)
						,resultSetNews.getInt(3)
						,resultSetNews.getDouble(4)
						,resultSetNews.getDouble(5)
						,Genres.valueOf(resultSetNews.getString(6))
						,resultSetNews.getString(7));
				n.setManager(getManagerById(resultSetNews.getInt(9)));


				Program p2 =n;
				Manager m2 = p2.getManager();
				m2.addProgramByManger(p2, SchSer);	
			}
			//read Series from db
			Series s = null;
			while (resultSetSeries.next())
			{
				ArrayList<Integer>arrday = new ArrayList<>();
				arrday.add(resultSetSeries.getInt(7));
				s =new Series(resultSetSeries.getInt(1)
						,resultSetSeries.getString(2)
						,resultSetSeries.getInt(3)
						,resultSetSeries.getDouble(4)
						,resultSetSeries.getDouble(5)
						,Genres.valueOf(resultSetSeries.getString(6))
						,arrday
						);
				s.setManager(getManagerById(resultSetSeries.getInt(8)));

				Program p3 =s;
				Manager m3 = p3.getManager();
				m3.addProgramByManger(p3, SchSer);
			}
			//read TVShow from db
			TVShow tv = null;
			while (resultSetTVShow.next())
			{

				tv =new TVShow(resultSetTVShow.getInt(1)
						,resultSetTVShow.getString(2)
						,resultSetTVShow.getInt(3)
						,resultSetTVShow.getDouble(4)
						,resultSetTVShow.getDouble(5)
						,resultSetTVShow.getInt(6)
						,resultSetTVShow.getString(7)
						,resultSetTVShow.getString(8)
						,Genres.valueOf(resultSetTVShow.getString(9))
						);
				tv.setManager(getManagerById(resultSetTVShow.getInt(10)));
			 Program p4 =tv;
			Manager m4 = p4.getManager();
			m4.addProgramByManger(p4, SchSer);
			}
		}

		catch (EOFException endOfFileException)
		{
			System.out.printf("%nNo more records%n");
		} 
		catch (ClassNotFoundException classNotFoundException)
		{
			System.err.println("Invalid object type. Terminating.");
		} 
		catch (IOException ioException)
		{
			System.err.println("Error reading from file. Terminating.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SchSer;
	}



	public static void closeDB(){
		try {
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static Manager getManagerById(int id) {
		for (Manager m : BCM.managers) {
			if(m.getId()==id) {
				return m;
			}

		}
		return null;
	}

}
