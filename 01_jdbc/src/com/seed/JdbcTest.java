package com.seed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
	
	public static void main(String[] args) throws Exception{
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
		String username ="hr";
		String password ="hr";
		
		//step 1: load the driver
		Class.forName(driver);
		
		System.out.println("Driver loaded successfully");
		
		//Connection Object
		Connection con = DriverManager.getConnection(url,username,password);
		
		//Statement   PreparedStatement CallableStatment
		
		insertExample(con);
		
		
	}
	
	public static void insertExample(Connection con) {
		
		
		Employee e1 = new Employee(101,"jack",1000);
		List<String> mobiles = new ArrayList<String>();
		mobiles.add("1231231223");
		mobiles.add("1231231444");
		e1.setMobiles(mobiles);
		
		
		String sql ="insert into emp(id,name,salary) values (?,?,?)";
		String mobileSqlQuery = "insert into mobiles(emp_id,mob_no) values (?,?)";
		try {
			PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setInt(1, e1.getId());
			ps1.setString(2, e1.getName());
			ps1.setDouble(3, e1.getSalary());
			ps1.executeUpdate();
			
			PreparedStatement ps2 = con.prepareStatement(mobileSqlQuery);
			for(String s:e1.getMobiles()) {
				ps2.setInt(1, e1.getId());
				ps2.setString(2, s);
				ps2.executeUpdate();
			}
			
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	


}
