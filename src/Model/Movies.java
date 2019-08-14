package Model;
import java.util.ArrayList;
import java.util.Scanner;

public class Movies {
	private int mid;
	private String Mname;
	private ArrayList<String> moviesarr=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
	
	public Movies() {
		moviesarr.add("spider man");
		moviesarr.add("iron man");
		
		String name=bookmovies();
		this.mid++;
		this.Mname = name;
		new Hall();
	}
	
	public String getName() {
		return Mname;
	}

	public void setName(String name) {
		this.Mname = name;
	}
	public String bookmovies()
	{    
		System.out.println(moviesarr);
		System.out.println("enter the number to choice movies:");
		int ch=sc.nextInt()-1;
		return moviesarr.get(ch);
	}
	public void addmovies(){
		System.out.println("Enter the name of the movies:");
		String name=sc.nextLine();
		moviesarr.add(name);
	}
	public void deletemovies() {
		System.out.println("enter the movies name that u want to removed from the list:");
		String name=sc.nextLine();
		moviesarr.remove(name);
	}
	@Override
	public String toString() {
		return "Movies [name=" + Mname + ", id ="+mid+ "]";
		
	}
	
	
}
