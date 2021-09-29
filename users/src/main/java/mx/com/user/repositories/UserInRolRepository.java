package mx.com.user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.user.entity.UserInRol;

@Repository
public interface UserInRolRepository extends CrudRepository<UserInRol, Integer> {

	@Query("SELECT u From UserInRol u where u.role.id=?1")
	List<UserInRol> getUserInRol(Integer roleId);

}
