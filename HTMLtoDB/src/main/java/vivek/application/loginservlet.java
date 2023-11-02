package vivek.application;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginservlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	
		String username = req.getParameter("username");
		String password= req.getParameter("password");

	        try {
	        	   Class.forName("com.mysql.jdbc.Driver");
	        	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "vivek@1047");
	        	   PreparedStatement pst = conn
	        	   .prepareStatement("Select username,password from student where username=? and password=?");
	        	   pst.setString(1, username);
	        	   pst.setString(2, password);
	        	   ResultSet rs = pst.executeQuery();
	        	   if (rs.next()) {
	        	    req.getRequestDispatcher("redirecttoview.html").include(req, resp);
	        	   } else 
	        	   {
	        	    req.getRequestDispatcher("loginsucess.jsp").include(req, resp);
	        	   }
	        	  } catch (ClassNotFoundException | SQLException e) {
	        	   e.printStackTrace();
	        	  }
	        	 }
	        	}
		
