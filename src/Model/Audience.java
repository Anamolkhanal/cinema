package Model;
import java.util.Scanner;

public class Audience {
	private String Aname;
	private int audId;
	Scanner sc=new Scanner(System.in);
	
	public Audience()
	{
		inputAudience();
	}
	public Audience(String name, Movies info, int seatNo) {
		this.audId++;
		this.Aname = name;
	}
	public String getName() {
		return Aname;
	}
	public void setName(String name) {
		this.Aname = name; 
	}
	public void inputAudience() {
		System.out.println("enter the name of the audience:");
		 this.Aname=sc.nextLine();
		 audId++;
	}
	
	
	@Override
	public String toString() {
		return "Audience [name=" +Aname + "]";
	}
	
}
