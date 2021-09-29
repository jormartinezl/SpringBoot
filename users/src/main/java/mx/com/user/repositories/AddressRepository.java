package mx.com.user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.user.entity.Address;



@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

	@Query("SELECT a FROM Address a WHERE a.profile.user.id=?1 AND a.profile.id=?2 ")
	List<Address> findAddress(Integer userId, Integer profileId);
}
