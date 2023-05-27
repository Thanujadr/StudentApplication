package com.student.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.student.app.module.Student;

public interface StudentService {

	Page<Student> getAllStudents(Pageable pageable);
	
	Student getById(Integer id);
	
	List<Student> getByName(String name);
	
	List<Student> getByMarksGreaterthan(Integer marks);

}
