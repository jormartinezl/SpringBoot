package mx.com.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

import mx.com.user.entity.User;
import mx.com.user.repositories.UserReposotory;

/*
 * Clase ApplicationRunner para el autollenado de usuarios al levantar la aplicacion
 */
@Configuration
public class UsuariosApplicationRunner implements ApplicationRunner{

	@Autowired
	private Faker faker;
	
	@Autowired
	private UserReposotory userRepository;
	
	public void run(ApplicationArguments args) {
		for (int i=0;i<50;i++) {
			User user = new User();
			user.setPassword(faker.dragonBall().character());
			user.setUsername(faker.name().username());
			userRepository.save(user);
		}
	}
}
