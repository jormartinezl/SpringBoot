package mx.com.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.user.entity.User;

public interface UserReposotory extends JpaRepository<User, Integer>{

}
