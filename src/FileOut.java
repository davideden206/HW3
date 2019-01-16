package src;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class FileOut {
	
	 private static ObjectOutputStream output;
	
	 public static void openFileSer()
	   {
	      try 
	      {
	         output = new ObjectOutputStream(
	            Files.newOutputStream(Paths.get("ScheduleSer.ser")));
	      }
	      catch (IOException ioException)
	      {
	         System.err.println("Error opening file. Terminating.");
	         System.exit(1); // terminate the program
	      } 
	   } 

	   // add records to file
	   public static void addRecordsSer(ArrayList<Program> pro)
	   {
	      for (Program p : pro) 
		   {
	         try 
	         { 
	            // serialize  object into file
	        	output.writeObject(p);
	        
	            
	         } 
	         
	         catch (IOException ioException)
	         {
	            System.err.println("Error writing to file. Terminating.");
	            break;
	         } 
   
	      }
	      for (Manager m : BCM.managers) {
	    	  try {
				output.writeObject(m);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	   } 

	   // close file and terminate application 
	   public static void closeFileSer() 
	   {
	      try 
	      {
	         if (output != null)
	            output.close();
	      } 
	      catch (IOException ioException)
	      {
	         System.err.println("Error closing file. Terminating.");
	      } 
	   } 
	

}
