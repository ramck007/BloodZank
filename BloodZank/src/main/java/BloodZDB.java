import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BloodZDB {
	
	private String dbURL="jdbc:mysql://localhost:3306/bloodzank";
	private String dbUname="root";
	private String dbPass="1234";
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con= null;
		try {
			con = DriverManager.getConnection(dbURL,dbUname,dbPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public String insert(BloodZData bz) {
		loadDriver(dbDriver);
		Connection con= getConnection();
		String result="Data Entered Successfully";
		String sql="insert into bloodzank values(?,?,?,?,?,?,?,?,?,?,?);";
		
		PreparedStatement ps;
		//uname , aadhar , email , pin , bloodgrp , gender , number , location , address , date , willing ;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bz.uname);
			ps.setString(2, bz.aadhar);
			ps.setString(3, bz.email);
			ps.setString(4, bz.pin);
			ps.setString(5, bz.bloodgrp);
			ps.setString(6, bz.gender);
			ps.setString(7, bz.number);
			ps.setString(8, bz.location);
			ps.setString(9, bz.address);
			ps.setString(10, bz.date);
			ps.setString(11, bz.willing);
		
			ps.executeUpdate();
		} catch (SQLException e) {
			result="OOps! Data not Entered";
			e.printStackTrace();
		}
		
		
		
		return result;
	}

	public boolean check(BloodZData bzl) {
		loadDriver(dbDriver);
		Connection con= getConnection();
		String result = null;
		boolean status=false;
	    
		String sql="select * from bloodzank where email=? and pin=?;";
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bzl.email);
			ps.setString(2, bzl.pin );
			
			 ResultSet rs=ps.executeQuery();
			status=rs.next(); 
			rs.getString(1);		 //System.out.println(s3);
				/*
				 * if(s3==s2) { result="Logged"; } else { result="OOPs"; }
				 */
		} catch (SQLException e) {
			result="OOps! Data not Entered";
			e.printStackTrace();
		}
		
		return status;


	}
	
	/*
	public String check(BloodZData bzl) {
		loadDriver(dbDriver);
		Connection con= getConnection();
		String result = null;
		String result1 = null;
		String result2= null;
		boolean status=false;
	    
		String sql="select * from bloodzank where email=? and pin=?;";
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bzl.getEmail());
			ps.setString(2, bzl.getPin());
			
			 ResultSet rs=ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				result1 = rs.getString(1);//+" "+rs.getString(8);
				result2 = rs.getString(8);
			}
			System.out.println(result);
			//rs.getString(1);		 //System.out.println(s3);
				/*
				 * if(s3==s2) { result="Logged"; } else { result="OOPs"; }
				 
		} catch (SQLException e) {
			result="OOps! Data not Entered";
			e.printStackTrace();
		}
		
		result=result1+result2;
		return result;


	}*/
	
	
	
	
	

}
