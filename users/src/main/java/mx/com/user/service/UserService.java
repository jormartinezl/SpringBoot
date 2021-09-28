package mx.com.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.com.user.entity.User;
import mx.com.user.repositories.UserReposotory;

@Service
public class UserService {

	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	
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
	
	@CacheEvict("users")
	public void deleteUser(String username) {
		User user = getUserByUsername(username);
		userReposotory.delete(user);
	}
	
	@Cacheable("users")//se agrega a cache
	public User getUserByUsername(String  username) {
		log.info("Getting user by username {}",username);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return userReposotory.findByUsername(username).
				orElseThrow(()->
				new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %s not fount", username)));
	}
}
