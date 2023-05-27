package com.student.app.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.student.app.module.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{
	@Query(value="select * from student where name=?1",nativeQuery = true)
	List<Student> getByName(String name);
	
	@Query(value="select * from student where totalmarks>=?1",nativeQuery=true)
	List<Student> getByMarksGreater(Integer marks);
}
