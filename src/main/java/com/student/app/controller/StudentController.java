package com.student.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.module.Student;
import com.student.app.service.StudentService;


@RestController
public class StudentController 
{
	@Autowired
	StudentService service;
	
	
	@GetMapping("/allstudents")
    public Page<Student> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getAllStudents(pageable);
    }
	
	@GetMapping("/getStudentById")
	ResponseEntity<Student> getVehicle(@RequestHeader Integer id)
	{
		return new ResponseEntity<Student>(service.getById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getStudentByName")
	ResponseEntity<List<Student>> getbyname(@RequestHeader String name)
	{
		return new ResponseEntity<List<Student>>(service.getByName(name),HttpStatus.FOUND);
	}
	
	@GetMapping("/marksgreaterthan")
	ResponseEntity<List<Student>> getbyname(@RequestHeader Integer marks)
	{
		return new ResponseEntity<List<Student>>(service.getByMarksGreaterthan(marks),HttpStatus.FOUND);
	}
}
