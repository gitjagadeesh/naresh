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

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String fname=request.getParameter("fname");
	  String lname=request.getParameter("lname");
	  String email=request.getParameter("email");
	  String training=request.getParameter("training");
	  String state=request.getParameter("state");
	  String course=request.getParameter("course");
	  Student std=new Student();
	  std.setFname(fname);
	  std.setLname(lname);
	  std.setEmail(email);
	  std.setTraining(training);
	  std.setState(state);
	  std.setCourse(course);
	  StudentService stdService=StudentServiceFactory.getStudentService();
	  String status=stdService.reg(std);
	  RequestDispatcher rd=null;
	  if(status.equals("success")) {
		  rd=request.getRequestDispatcher("status.jsp");
		  rd.forward(request,response);
	  }
	  else {
		  rd=request.getRequestDispatcher("failure.jsp");
		  rd.forward(request, response);
	  }
	  
	}

}
