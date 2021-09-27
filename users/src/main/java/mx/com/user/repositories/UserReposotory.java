package mx.com.user.repositories;

import org.springframework.data.repository.CrudRepository;

import mx.com.user.entity.User;

public interface UserReposotory extends CrudRepository<User, Integer>{

}
