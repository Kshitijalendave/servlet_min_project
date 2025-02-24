package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            
            String name= request.getParameter("name");
            String password= request.getParameter("password");
            String email= request.getParameter("email");
            String country= request.getParameter("country");
            
            
//            out.print("welcome "+ name);

                  Employee e1= new Employee();
                  
                  e1.setName(name);
                  e1.setPassword(password);
                  e1.setEmail(email);
                  e1.setCountry(country);
                  
                  
                  
                  
              
					int ans=   EmpDao.save(e1);
					      
					  if(ans>0)
					  {
						    out.print("<h1>Record successfully Saved !!!!!</h1>");
						    request.getRequestDispatcher("index.html").include(request, response);
					  }else
					  {
						  out.print("<h1>Something wen wrong !!!!!</h1>");
					  }
			  
                   
                  out.close();
            
            
	}

}
