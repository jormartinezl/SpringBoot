package mx.com.user.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.user.entity.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}
