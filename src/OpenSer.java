package src;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenSer {
	private static ObjectInputStream input;


	// enable user to select file to open
	public static void openFile()
	{
		try // open file
		{
			input = new ObjectInputStream(          
					Files.newInputStream(Paths.get("ScheduleSer.ser")));
		} 
		catch (IOException ioException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		} 
	}

	// read record from file
	public static Schedule readRecords()
	{
		Schedule SchSer = new Schedule();
		BCM.managers.clear();

		try 
		{
			while (true) // loop until there is an EOFException
			{
				Object o = input.readObject();
				if(o instanceof Program)
				{
					Program p = (Program)o;
					SchSer.addProgram(p);
				}
				if(o instanceof Manager) {
					Manager m = (Manager)o;
					BCM.managers.add(m);
				}

			}}

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
		} // end method readRecords

		// close file and terminate application
		public static void closeFile()
		{
			try
			{
				if (input != null)
					input.close();
			} 
			catch (IOException ioException)
			{
				System.err.println("Error closing file. Terminating.");
				System.exit(1);
			} 
		} 
	}


