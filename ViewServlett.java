package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/viewServlet")
public class ViewServlett extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		 response.setContentType("text/html");
		 
		 PrintWriter out = response.getWriter();
		 
		 out.print("<a href='index.html'>  Add new MEployee </a>");
		 
		  out.print("<h1> Employee List </h1>");
		  
		  
		  
		List<Employee>   list      = EmpDao.getAllEmployee();
		      
		 
//		       for(Employee e : list)
//		       {
//		    	   
//		    	       out.println(e.getName() +" "+e.getPassword()+" "+e.getCountry());
//		    	   
//		       }
		
		
		 
		     out.print("<table border='2' cellspacing='0'  cellpadding='10'>");
		     
		                   out.print("<tr>");
		                       out.print("<th>Id</th>");
		                       out.print("<th>Name</th>");
		                       out.print("<th>Password</th>");
		                       out.print("<th>Email</th>");
		                       out.print("<th>Country</th>");
		                       out.print("<th>Edit</th>");
		                       out.print("<th>Delete</th>");
		                   out.print("</tr>");
		                   
		                   for(Employee e : list)
		                   {
		                	     out.print("<tr>");
		                	      out.print("<td>" + e.getId() + "</td>");
		                	      out.print("<td>" + e.getName() + "</td>");
		                	      out.print("<td>" + e.getPassword()+ "</td>");
		                	      out.print("<td>" + e.getEmail() + "</td>");
		                	      out.print("<td>" + e.getCountry() + "</td>");
		                	      out.print("<td> <a href='editServlet?id="+e.getId()+"'> Edit</td>");
		                	      out.print("<td> <a href='deleteServlet?id="+e.getId()+"'> Delete</td>");
		                	     out.print("</tr>");
		                	   
		                   }
		     
		     
		     
		     out.print("</table>");
		
		
		
	}



}
