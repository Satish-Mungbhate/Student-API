package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	public StudentService(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}
	
	public List<Student> getAllStudent(){
		return studentRepo.findAll();
	}
	
	public Optional<Student> getStudentById(int id){
		return studentRepo.findById(id);
	}
	
	public void saveStudent(Student student) {
		studentRepo.save(student);
	}
	
	public void updateStudent(int id, Student student) {
		if(studentRepo.existsById(id)) {
			Student std=studentRepo.findById(id).get();
			std.setName(student.getName());
			std.setFname(student.getFname());
			std.setMarks(student.getMarks());
			std.setDepartment(student.getDepartment());
			studentRepo.save(std);
		}
	}
	
	public void deleteById(int id) {
		studentRepo.deleteById(id);
	}
	

}
