package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	
	static final String url="jdbc:mysql://localhost/servletminiproject";
	static final String username="root";
	static final String pass="root";
	static Connection con;
	
     public static  Connection getconnection() {
		   
		       Connection con=null;
		       
		       try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/servletminiproject","root","root");
				
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
		     return con;
	   }
	   
	   
	   public static int save(Employee e) {
		   
		   int status=0;
		   
		  
		    try {
		    	Connection con=EmpDao.getconnection();
				PreparedStatement ps= con.prepareStatement("insert into emp(name,password,email,country) values(?,?,?,?)");
			
		        ps.setString(1, e.getName());
		        ps.setString(2, e.getPassword());
		        ps.setString(3,e.getEmail());
		        ps.setString(4,e.getCountry());
		        
		        status =ps.executeUpdate();
		    
		    
		    
		    
		    
		    } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   
		   
		       
		   
		   
		   return status;
		   
		   
	   }
	                 public static int update(Employee e)
	                 {
	                	 return 0;
	                 }
	                 public static int delete(int id)
	                 {
	                	 int status =0;
	                	  Connection con= EmpDao.getconnection();
	                	  PreparedStatement p;
						try {
							p = con.prepareStatement("delete from emp where id=?");
							   p.setInt(1, id);
							   
							    status= p.executeUpdate();
							    
							    con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                	  
	                	  
	                	 
	                	 
	                	 return status;
	                 }
	                 
	                 public static Employee getEMployeebyID(int id)
	                 {
	                	 return null;
	                 }
	                 
	                 public static List<Employee> getAllEmployee()
	                 {
	                	 ArrayList<Employee> list = new ArrayList<Employee>();
	                	
	                	         
	                	    try {
	                	        Connection con =EmpDao.getconnection();
								PreparedStatement p =con.prepareStatement("select * from emp");
						            
								ResultSet rs= p.executeQuery();
								
								    while(rs.next())
								    {
								    	 Employee e= new Employee();
								    	  
								    	    e.setId(rs.getInt(1));
								    	    e.setName(rs.getString(2));
								    	    e.setPassword(rs.getString(3));
								    	    e.setEmail(rs.getString(4));
								    	    e.setCountry(rs.getString(5));
								    	    
								    	     list.add(e);
								    	 
								    	
								    }
								
								
								
	                	    } catch (SQLException e) {
								
								e.printStackTrace();
							}
	                	    
	                	        
	                	 
	                	 return list;
	                 }
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	
}
