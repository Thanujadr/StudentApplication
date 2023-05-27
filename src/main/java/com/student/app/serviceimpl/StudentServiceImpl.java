package com.student.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.student.app.module.Student;
import com.student.app.repo.StudentRepo;
import com.student.app.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepo repo;

	@Override
	public Page<Student> getAllStudents(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<Student> getByName(String name) {
		return repo.getByName(name);
	}

	@Override
	public List<Student> getByMarksGreaterthan(Integer marks) {
		return repo.getByMarksGreater(marks);
	}

	@Override
	public Student getById(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
