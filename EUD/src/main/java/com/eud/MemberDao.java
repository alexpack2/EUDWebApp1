package com.eud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class MemberDao {
	private String dbUrl = "jdbc:mysql://localhost:3306/eudb";
	private String dbUname = "root";
	private String dbPass = "root";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	private ArrayList<Member> members = new ArrayList<Member>();
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl,dbUname,dbPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public String delete(int id)
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		members.clear();
		String result = "Data deleted successfully";
		
		String sql1 = "DELETE from user_data where iduser=?";
		String sql2 = "SELECT user_data.*,work_data.work_address,home_data.home_address "
				    + "FROM user_data,home_data,work_data "
				    + "WHERE user_data.iduser = home_data.iduserh AND user_data.iduser = work_data.iduserw";
		
	    PreparedStatement ps;
	    
		try {
			ps = con.prepareStatement(sql1);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			ps.close();
			
			this.retrieve();
			/*
			 * preparedStmt = con.prepareStatement(sql2); ResultSet rs =
			 * preparedStmt.executeQuery(); while (rs.next()) { Member member = new
			 * Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.
			 * getString(5),rs.getString(6),rs.getString(7)); members.add(member); }
			 * preparedStmt.close();
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = "Data not deleted";
			e.printStackTrace();
		}
	    return result;
	}
	
	public String retrieve()
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		members.clear();
		String result = "Data retrieved successfully";
		String sql = "SELECT user_data.*,work_data.work_address,home_data.home_address "
				   + "FROM user_data,home_data,work_data "
				   + "WHERE user_data.iduser = home_data.iduserh AND user_data.iduser = work_data.iduserw";
		
		PreparedStatement ps;
		try {			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                Member member = 
                new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                members.add(member);
            }
			ps.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not retrieved";
		}
		return result;
	}
	
	public String insert(Member member) 
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data inserted successfully";
		String sql1 = "insert into user_data(name,surname,gender,birthdate) values(?,?,?,?)";
		String sql2 = "insert into work_data(work_address,iduserw) values(?,?)";
		String sql3 = "insert into home_data(home_address,iduserh) values(?,?)";
		
		PreparedStatement ps;
		try {	
			ps = con.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,member.getName());
			ps.setString(2,member.getSurname());
			ps.setString(3,member.getGender());
			ps.setString(4,member.getBirthdate());
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			
			int lastid=0;
			if(rs.next()){
				lastid=rs.getInt(1);
			}
			ps.close();
			
			ps = con.prepareStatement(sql2);
			ps.setString(1,member.getWaddress());
			ps.setString(2,String.valueOf(lastid));
			ps.executeUpdate();
			ps.close();
			
			ps = con.prepareStatement(sql3);
			ps.setString(1, member.getHaddress());
			ps.setString(2, String.valueOf(lastid));
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}

		return result;
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
}
