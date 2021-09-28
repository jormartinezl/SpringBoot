package mx.com.user.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.user.entity.Addreres;

@Repository
public interface AddressRepository extends CrudRepository<Addreres, Integer>{

}
