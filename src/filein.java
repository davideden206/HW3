package src;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class filein {
	private static Scanner input;
	static ArrayList<Manager> manager = new ArrayList<>();
	static ArrayList<Movie> movie = new ArrayList<>();
	static ArrayList<News> news = new ArrayList<>();
	static ArrayList<Series> series = new ArrayList<>();
	static ArrayList<TVShow> tvShow = new ArrayList<>();
	static ArrayList<String> stars = new ArrayList<>();
	static ArrayList<Integer> days1 = new ArrayList<>();
	static ArrayList<Integer> days2 = new ArrayList<>();
	static ArrayList<Integer> days3 = new ArrayList<>();


	// open file clients.txt
	public static void openFile()
	{
		try
		{

			input = new Scanner(Paths.get("Schedule.txt")); 
		} 
		catch (IOException ioException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		} 
	}

	// read record from file
	public static void readRecords()
	{



		try 
		{
			
			while (input.hasNext()) // while there is more to read
			{
				String type = input.next();
				if (type.equals("Manager")) {   
					Manager m = new Manager(input.nextInt(), input.next());
					manager.add(m);

				}
				if (type.equals("stars")) {
					while(!input.next().equals("Movie"))
						stars.add(input.next());   
				}
				if (type.equals("Movie")) {
					Movie mo = new Movie(input.nextInt(), input.next(), input.nextInt(),
							input.nextDouble(),input.nextDouble(),input.nextDouble(),input.nextInt(),
							stars, Languages.valueOf(input.next()), Genres.valueOf(input.next()));
					movie.add(mo);
				}
				if (type.equals("News")) {
					News ne = new News(input.nextInt(),input.next(), input.nextInt(), input.nextDouble(),
							input.nextDouble(), Genres.valueOf(input.next()), input.next());
					news.add(ne);
				}
				if (type.equals("days1")) {
					while (!type.equals("days2")) {
						days1.add(input.nextInt());
					}
				}
				if (type.equals("days2")) {
					while (!type.equals("days3")) {
						days2.add(input.nextInt());
					}
				}
				if (type.equals("days1")) {
					while (!type.equals("Series")) {
						days3.add(input.nextInt());
					}
				}
				
				if(type.equals("Series")) {
					Series s = new Series(input.nextInt(), input.next(), input.nextInt(),
							input.nextDouble(), input.nextDouble(), Genres.valueOf(input.next()),getDays(input.next()));
					series.add(s);
					
				}
				if(type.equals("TVShow")) {
					TVShow tv = new TVShow(input.nextInt(), input.next(), input.nextInt(), input.nextDouble(), input.nextDouble(),input.nextInt(),
							input.next(), input.next(), Genres.valueOf(input.next()));
					tvShow.add(tv);
				}


			}
		} 
		catch (NoSuchElementException elementException)
		{
			System.err.println("File improperly formed. Terminating.2");
		} 
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file. Terminating.");
		} 

	} // end method readRecords

	// close file and terminate application
	public static void closeFile()
	{
		if (input != null)
			input.close();
	} 
	
	public static ArrayList<Integer> getDays(String day){
		if (day=="days1") return days1;
		if (day=="days2") return days2;
		else return days3;
	}


} // end class ReadTextFile