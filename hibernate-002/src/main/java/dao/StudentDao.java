package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Student;
import util.HibernateUtil;

public class StudentDao {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.persist(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Student getStudent(Long id) 
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
		  session.persist(Student.class);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
