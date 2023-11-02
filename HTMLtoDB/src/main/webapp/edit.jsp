<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="vivek.dao.Employeedao"%>
<%@page import="java.util.List"%>
<%@page import="vivek.dao.Employeedaoimp"%>
<%@page import="vivek.model.Employee"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<link  rel="stylesheet" href="edit.css"> 
    <title>Edit User</title>
</head>
<body>

<header>
    <h1>Edit User Information</h1>
</header>
    
    
    <%
				long usn=Long.parseLong(request.getParameter("Usn"));
    			Employeedaoimp imp = new Employeedaoimp();
   		 		Employee e=imp.get(usn);
   
    %>
    
    
   
    <form action="updateUser" method="post">
        <!-- Hidden input field to store the user's USN for reference -->
        <input type="hidden" name="usn" value="${user.usn}">
        
     

       <div class="input-box">
        <label>USN</label>
        <input type="text" name="usn" value="<%=e.getUsn() %>" readonly>
       </div>
       
         <div class="input-box">
        <label>USERNAME</label><input type="text" name="username" value="<%=e.getUsername() %>" required>
        
        </div>
        
          <div class="input-box">
        	<label>PASSWORD</label> 
        	<input type="password" name="password" value="<%=e.getPassword() %>" required>
        
        </div>
        
          <div class="input-box">
        <label>EMAIL</label>
         <input type="email" name="email" value="<%=e.getEmail() %>" required>
        </div>
        
          <div class="input-box">
        <label>GENDER</label>
         <input type="text" name="gender" value="<%=e.getGender() %>" required>
        </div>
          <div class="input-box">
        <label>BRANCH</label>
        <input type="text" name="branch" value="<%=e.getBranch() %>" required><br>
        </div>

			
			<input type="hidden" name="Usn" value="<%=e.getUsn() %>">
        <input type="submit" value="Update">
    </form>
    
</body>
</html>





