package com.jaggu.factory;

import com.jaggu.service.StudentService;
import com.jaggu.service.StudentServiceImpl;

public class StudentServiceFactory {
  private static StudentService stdService;
  static {
	  
	  stdService=new StudentServiceImpl();
  }
  public static StudentService getStudentService() {
	  return stdService;
  }
}
