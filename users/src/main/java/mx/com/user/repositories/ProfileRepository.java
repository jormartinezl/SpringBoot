package mx.com.user.repositories;

import org.springframework.data.repository.CrudRepository;

import mx.com.user.entity.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}
