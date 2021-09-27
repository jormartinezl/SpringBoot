package mx.com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.com.user.entity.Role;
import mx.com.user.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}
	public Role createRoles(Role role){
		return roleRepository.save(role);
	}
	public void deleteRole(Integer id){
		Optional<Role> result =roleRepository.findById(id);
		if(result.isPresent()) {
			roleRepository.deleteById(id);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Role id %d doesn´t exist", id));
		}
	}
	public Role updateRole(Role role,Integer id){
		Optional<Role> result =roleRepository.findById(id);
		if(result.isPresent()) {
			return roleRepository.save(role);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Role id %d doesn´t exist", id));
		}
		
	}
}
