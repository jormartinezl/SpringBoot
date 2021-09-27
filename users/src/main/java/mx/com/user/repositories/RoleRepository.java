package mx.com.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.user.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
