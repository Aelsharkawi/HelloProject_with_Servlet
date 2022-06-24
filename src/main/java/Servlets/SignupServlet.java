package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.ConnectDb;
import main.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//receive data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		//connect database

		//		Users user = new Users();
		//		user.setName(name);
		//		user.setEmail(email);
		//		user.setPassword(password);
		//		user.register();
		//		//			con.connectDB();
		//		//			
		//		//			String sql = "INSERT INTO `studentInfo`(`name`, `email`, `password`) VALUES (?,?,?)";
		//		//			PreparedStatement pst;
		//		//			pst = con.prepareStatement(sql);
		//		//			pst.setString(1, name);
		//		//			pst.setString(2, email);
		//		//			pst.setString(3, password);
		//		//
		//		//			pst.executeUpdate();
		//		//			pst.close();

		try {
			ConnectDb conDB = new ConnectDb();
			Connection con = conDB.connectDB();
			//		Class.forName("com.mysql.cj.jdbc.Driver");
			//		con = DriverManager.getConnection("jdbc:mysql://192.168.64.3/servletDB","backend","backend");
			String sql = "INSERT INTO `studentInfo`(`name`, `email`, `password`) VALUES (?,?,?)";
			PreparedStatement pst;
			int rs = 0;
			pst = con.prepareStatement(sql);

			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, password);
			if(name.isBlank() | email.isBlank() | password.isBlank())
			{
				request.getRequestDispatcher("index.html").include(request, response);
			}
			else {
				pst.executeUpdate();
				request.getRequestDispatcher("login.html").include(request, response);
			}
			
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
