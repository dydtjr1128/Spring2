package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.User;

@Repository
@Transactional
public class UserDao {
   
	@Autowired
	private PasswordEncoder passwordEncoder;
	//StandardPasswordEncoder는 SHA-256알고리즘 암호화로 256비트(32바이트)로 저장이 된다. 해싱이기 때문에 비밀번호를 압축해서 출력한다.
	// 새로운 시스템의 경우 BCryptPasswordEncoder로 하는것이 더 낫다. 얘도 해싱이기 때문에 비밀번호를 압축해서 출력한다.
	//Hashing vs Encrypted 위의것은 Hashing
   @Autowired
   private SessionFactory sessionFactory;
   
   public void addUser(User user) {
      Session session = sessionFactory.getCurrentSession();
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      session.saveOrUpdate(user);
      
      session.flush();
   }
   
   public User getUserById(int userId) {
      Session session = sessionFactory.getCurrentSession();
      return (User) session.get(User.class, userId);
   }
   
   @SuppressWarnings("unchecked")
   public User getUserByUsername(String username) {
      Session session = sessionFactory.getCurrentSession();
      TypedQuery<User> query = session.createQuery("from User where username=?");
      query.setParameter(0, username);
      
      return query.getSingleResult();
   }

   @SuppressWarnings("unchecked")
   public List<User> getAllUsers(){
      Session session = sessionFactory.getCurrentSession();
      TypedQuery<User> query = session.createQuery("from User");   
      List<User> userList = query.getResultList();
      
      return userList;
   }
   
}