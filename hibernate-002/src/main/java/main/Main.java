package main;

import dao.StudentDao;
import entity.Student;
import util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setName("John Doe");
		student1.setRollNumber("121");

		Student student2 = new Student();
		student2.setName("Jane Smith");
		student2.setRollNumber("122");

		StudentDao studentDao = new StudentDao();
		studentDao.saveStudent(student1);
		studentDao.saveStudent(student2);

		// Get the ID *after* saving
		Student retrievedStudent = studentDao.getStudent(student1.getId());

		if (retrievedStudent != null) {
			System.out.println("Retrieved Student: " + retrievedStudent);
		} else {
			System.out.println("Student not found with id: " + student1.getId());
		}

		HibernateUtil.shutdown();
	}
}
