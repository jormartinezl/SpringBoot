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
import org.springframework.web.bind.annotation.RestController;

import mx.com.user.entity.Role;
import mx.com.user.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired 
	private RoleService roleService;
	
	@GetMapping
	public ResponseEntity<List<Role>> getRoles(){
		return new ResponseEntity<List<Role>> (roleService.getRoles(),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Role> createRole(@RequestBody Role role){
		return new ResponseEntity<Role> (roleService.createRoles(role),HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable(name = "id") Integer id){
		return new ResponseEntity<Role> (roleService.updateRole(role,id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable(name = "id") Integer id){
		roleService.deleteRole(id);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
