package mx.com.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

/**
 * 
 * @author jorgemartinez
 * clase configuracion faker para la generacion de datos aleatorios
 */
@Configuration
public class FakerBeanConfig {

	@Bean
	Faker getFaker() {
		return new Faker();
	}
}
