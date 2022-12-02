package com.ty.spring_mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springmvc.dto.Student;

@Repository
public class StudentDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Student saveStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public Student updateStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}

	public Student deleteStudent(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return student;
	}

	public Student findStudentById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Student.class, id);
	}

	public List<Student> getAllStudent() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select s from Student s");
		return query.getResultList();
	}

	public Student getStudentByEmail(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select s from Student s where s.email=?1", Student.class);
		query.setParameter(1, email);
		return (Student) query.getSingleResult();
	}
}
