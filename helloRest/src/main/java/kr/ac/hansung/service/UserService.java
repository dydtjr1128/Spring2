package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import kr.ac.hansung.model.User;

@Service
public class UserService {
	//request가 들어오면 쓰레드가 만들어지는데 그때 id와 같이 여러 쓰레드가 공유하는 변수에대해 상호배제가 필요하다.
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	public UserService() {
		users = new ArrayList<User>();
		
		users.add(new User(counter.incrementAndGet(), "Sam", 30, 70000));
		users.add(new User(counter.incrementAndGet(), "Tom", 40, 50000));
		users.add(new User(counter.incrementAndGet(), "Jerome", 45, 30000));
		users.add(new User(counter.incrementAndGet(), "Silvia", 50, 40000));
	}
	public List<User> findAllUsers(){
		return users;
	} 	
	
	public User findById(long id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users) {
			if(user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}
	
	public void updateUser(User user) {
		int index = users. indexOf(user);
		users.set(index,user);
	}
	
	public void deleteUserById(long id) {
		for(Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}
	
	public void deleteAllUsers() {
		users.clear();
	}
	
}
