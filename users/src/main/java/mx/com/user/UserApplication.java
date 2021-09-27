package mx.com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;

import mx.com.user.entity.User;
import mx.com.user.repositories.UserReposotory;

@SpringBootApplication
public class UserApplication {
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	

}
