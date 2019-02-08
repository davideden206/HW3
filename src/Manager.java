package src;
import java.io.Serializable;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Frames.Menu;

public class Manager implements Serializable{

	private int id;
	private String Name;

	public Manager(int id, String name) {
		super();
		this.id = id;
		setName(name);
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
		try{
			if (name.matches("[a-zA-z]+(['-][a-zA-Z]+)*"))
				Name = name;
			else
				throw new Exception("aliugal name");
		}
		catch (Exception e) {
			System.err.println(e.getMessage()+ ", you mast first and end char letars.");
		}

	}

	public void addProgramByManger(Program p ,Schedule s) throws Exception {
		p.setManager(this);
		try {

			s.addProgram(p);
			//System.out.println(p.toString());

		}catch (Exception e) {
			System.err.println(e.getMessage()+"The programs collide");
			throw new Exception();
		}
	}

	@Override
	public String toString() {
		return " id=" + id + ", Name=" + Name + " ";
	}

	


}
