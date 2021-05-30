package com.jaggu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jaggu.beans.Student;
import com.jaggu.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	public String reg(Student std) {
		String status="";
		try
		{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			String query="insert into student values('"+std.getFname()+"','"+std.getLname()+"','" 
					+std.getEmail()+"','"+std.getTraining()+"','"+std.getState()+"','"+std.getCourse()+"')";
			int rowCount=st.executeUpdate(query);
			if(rowCount==1) {
				status="success";
			}
			else
			{
				status="failure";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public String login(Student std) {
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			String query="select * from student where fname='"+std.getFname()+"' and email='"+std.getEmail()+"'";
			ResultSet rs=st.executeQuery(query);
			boolean b=rs.next();
			if(b==true) {
				status="success";
			}
			else {
				status="failure";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
