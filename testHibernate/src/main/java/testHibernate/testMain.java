package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {

	private static SessionFactory sessionFactory;// 하나만 만듬

	public static void main(String[] args) {
		/*
		 * Configuration conf = new Configuration();
		 * conf.configure("hibernate.cfg.xml");//hibernate.cfg.xml는 default 이름이라 이 줄은
		 * 안써도 되지만 이름이 다를경우 써야함 sessionFactory = conf.buildSessionFactory();
		 */
		sessionFactory = new Configuration().configure().buildSessionFactory();// 한줄로 쓰고싶을 때
		
		Category category1 = new Category();
		category1.setName("Computer");
		
		Category category2 = new Category();
		category2.setName("Car");
		
		
		
		
		Product product1 = new Product();
		product1.setName("notebook1");
		product1.setPrice(1000);
		product1.setDescription("Powerful notebook!!!");
		product1.setCategory(category1);
	
		category1.getProducts().add(product1);
		
		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(8000);
		product2.setDescription("Powerful Desktop!!!");
		product2.setCategory(category1);
		
		category1.getProducts().add(product2);
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(10000000);
		product3.setDescription("대중적인 자동차!!");
		product3.setCategory(category2);
		
		category2.getProducts().add(product3);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(category1);// DB에 저장이 됨 sqlStatement 불필요
		session.save(category2);
		
	
		
		//session.delete(product3);//이걸통해 delete하면 cascade.all을 줬기 때무에 product, category 둘다 사라진다.
		
		//product1.setCategory(null);
		//session.delete(product1);//1의경우 2가 있기때문에 지우면 안됨 이렇게되면 오류가 발생함. 그래서 윗줄처럼 연결을 끊어버려야함.
		
		//session.delete(category1);//이경우 카테고리1을 지우는데 연결된 애들까지 지우므로 product1,2도 지운다. bidirection,양방향 연결
		
		
		tx.commit();

		session.close();
		

	}
}
