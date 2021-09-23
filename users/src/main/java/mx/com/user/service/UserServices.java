package mx.com.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;

import mx.com.user.models.User;

@Service
public class UserServices {

	@Autowired
	private Faker faker;
	
	private List<User> users= new ArrayList<>();
	
	@PostConstruct
	public void init() {
		for(int i=0;i<100;i++){
			users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
		}
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public User getUser(String username) {
		return users.stream().filter(u->u.getUsername().equals(username)).findAny().
		orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("User %s not fount",username)));
	}
}
