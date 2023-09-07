package ManyToOne_Uni2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ManyToOne_Uni2.dto.College;
import ManyToOne_Uni2.dto.Student;

public class CollegeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soham");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveCollege(College college) {
		entityTransaction.begin();
		entityManager.persist(college);
		entityTransaction.commit();
	}
	
	public void saveMultipleCollege() {
//		List<College> colleges = new ArrayList<College>();
		
	}
	
	public void findCollege(int id) {
		College college = entityManager.find(College.class, id);
		if (college != null) {
			System.out.println(college);
		} else {
			System.out.println("College with given id "+ id +" not found");
		}
	}
	
	public void findAllCollege() {
		Query query = entityManager.createQuery("select c from College c");
		System.out.println(query.getResultList());
	}
	
	public void deleteCollege(int id) {
		College college = entityManager.find(College.class, id);
		if (college != null) {
			entityTransaction.begin();
			entityManager.remove(college);
			entityTransaction.commit();
		} else {
			System.out.println("College with given id "+ id +" not found");
		}
	}
	
	public void updateCollege(int id,College college) {
		College dbCollege = entityManager.find(College.class, id);
		if (dbCollege != null) {
			college.setId(id);
			entityTransaction.begin();
			entityManager.merge(college);
			entityTransaction.commit();
		}else {
			System.out.println("College with given id "+ id +" not found");
		}
	}
}
