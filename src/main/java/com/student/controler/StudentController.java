package com.student.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}

	@GetMapping("/student/{id}")
	public Optional<Student> getStudnetById(@PathVariable("id") int id){
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/student")
	public void saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
	}
	@PutMapping("/student/{id}")
	public void updateStudent(@PathVariable("id")int id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudentById(@PathVariable("id")int id) {
		studentService.deleteById(id);
	}
}
