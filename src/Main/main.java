package Main;
import Model.Movies;
import java.util.Scanner;
public class main {

	public static void main(String [] args)
	{
		int ch;
	
		Scanner sc=new Scanner(System.in);
		Movies a=new Movies("Spider man");
		
	do {
			System.out.println("Cinema ticketing System");
		    System.out.println("1.booking ticket");
	    	System.out.println("2.adding movies");
		    System.out.println("3.removing movies");
		    System.out.println("4.print database list");
		    System.out.println("5.exit");
		    ch=sc.nextInt();
		    switch(ch)
		    {
		    case 1:
		    	System.out.println(a);
		    	break;
		    case 2:
		    	System.out.println("add the movies name :");
		    	sc.nextLine();
		    	String name =sc.nextLine();
		    	System.out.println("added");
		    	break;
		    case 3:
		    	System.out.println("deleted");
		    	break;
		    case 4 :
		    	System.out.println("all print");
		    	break;
		    case 5:
		    	System.exit(0);
		   default:
			   System.out.println("try again");
			   break;
		    	
		    }
	}while(ch!=5);
		    
		    
	}

}
