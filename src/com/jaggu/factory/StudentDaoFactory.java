package com.jaggu.factory;

import com.jaggu.dao.StudentDao;
import com.jaggu.dao.StudentDaoImpl;

public class StudentDaoFactory {
 private static StudentDao stdDao;
 static {
	 stdDao=new StudentDaoImpl();
 }
 public static StudentDao getStudentDao() {
	 return stdDao;
 }
}
