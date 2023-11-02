<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="vivek.dao.Employeedao"%>
<%@page import="java.util.List"%>
<%@page import="vivek.dao.Employeedaoimp"%>
<%@page import="vivek.model.Employee"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="javax.servlet.RequestDispatcher"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>

<header>
<h1>Deletion Sucessfull!!!!!!
</h1>
</header>


<% 
			Employeedaoimp imp = new Employeedaoimp();
			List<Employee> employees = imp.getAll();
			%>
    
    
    <%

    String name = request.getParameter("username");
	String pass = request.getParameter("password");
	String email = request.getParameter("mail");
	String gender = request.getParameter("gender");
	String branch = request.getParameter("branch");
    
    Employee e = new Employee(0, name, pass, email, gender, branch);
	Employeedaoimp impo = new Employeedaoimp();

  
    %>
    
    </br>
    
    <table border=2>
	<thread>
		
				<tr>
				<th>USN</th>
				<th>Username</th>
				<th>Password</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Branch</th>
				</tr>
				 </thread>
				 <tbody>
				<%
				for(Employee em:employees){
				
				%>
				<tr>
				<td><%=em.getUsn()%></td>
				<td><%=em.getUsername() %></td>
				<td><%=em.getPassword() %></td>
				<td><%=em.getEmail() %></td>
				<td><%=em.getGender() %></td>
				<td><%=em.getBranch() %></td>
				
				<td>
				
				
				
				
				</td>
				</tr>
		     
				<%
				}
				%>

				 </tbody>
	</table>
    
    <br>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>

<body>
<a href="redirecttoview.html"><button>HOME</button></a>
</body>
</html>

</br>