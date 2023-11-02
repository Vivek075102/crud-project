<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="vivek.dao.Employeedao"%>
<%@page import="java.util.List"%>
<%@page import="vivek.dao.Employeedaoimp"%>
<%@page import="vivek.model.Employee"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page language="java" contentType="text/html;
 charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

			<% 
			Employeedaoimp imp = new Employeedaoimp();
			List<Employee> employees = imp.getAll();
			%>
    
<!DOCTYPE html>
<html>
<head>
<title>View</title>
<meta charset="ISO-8859-1">
<style type="text/css">
	*{
	background-color: pink;
	}
	
	body ,html{
	 height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
	}
	
	tabel{
	margin: auto;
	}
	
	h1{
			
			position: absolute;
			top: 0%;
			align-items: center;
			margin-left: auto;
			margin-right: auto;
	}
	
	tr th,td{
		padding: 5px;
	}
	
	
	a{
	position: absolute;
	bottom: 20%;
				align-items: center;
	
	
	}
	
	
</style>
</head>



<body>

	<h1>Data Saved</h1>
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
				for(Employee e:employees){
				
				%>
				<tr>
				<td><%= e.getUsn()%></td>
				<td><%=e.getUsername() %></td>
				<td><%=e.getPassword() %></td>
				<td><%=e.getEmail() %></td>
				<td><%=e.getGender() %></td>
				<td><%=e.getBranch() %></td>
				</tr>
		     
				<%
				}
				%>

				 </tbody>
	</table>
	</br>
	
	<a href="redirecttoview.html"><button>HOME</button></a>
</body>
</html>