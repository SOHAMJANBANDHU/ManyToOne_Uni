package ManyToOne_Uni2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ManyToOne_Uni2.dto.College;
import ManyToOne_Uni2.dto.Student;

public class StudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soham");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveStudent(Student student,int cid) {
		
		College college = entityManager.find(College.class, cid);
		
		if (college !=null) {
			student.setCollege(college);
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		} else {
			System.out.println("College with given id "+ cid +" not found");
		}
	}
	
	public void findStudent(int id) {
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("student with given id "+ id +" not found");
		}
	}
	public void FindAllStudent() {
		Query query = entityManager.createQuery("Select s from Student s");
		System.out.println(query.getResultList());
	}
	
	public void deleteStudent(int id) {
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
		}
		else {
			System.out.println("student with given id "+ id +" not found");
		}
	}
	
	public void updateStudent(int id, Student student) {
		Student dbStudent = entityManager.find(Student.class, id);
		
		if (dbStudent != null) {
			student.setId(id);
			student.setCollege(dbStudent.getCollege());
			
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		} else {
			System.out.println("student with given id "+ id +" not found");
		}
	}
}
