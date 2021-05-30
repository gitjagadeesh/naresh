package com.jaggu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaggu.beans.Student;
import com.jaggu.factory.StudentServiceFactory;
import com.jaggu.service.StudentService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String name=request.getParameter("name");
	  String email=request.getParameter("email");
	  Student std=new Student();
	  std.setFname(name);
	  std.setEmail(email);
	  
	  StudentService stdService=StudentServiceFactory.getStudentService();
	  String status=stdService.login(std);
	  RequestDispatcher rd=null;
	  if(status.equals("success")) {
		  rd=request.getRequestDispatcher("existed.jsp");
		  rd.forward(request, response);
	  }
	  else {
		  rd=request.getRequestDispatcher("failure.jsp");
		  rd.forward(request, response);
	  }
	}

}
