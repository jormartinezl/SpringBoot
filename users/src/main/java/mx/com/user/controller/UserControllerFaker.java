package mx.com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.user.models.User;
import mx.com.user.service.UserServicesFaker;

@RestController
@RequestMapping("/usersFaker")
public class UserControllerFaker {

	@Autowired
	private UserServicesFaker userService;
	
	/*
	 * se usa @RequestParam cuando se quiere conseguir un conjunto de objetos
	 * se usa @PathVariable cuando se quiere acceder a un unico objeto
	 */
	@GetMapping
	public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String startWhit){
		return new ResponseEntity<List<User>> (userService.getUsers(startWhit),HttpStatus.OK);
	}
	
//	@GetMapping
//	public ResponseEntity<List<User>> getUsers(){
//		return new ResponseEntity<List<User>> (userService.getUsers(),HttpStatus.OK);
//	}
	
	@GetMapping(value="/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username){
		return new ResponseEntity<User> (userService.getUser(username),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User> (userService.CreaateUser(user),HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{username}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("username") String username){
		return new ResponseEntity<User> (userService.updateUser(user,username),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
		userService.deleteUser(username);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	
}
