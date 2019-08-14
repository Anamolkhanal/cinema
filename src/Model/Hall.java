 package Model;
 import java.util.Scanner;

public class Hall {
	private int hallNo;
	//private Movies object;
    private Seat seatlist;
    Scanner sc=new Scanner(System.in);
    public Hall(int hallNo, Movies object, Seat seatlist) {
		this.hallNo = hallNo;
	//	this.object = object;
		this.seatlist = seatlist;
	}
    public Hall() {
		int n=inputHall();
		this.hallNo = n;
		new Seat();
	}
    
	public int getHallNo() {
		return hallNo;
	}
	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	
	public Seat getSeatlist() {
		return seatlist;
	}
	public void setSeatlist(Seat seatlist) {
		this.seatlist = seatlist;
	}
	@Override
	public String toString() {
		return "Hall [hallNo=" + hallNo + ", seatlist=" + seatlist + "]";
	}
	public int inputHall()
	{
		System.out.println("hallNO 1\n, hallNo 2\n,hallNo 3");
		System.out.println("enter the hall no:");
		int n=sc.nextInt();
		return n;
	}
    
   
}
