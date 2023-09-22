package com.seed.service;

import com.seed.dao.StudentDao;
import com.seed.entitty.Student;

public class StudentService {
	
	private StudentDao dao = new StudentDao();
	
	public Student addStudent(Student student){
		return dao.addStudent(student);
	}

}
