package ManyToOne_Uni2.mainController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ManyToOne_Uni2.dao.CollegeDao;
import ManyToOne_Uni2.dao.StudentDao;
import ManyToOne_Uni2.dto.College;
import ManyToOne_Uni2.dto.Student;
import net.bytebuddy.asm.MemberSubstitution.Substitution.Stubbing;

public class MainController {

	public static void main(String[] args) {
		
//		College college = new College();
//		college.setId(101);
//		college.setName("raisoni");
//		college.setFees(2000);
//		
//		
//		Student s1 = new Student();
//		s1.setId(1);
//		s1.setName("soham");
//		s1.setPhone(912123468);
//		s1.setAddress("nagpur");
//		s1.setCollege(college);
//		
//		Student s2 = new Student();
//		s2.setId(2);
//		s2.setName("kalu");
//		s2.setPhone(412123468);
//		s2.setAddress("pune");
//		s2.setCollege(college);
//		
//		Student s3 = new Student();
//		s3.setId(3);
//		s3.setName("bholu");
//		s3.setPhone(985123468);
//		s3.setAddress("delhi");
//		s3.setCollege(college);
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soham");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		
//		entityTransaction.begin();
//		entityManager.persist(college);
//		entityManager.persist(s1);
//		entityManager.persist(s2);
//		entityManager.persist(s3);
//		entityTransaction.commit();
		
//		CollegeDao dao = new CollegeDao();
//		dao.saveCollege(college);
		
//		StudentDao dao = new StudentDao();
//		dao.saveStudent(s1, 101);
//		dao.saveStudent(s2, 101);
//		dao.saveStudent(s3, 101);
		
		College college = new College();
		Student student = new Student();
		
		CollegeDao collegeDao = new CollegeDao();
		StudentDao studentDao = new StudentDao();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select option for the task \n1. college interface \n2. student interface");
		int option = scanner.nextInt();
		switch (option) {
		
		case 1:
		{
			System.out.println("college interface \n\n1. save college details \n2. find college"
					+ "\n3. fetch all college \n4. update college \n5. delete college ");
			int key = scanner.nextInt();
			switch (key) {
			
				case 1:
					{
//					System.out.println("how many colleges do you want to add");
//					int a = scanner.nextInt();
				
//					List<College> colleges =new  ArrayList<College>();
//					for (int i = 0; i < a; i++) {			
//					System.out.println("Enter college id");
//					college.setId(scanner.nextInt());
//					System.out.println("Enter college name");
//					college.setName(scanner.next());
//					System.out.println("Enter college fees");
//					college.setFees(scanner.nextLong());
//					System.out.println();
//					}
						System.out.println("Enter college id");
						college.setId(scanner.nextInt());
						System.out.println("Enter college name");
						college.setName(scanner.next());
						System.out.println("Enter college fees");
						college.setFees(scanner.nextLong());
						System.out.println();
			
						collegeDao.saveCollege(college);
						break;
					}
					case 2:
					{
						System.out.println("Enter id to find college");
						int id =scanner.nextInt();
						
						collegeDao.findCollege(id);
						break;
					}
					case 3:
					{
						System.out.println("here are the details of all college");
						collegeDao.findAllCollege();
						break;
					}
					case 4:
					{
						System.out.println("Enter college id");
						int id =scanner.nextInt();
						System.out.println("Enter college name");
						college.setName(scanner.next());
						System.out.println("Enter college fees");
						college.setFees(scanner.nextLong());
						System.out.println();
						
						collegeDao.updateCollege(id, college);
						break;
					}
					case 5:
					{
						System.out.println("Enter college id");
						int id =scanner.nextInt();
						
						collegeDao.deleteCollege(id);
						break;
					}
					default:
					{
						System.out.println("Enter a valid option");
						break;
					}
				}
			break;
			}
			
		case 2:
		{
			System.out.println("student interface \n\n1. save student details \n2. find student "
					+ "\n3. fetch all student \n4. update student \n5. delete student \n6. delete both");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
			{
				System.out.println("Enter college id");
				int id = scanner.nextInt();
				System.out.println("Enter student id");
				student.setId(scanner.nextInt());
				System.out.println("Enter student name");
				student.setName(scanner.next());
				System.out.println("Enter student phone");
				student.setPhone(scanner.nextLong());
				System.out.println("Enter student address");
				student.setAddress(scanner.next());
				
				studentDao.saveStudent(student, id);
				break;
			}
			case 2:
			{
				System.out.println("Enter student id");
				int id = scanner.nextInt();
				
				studentDao.findStudent(id);
				break;
			}
			case 3:
			{
				System.out.println("Here are the details of all student");
				studentDao.FindAllStudent();
				break;
			}
			case 4:
			{
				System.out.println("Enter student id");
				int id = scanner.nextInt();
				System.out.println("Enter student name");
				student.setName(scanner.next());
				System.out.println("Enter student phone");
				student.setPhone(scanner.nextLong());
				System.out.println("Enter student address");
				student.setAddress(scanner.next());
				
				studentDao.updateStudent(id, student);
				break;
			}
			case 5:
			{
				System.out.println("Enter student id");
				int id = scanner.nextInt();
				
				studentDao.deleteStudent(id);
				break;
			}
			case 6:
			{
//				pending work
				break;
			}
			default:
			{
				System.out.println("Enter a valid option");
				break;
			}
			}
			break;
		}
		default:
		{
			System.out.println("Enter a valid option");
			break;
		}
		}
	}
}
