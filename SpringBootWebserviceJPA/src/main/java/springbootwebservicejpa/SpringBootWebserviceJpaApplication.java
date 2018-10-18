package springbootwebservicejpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author rahul mehta
 *
 */
@Configuration
@ComponentScan({"controller","service"})
@EnableAutoConfiguration
@EntityScan({"model"})
@EnableJpaRepositories("dao")
public class SpringBootWebserviceJpaApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootWebserviceJpaApplication.class);
	public static void main(String[] args) {
		logger.info("Application started: ------------");
		SpringApplication.run(SpringBootWebserviceJpaApplication.class, args);
	}
}
