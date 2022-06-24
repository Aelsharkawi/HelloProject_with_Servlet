package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Users {

	private String name, email, password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	Users conn = new Users();
	//connect database
	public Connection connectDB() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.64.3/servletDB","backend","backend");		

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;	
	}


	public void register()
	{
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.64.3/servletDB","backend","backend");
			String sql = "INSERT INTO `studentInfo`(`name`, `email`, `password`) VALUES (?,?,?)";
			PreparedStatement pst;
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, conn.getName());
			pst.setString(2, conn.getEmail());
			pst.setString(3, conn.getPassword());

			pst.executeUpdate();
			pst.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


}
