package src;


import java.util.ArrayList;

public class Schedule {
	
	 ArrayList<Program>[] WeeklySchedule;
	
	Schedule(){
		this.WeeklySchedule = new ArrayList[7];
		for (int i = 0; i < WeeklySchedule.length; i++) {
			this.WeeklySchedule[i]= new ArrayList<>();
		}
	}
	
	 void addProgramToArray(Program p,int day)  {
		 try {
			 ArrayList<Program> a =new ArrayList<>();
				a = this.WeeklySchedule[day-1];
				
				if(a.isEmpty()) {
					a.add(p);
				if(p instanceof Series) {
					((Series) p).setNumBroadcasted(((Series) p).getNumBroadcasted()+1);
				}}
				else {
			for (int i = 0; i < a.size(); i++) {
				if(((Program)a.get(i)).getStartHour()>=p.getEndHour()) {
					a.add(i,p);
					if(p instanceof Series) {
						((Series) p).setNumBroadcasted(((Series) p).getNumBroadcasted()+1);
					}
					break;
				}
				if(((Program)a.get(i)).getStartHour()<p.getStartHour()&& 
						((Program)a.get(i)).getEndHour()<=p.getStartHour())
					continue;
				else
					 throw new Exception();
			}
			if(!a.contains(p)) {
				a.add(a.size(),p);
				if(p instanceof Series) {
					((Series) p).setNumBroadcasted(((Series) p).getNumBroadcasted()+1);
				}
			}
			}
				System.out.println(p.toString());
		} catch (Exception e) {
			System.err.println(e.getMessage()+"The programs collide");
		}
		
		}
	
	
	  void addProgram(Program p)throws Exception {
		 if(p instanceof Movie) {
			 addProgramToArray(p,((Movie) p).getDayScheduled());
		 }
		 if(p instanceof TVShow) {
			 addProgramToArray(p,((TVShow) p).getDayScheduled());
		 }
		 if(p instanceof Series) {
				 for (int i = 0; i < ((Series)p).getDayScheduled().size(); i++) {
						addProgramToArray(p,((Series)p).getDayScheduled().get(i));
				}
		 }
		
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 1; i <8; i++) {
			
			 s+= "\nday:"+DaysOfTheWeek.values()[i-1]+"\n \n"+this.WeeklySchedule[i-1].toString()+"\n";
		}
		
		return s;
	}
	 
	 public void PrintPerCost() {
		 for (ArrayList<Program> arrayList : WeeklySchedule) {
			for (Program p : arrayList) {
				if(p instanceof Series) {
					if(((Series)p).isFlag()==false)
						if(((Series)p).getCost()*((Series)p).getNumBroadcasted()>10000)
							System.out.println(p.toString());
					((Series)p).setFlag(true);
				}
			}
		}
	 }
	 public ArrayList<Program> ScheduletoArry() {
		 ArrayList<Program> all = new ArrayList<Program>();
	 
		 for (int i = 1; i <8; i++) {
			 all.addAll(this.WeeklySchedule[i-1]);
		 }
		 return all;
	 }
	 
	 public void deleteProgram(Program p) {
		 
	 }
	 
}
