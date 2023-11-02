package vivek.application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vivek.dao.Employeedaoimp;
import vivek.model.Employee;

@WebServlet("/del")
public class deleteservlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long usn=Long.parseLong(req.getParameter("Usn"));
		
				
		Employeedaoimp e=new Employeedaoimp();
		
		boolean f=e.delete(usn);
		
		if(f)
		{
			req.setAttribute("successMessage", "Record updated successfully!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("sucess2.jsp");
            dispatcher.forward(req, resp);
			//resp.sendRedirect("design3.jsp");		
			}
			
			
	
		
		
	}
}
