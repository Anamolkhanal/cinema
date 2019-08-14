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


public class Database {
	String url = "jdbc:mysql://localhost:3306/graph";
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

		sql = "Insert into audience (Name,Movies,HallNo,SeatNo,Date,Time) " + "values('" + a.getName() + "', '" + a.getMovies()
				+ "', " + a.getHallNo() + ","+a.getSeatNo()+","+a.getDate()+","+a.getTime()+")";
		// System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public Audience getAudience(int audId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM vertex where id=" + auId;
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			int HallNo = rs.getInt(4);
			int SeatNo=rs.getInt(5);
			int Date=rs.getInt(6);
			int Time=rs.getTime(7);
			v = new Audience(Id, Name, Movies, HallNo, SeatNo, Date, Time);
		}
		rs.close();
		stmt.close();
		return v;
	}

	public Audience getaudienceByName(String input) throws SQLException {
	Audience v=null; 
		sql = "SELECT * FROM vertex where Name like '%" + input + "%'";
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
			int SeatNo=rs.getInt(5);
			int Date=rs.getInt(6);
			int Time=rs.getTime(7);
			v = new Audience(Id, Name, Movies, HallNo, SeatNo, Date, Time);
			
		}
		rs.close();
		stmt.close();
		return v;
	}

	public List<Audience> getAllAudience() throws SQLException {
		Audience v;
		List<Audience> vList = new ArrayList<Audience>();
		sql = "SELECT * FROM vertex";
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			int HallNo = rs.getInt(4);
			int SeatNo=rs.getInt(5);
			int Date=rs.getInt(6);
			int Time=rs.getTime(7);
			v = new Audience(Id, Name, Movies, HallNo, SeatNo, Date, Time);
			vList.add(v);

		}
		rs.close();
		stmt.close();
		return vList;
	}

	public Audience getAudienceSQLInjection(String auId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM vertex where id='" + auId + "'";
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		rs.next();
		int Id = rs.getInt(1);
		String Name = rs.getString(2);
		String Movies = rs.getString(3);
		int HallNo = rs.getInt(4);
		int SeatNo=rs.getInt(5);
		int Date=rs.getInt(6);
		int Time=rs.getTime(7);
		v = new Audience(Id, Name, Movies, HallNo, SeatNo, Date, Time);
		rs.close();
		stmt.close();
		return v;
	}

	public Audience getAudienceSQLInjectionPrev(String auId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM vertex where id = ?";
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
		int SeatNo=rs.getInt(5);
		int Date=rs.getInt(6);
		int Time=rs.getTime(7);
		v = new Audience(Id, Name, Movies, HallNo, SeatNo, Date, Time);
		rs.close();
		stmt.close();
		return v;
	}

}
