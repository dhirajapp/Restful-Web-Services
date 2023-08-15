package com.dhirajapp.restfulwebservices.user;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    // JPA/Hibernate -> Database
	// UserDaoService  -> static List
	private static int userCount=0;
	private static List<User> users=new ArrayList<>();
	
	static {
		users.add(new User(++userCount,"Dhiraj Kumar",LocalDate.now().minusYears(24)));
		users.add(new User(++userCount,"Sonu Kumar ",LocalDate.now().minusYears(32)));
		users.add(new User(++userCount,"Atherv Singh",LocalDate.now().minusYears(05)));
		users.add(new User(++userCount,"Neeraj Kumar",LocalDate.now().minusYears(18)));
		users.add(new User(++userCount,"Rajesh Kumar",LocalDate.now().minusYears(34)));
		users.add(new User(++userCount,"Suresh Kumar",LocalDate.now().minusYears(27)));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	
}
