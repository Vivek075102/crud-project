package vivek.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vivek.dao.Employeedaoimp;
import vivek.model.Employee;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String registeredUsername = req.getParameter("username1");
			String registeredpassword = req.getParameter("password1");
			String email = req.getParameter("mail");
			String gender = req.getParameter("gender");
			String branch = req.getParameter("branch");
			
			
			Employee employee = new Employee(0, registeredUsername, registeredpassword, email, gender, branch);
			
			
			Employeedaoimp imp = new Employeedaoimp();
			imp.save(employee);
			
			
			//imp.delete(employee);
			
			//imp.delete(0);
			
			//imp.get(0);
			 
			List<Employee> employees = imp.getAll();
			
			req.setAttribute("listuser", employees);
			RequestDispatcher rd = req.getRequestDispatcher("redirecttoview.html");
			rd.forward(req, resp);
		
			

			//resp.sendRedirect("design.jsp");
		}

}

