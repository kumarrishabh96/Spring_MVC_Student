package com.ty.spring_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.spring_mvc.dao.StudentDao;
import com.ty.springmvc.dto.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public Student saveStudent(Student student) {
		studentDao.saveStudent(student);
		return student;
	}
	public Student getStudentByEmail(Student student) {
		Student receivedStudent = studentDao.getStudentByEmail(student.getEmail());
		if (student.getPassword().equals(receivedStudent.getPassword())) {
			return receivedStudent;
		} else
			return null;
	}

	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
	}

	public Student getStudentById(int id) {

		return studentDao.findStudentById(id);
	}

	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}
}
