public class News extends Series {
	
	 private String broadcaster;
	 
	

	public News(int id, String name, int duration, double startHour, double endHour, Genres geners,
			 String broadcaster) {
		super(id, name, duration, startHour, endHour, geners);
		setBroadcaster(broadcaster);
		
	}

	public String getBroadcaster() {
		return broadcaster;
	}

	public void setBroadcaster(String broadcaster) {
		try{
			if (broadcaster.matches("[a-zA-z]+(['-][a-zA-Z]+)*"))
				this.broadcaster = broadcaster;
			else
				throw new Exception("aliugal name");
		}
		catch (Exception e) {
			System.err.println(e.getMessage()+ ", you mast first and end char letars.");
		}

		
	}

	@Override
	public String toString() {
		return super.toString()+"News broadcaster=" + broadcaster + " ";
	}

	
	 
	 
}
