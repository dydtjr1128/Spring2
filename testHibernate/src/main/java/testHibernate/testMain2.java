package testHibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class testMain2 {

	private static SessionFactory sessionFactory;// 하나만 만듬

	public static void main(String[] args) {
		/*
		 * Configuration conf = new Configuration();
		 * conf.configure("hibernate.cfg.xml");//hibernate.cfg.xml는 default 이름이라 이 줄은
		 * 안써도 되지만 이름이 다를경우 써야함 sessionFactory = conf.buildSessionFactory();
		 */
		sessionFactory = new Configuration().configure().buildSessionFactory();// 한줄로 쓰고싶을 때
		
		Person person1 = new Person();
		person1.setFirstName("Yongseok");
		person1.setLastName("Choi");
		
		License license1 = new License();
		license1.setLicenseNumber("123456");
		license1.setIssueDate(new Date());
		license1.setPerson(person1);
		
		person1.setLicense(license1);
		
		Person person2 = new Person();
		person2.setFirstName("Alice");
		person2.setLastName("Lee");
		
		License license2 = new License();
		license2.setLicenseNumber("463256");
		license2.setIssueDate(new Date());
		license2.setPerson(person2);
		
		person2.setLicense(license2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(person1);
		session.save(person2);
		
		tx.commit();

		Query query = session.createQuery("from Person where license.licenseNumber='463256'");
		List<Person> persons = query.list();
		for(Person person : persons) {
			System.out.println(person.getFirstName());
		}
		
		session.close();		
		

	}
}
