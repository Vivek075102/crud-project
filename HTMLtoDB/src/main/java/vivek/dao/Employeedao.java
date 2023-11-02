package vivek.dao;

import java.sql.SQLException;
import java.util.List;

import vivek.model.Employee;

public interface Employeedao {
	
	String INSERT_QUERY="INSERT INTO student(username,password,email,gender,branch) VALUES(?,?,?,?,?)";
	
	String UPDATE_QUERY="UPDATE  student set username=?, password=?, email=?, gender=?, branch=? where  usn=?";
	
	String DELETE_QUERY="DELETE  FROM  student WHERE usn =?";
	
	String DELETE_ALL_QUERY="DELETE student where usn=?, username=?, password=?, email=?, gender=?, branch=?";
	
	String SELECT_QUERY="SELECT * FROM student WHERE usn=?";
	
	String SELECT_ALL_QUERY="SELECT * FROM `student`";
	
	
	
	int save(Employee e);
	boolean update(Employee e) ;
	boolean delete(long usn);
	boolean delete(Employee e);
	Employee get(long usn);
	List<Employee>getAll();
	

}
