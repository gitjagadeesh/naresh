package com.jaggu.service;

import com.jaggu.beans.Student;
import com.jaggu.dao.StudentDao;
import com.jaggu.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	public String reg(Student std) {
		StudentDao stdDao=StudentDaoFactory.getStudentDao();
		String status=stdDao.reg(std);
		return status;
	}

	public String login(Student std) {
		StudentDao stdDao=StudentDaoFactory.getStudentDao();
		String status=stdDao.login(std);
		return status;
	}

}
