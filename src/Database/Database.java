package Database;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import Model.Audience;
import Model.Movies;

public class Database {
	String url = "jdbc:mysql://localhost:3306/database";
	String username = "root";
	String password = "";
	String sql = "";
	Statement stmt;
	ResultSet rs;
	Connection con;

public Database() throws SQLException {
		con = (Connection) DriverManager.getConnection(url, username, password);
	}
public void addaudience(Audience v) throws SQLException {
		sql = "Insert into audience (Aname,Mname,Showtime,SeatNoData) " + "values('" + v.getAname()+ "', '" + v.getMname()
				+ "',' " + v.getShowtime() + "','"+v.getSeatNo()+"')";
		//System.out.println(sql);
	    stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
public void addmovies(Movies v) throws SQLException {
		sql = "Insert into movies (Moviename,Releasedate,PriceperSeat) " + "values('" + v.getMoviename()+ "', '" + v.getReleasedate()
				+ "', " + v.getPriceperSeat() + ")";
		//System.out.println(sql);
	    stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
public void addseatinfo(String x,String Showtime) throws SQLException
	{
		sql ="UPDATE seat SET Istaken = 1 WHERE SeatNo LIKE '"+x+"%'AND Showtime LIKE '"+Showtime+"%';";
		//System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
public void add(String SeatNo,String Showtime) throws SQLException {
		sql = "Insert into seat (SeatNo,Showtime, Istaken) " + "values('" + SeatNo+ "', '" + Showtime
		+ "',"+0+");";
		//System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	} 
public int[][] getseatinfo(int n) throws SQLException
	{	 int i=0,j=0;
		int [][] seat=new int[5][5];
		if(n==1)
			sql = "SELECT * FROM seat WHERE Showtime LIKE '8:00 AM%'";
		else if(n==2)
			sql = "SELECT * FROM seat WHERE Showtime LIKE '12:00 PM%'";
		else if(n==3)
			sql = "SELECT * FROM seat WHERE Showtime LIKE '4:00 PM%'";
		else if(n==4)
			sql = "SELECT * FROM seat WHERE Showtime LIKE '8:00 PM%'";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int x = rs.getInt(4);
			seat[i][j]=x;
			j++;
			if(j==5)
			{
				i++;
				j=0;
			}
			
		}
		rs.close();
		stmt.close();
		return seat;
	}
public void deleteMovies(String Moviename) throws SQLException {
		sql = "DELETE FROM movies WHERE Moviename LIKE '"+Moviename+"%'";
	//	System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	public ArrayList<String> getMovie() throws SQLException{
		ArrayList<String> v=new ArrayList<String>() ;
		sql="SELECT Moviename from movies";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String Name = rs.getString(1);
			v.add(Name);
			}
		rs.close();
		stmt.close();
		return v;
		}
public Audience getAudience(int audId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id=" +audId;
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			String Showtime = rs.getString(4);
			String	SeatNoData=	rs.getString(5);
		 v = new Audience(Id,Name, Movies,Showtime, SeatNoData);
		}
		rs.close();
		stmt.close();
		return v;
	}
public Audience getaudienceByName(String input) throws SQLException {
	Audience v=null; 
		sql = "SELECT * FROM audience where Aname like '%" + input + "%'";
		//System.out.println(sql);
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			String Showtime= rs.getString(4);
			String SeatNoData=rs.getString(5);
			v = new Audience(Id,Name, Movies,Showtime, SeatNoData);
		}
		rs.close();
		stmt.close();
		return v;
	}
public List<Audience> getAllAudience() throws SQLException {
		Audience v;
		List<Audience> vList = new ArrayList<Audience>();
		sql = "SELECT * FROM audience";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			String Showtime = rs.getString(4);
			String SeatNo=rs.getString(5);
			v = new Audience(Id, Name, Movies, Showtime, SeatNo);
			vList.add(v);
			}
		rs.close();
		stmt.close();
		return vList;
	}
public Audience getAudienceSQLInjection(String auId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id='" + auId + "'";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		int Id = rs.getInt(1);
		String Name = rs.getString(2);
		String Movies = rs.getString(3);
		String Showtime = rs.getString(4);
		String SeatNo=rs.getString(5);
		v = new Audience(Id, Name, Movies, Showtime, SeatNo);
		rs.close();
		stmt.close(); 
		return v;
	}
public Audience getAudienceSQLInjectionPrev(String auId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id = ?";
	PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
		p.setString(1, auId);
		rs = p.executeQuery();
		rs.next();
		int Id = rs.getInt(1);
		String Name = rs.getString(2);
		String Movies = rs.getString(3);
		String Showtime = rs.getString(4); 
		String SeatNo=rs.getString(5);
		v = new Audience(Id, Name, Movies, Showtime, SeatNo);
		rs.close();
		stmt.close();
		return v;
	}
}
