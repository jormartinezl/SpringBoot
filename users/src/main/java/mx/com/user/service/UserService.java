package mx.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.com.user.entity.User;
import mx.com.user.repositories.UserReposotory;

@Service
public class UserService {

	@Autowired
	private UserReposotory userReposotory;
	
	public Page<User> getUsers(int page, int size){
		return userReposotory.findAll(PageRequest.of(page, size));
	}
	public List<String> getUsernames(){
		return userReposotory.getUsernames();
	}
	
	public User getUser(Integer id) {
		return userReposotory.findById(id).
				orElseThrow(()->
				new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %d not fount", id)));
	}
	public User getUserByUsername(String  username) {
		return userReposotory.findByUsername(username).
				orElseThrow(()->
				new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %s not fount", username)));
	}
}
