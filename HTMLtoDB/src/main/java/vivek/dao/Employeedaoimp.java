package vivek.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vivek.model.Employee;

public  class Employeedaoimp implements Employeedao {
	
	
	static public final String URL="jdbc:mysql://localhost:3306/studentdb";
	static public final String USERNAME="root";
	static public final String PASSWORD="vivek@1047";
	
	static public Connection connection=null;
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

	@Override
	public int save(Employee e)  {
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);
			
			pstmt.setString(1, e.getUsername());
			pstmt.setString(2, e.getPassword());
			pstmt.setString(3, e.getEmail());
			pstmt.setString(4, e.getGender());
			pstmt.setString(5, e.getBranch());
			
			return pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public boolean update(Employee e) 
	{
		boolean f=false;
		try {
			 
	       PreparedStatement  pstmt = connection.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, e.getUsername());
			pstmt.setString(2, e.getPassword());
			pstmt.setString(3, e.getEmail());
			pstmt.setString(4, e.getGender());
			pstmt.setString(5, e.getBranch());
			pstmt.setLong(6, e.getUsn());
			
			 int res = pstmt.executeUpdate();
			 
			 if(res==1)
			 {
				 f=true;
			 }
			 
			
			
		} catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return f;
	}

	@Override
	public boolean delete(long usn) {
		boolean f=false;
		try {
			PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);
			
			pstmt.setLong(1, usn);
			int res = pstmt.executeUpdate();
			
			if(res==1)
			{
				f=true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
		
	}

	@Override
	public boolean delete(Employee e) {
		
		boolean f=false;

		try
		{
		PreparedStatement pstmt=connection.prepareStatement(DELETE_ALL_QUERY);
		pstmt.setLong(1, e.getUsn());
		pstmt.setString(2, e.getUsername());
		pstmt.setString(3, e.getPassword());
		pstmt.setString(4, e.getEmail());
		pstmt.setString(5, e.getGender());
		pstmt.setString(6, e.getBranch());
		
		 int res = pstmt.executeUpdate();
		 if(res==1)
			{
				f=true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return f;
		

	}

	@Override
	public Employee get(long usn) {
				Employee emp=null;
		
			try {
				PreparedStatement pstmt = connection.prepareStatement(SELECT_QUERY);
				pstmt.setLong(1, usn);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next())
						{
					 String name = rs.getString("username");
					 String pass = rs.getString("password");
					 String email = rs.getString("email");
					 String gender = rs.getString("gender");
					 String branch = rs.getString("branch");
					 
					  emp = new Employee(usn, name, pass, email, gender, branch);
						
						}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		Statement statement=null;
		ResultSet resultset=null;
		
		ArrayList<Employee> employee=new ArrayList<Employee>();
		
		 try {
			statement = connection.createStatement();
			 resultset = statement.executeQuery(SELECT_ALL_QUERY);
			 while(resultset.next())
			 {
				 int usn = resultset.getInt("usn");
				 String name = resultset.getString("username");
				 String pass = resultset.getString("password");
				 String email = resultset.getString("email");
				 String gender = resultset.getString("gender");
				 String branch = resultset.getString("branch");
				 
				 Employee emp = new Employee(usn, name, pass, email, gender, branch);
				 
				 employee.add(emp);
				 
				 
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employee;
	}
	

}
