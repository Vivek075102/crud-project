package vivek.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import vivek.dao.Employeedao;
import vivek.dao.Employeedaoimp;
import vivek.model.Employee;

@WebServlet("/updateuser")
public class updateservlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			long usn=Long.parseLong(req.getParameter("Usn"));
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");
	        String email = req.getParameter("email");
	        String gender = req.getParameter("gender");
	        String branch = req.getParameter("branch");
	        
	        Employee emp=new Employee(usn, username, password, email, gender, branch);
	        
	        Employeedaoimp e= new Employeedaoimp();
	        boolean f=e.update(emp);

	        
	        if(f)
	        {
	        	req.setAttribute("successMessage", "Record updated successfully!");
	            RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
	            dispatcher.forward(req, resp);

	        	//resp.sendRedirect("design2.jsp");
	        	
	        }

	    }
	
	}

