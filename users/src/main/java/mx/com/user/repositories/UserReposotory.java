package mx.com.user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.user.entity.User;

@Repository
public interface UserReposotory extends JpaRepository<User, Integer>{

	public Optional<User> findByUsername(String username);
}
