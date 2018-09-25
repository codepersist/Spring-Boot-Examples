package springbootrestwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author rahulmehta
 *
 */
@ComponentScan({"controller"})
@SpringBootApplication
public class SpringBootRestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestWebServiceApplication.class, args);
	}
}
