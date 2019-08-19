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

		sql = "Insert into audience (Aname,Mname,hallNo,SeatNoData) " + "values('" + v.getAname()+ "', '" + v.getMname()
				+ "', " + v.getHallNo() + ",'"+v.getSeatNo()+"')";
		//System.out.println(sql);
	    stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	public void addmovies(Movies v) throws SQLException {

		sql = "Insert into movies (Moviename,Releasedate,PriceperSeat) " + "values('" + v.getMoviename()+ "', '" + v.getReleasedate()
				+ "', " + v.getPriceperSeat() + ")";
		System.out.println(sql);
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
			//System.out.println(Name);
			v.add(Name);
		}
		rs.close();
		stmt.close();
		//System.out.println(v);
		return v;
}

	public Audience getAudience(int audId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id=" +audId;
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			int HallNo = rs.getInt(4);
			String	SeatNoData=	rs.getString(5);
		//	int Date=rs.getInt(6);
		//  int Time=rs.getTime(7);
		 v = new Audience(Id,Name, Movies,HallNo, SeatNoData);
		}
		rs.close();
		stmt.close();
		return v;
	}

	public Audience getaudienceByName(String input) throws SQLException {
	Audience v=null; 
		sql = "SELECT * FROM audience where Aname like '%" + input + "%'";
		System.out.println(sql);
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			int HallNo = rs.getInt(4);
			String SeatNoData=rs.getString(5);
			//int Date=rs.getInt(6);
			//int Time=rs.getTime(7);
			v = new Audience(Id,Name, Movies,HallNo, SeatNoData);
			
		}
		rs.close();
		stmt.close();
		return v;
	}

	public List<Audience> getAllAudience() throws SQLException {
		Audience v;
		List<Audience> vList = new ArrayList<Audience>();
		sql = "SELECT * FROM audience";
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			int HallNo = rs.getInt(4);
			String SeatNo=rs.getString(5);
			//int Date=rs.getInt(6);
			//int Time=rs.getTime(7);
			v = new Audience(Id, Name, Movies, HallNo, SeatNo);
			vList.add(v);

		}
		rs.close();
		stmt.close();
		return vList;
	}

	public Audience getAudienceSQLInjection(String auId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id='" + auId + "'";
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		rs.next();
		int Id = rs.getInt(1);
		String Name = rs.getString(2);
		String Movies = rs.getString(3);
		int HallNo = rs.getInt(4);
		String SeatNo=rs.getString(5);
		//int Date=rs.getInt(6);
		//int Time=rs.getTime(7);
		v = new Audience(Id, Name, Movies, HallNo, SeatNo);
		rs.close();
		stmt.close(); 
		return v;
	}

	public Audience getAudienceSQLInjectionPrev(String auId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id = ?";
		// 3. prepare sql statement to be executed
		PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
		p.setString(1, auId);
		// 4 get the resultset from execution
		rs = p.executeQuery();
		rs.next();
		int Id = rs.getInt(1);
		String Name = rs.getString(2);
		String Movies = rs.getString(3);
		int HallNo = rs.getInt(4); 
		String SeatNo=rs.getString(5);
		//int Date=rs.getInt(6);
		//int Time=rs.getTime(7);
		v = new Audience(Id, Name, Movies, HallNo, SeatNo);
		rs.close();
		stmt.close();
		return v;
	}

}
