package mx.com.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())//se documenta informacion contacto e informacion de la api
				//.select().apis(RequestHandlerSelectors.any())//linea para exponer todo
				.select().apis(RequestHandlerSelectors.basePackage("mx.com.user.controller"))//linea para exponer solo lo que se ecuentra en el paquete			
				.paths(PathSelectors.any())//expone todos los paths
				//.paths(PathSelectors.ant("/users/*"))//expone solo los path que cumplen
				.build()
				//.useDefaultResponseMessages(false)//quita los codigos posibles que estan por default y deja solo los definidos
				;
		//uri para visualizar documenatacion http://localhost:8080/swagger-ui.html#/
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Titulo prueba")
				.version("1.0")
				.license("Apache 2.0")
				.contact(new Contact(null, null, "jorgeantonio.martinezlopez@gmail.com"))
				.build();
	}
}
