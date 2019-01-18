package src;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import Frames.Menu;

public class Schedule {
	
	 ArrayList<Program>[] WeeklySchedule;
	
	Schedule(){
		this.WeeklySchedule = new ArrayList[7];
		for (int i = 0; i < WeeklySchedule.length; i++) {
			this.WeeklySchedule[i]= new ArrayList<>();
		}
	}
	
	 void addProgramToArray(Program p,int day)throws Exception  {
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
			if(Menu.maneger!=null) {
			JOptionPane.showMessageDialog(null, "The programs collide");
			 throw new Exception();
			}
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
		 for (ArrayList<Program> arrayList : this.WeeklySchedule) {
			for (Program p : arrayList) {
				if(p instanceof Series) {
					if(((Series)p).isFlag()==false)
						if(((Series)p).getCost()*((Series)p).getNumBroadcasted()>1)
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
	 
	 public void deleteProgram(String p) {
		 for(ArrayList<Program> listp :this.WeeklySchedule) {
			 for (int i = 0; i < listp.size(); i++) {
				if(p.equals(String.valueOf(listp.get(i).getId()))) {
					listp.remove(i);
				}
			}
		 }
	 }
	 
	 public Program getProgram(String idP) {
		 Program p = null;
		 for(ArrayList<Program> listp :this.WeeklySchedule) {
			 for (int i = 0; i < listp.size(); i++) {
				if(idP.equals(String.valueOf(listp.get(i).getId()))) {
					 p = listp.get(i);
					return p;
				}
			}
		 }
		 return p;
	 }
	 
	 public ArrayList<Program> getProgramsByDay(int day){
		 ArrayList<Program> listP = new ArrayList<>();
		 for (int i = 0; i <8; i++) {
			 if(day==i) {
				 for(Program p :this.WeeklySchedule[i]) {
					 listP.add(p);
				 }
			 }
		 }
		 return listP;
	 }

	public ArrayList<Program>[] getWeeklySchedule() {
		return WeeklySchedule;
	}
	
	public ArrayList<Program> getProgramsByPrice(int price){
		ArrayList<Program> listp = new ArrayList<>();
		for (ArrayList<Program> arrayList : WeeklySchedule) {
			for (Program p : arrayList) {
				if(p instanceof Series) {
					if(((Series)p).isFlag()==false)
						if(((Series)p).getCost()*((Series)p).getNumBroadcasted()>price)
							listp.add(p);
					((Series)p).setFlag(true);
				}
			}
		}
		for (ArrayList<Program> arrayList : WeeklySchedule) {
			for (Program p : arrayList) {
				if(p instanceof Series) {
					if(((Series)p).isFlag()==true)
					((Series)p).setFlag(false);
				}
			}
		}
		return listp;
		
	}

	 
	 
}
