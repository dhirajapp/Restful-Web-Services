package com.dhirajapp.restfulwebservices.user;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    // JPA/Hibernate -> Database
	// UserDaoService  -> static List
	
	private static List<User> users=new ArrayList<>();
	
	static {
		users.add(new User(01,"Dhiraj Kumar",LocalDate.now().minusYears(24)));
		users.add(new User(02,"Sonu Kumar ",LocalDate.now().minusYears(32)));
		users.add(new User(03,"Atherv Singh",LocalDate.now().minusYears(05)));
		users.add(new User(04,"Neeraj Kumar",LocalDate.now().minusYears(18)));
		users.add(new User(05,"Rajesh Kumar",LocalDate.now().minusYears(34)));
		users.add(new User(06,"Suresh Kumar",LocalDate.now().minusYears(27)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().get();
	}
}
