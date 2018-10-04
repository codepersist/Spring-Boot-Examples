package springbootrestwebservice;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author rahul mehta
 *
 */
@ComponentScan({"controller"})
@SpringBootApplication
public class SpringBootRestWebServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootRestWebServiceApplication.class);
	public static void main(String[] args) {
		logger.info("Application started: ------------");
		SpringApplication.run(SpringBootRestWebServiceApplication.class, args);
	}
	
	/* Command line runners are a useful functionality to execute the various types of code that 
	   only have to be run once, right after application startup. */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx)
	{
		logger.info("CommandLineRunner invoked: -----------");
		return args ->{
			System.out.println("Let's list the beans provided by Spring Boot: ");
			String [] beanNames = ctx.getBeanDefinitionNames();
			
			Arrays.sort(beanNames);
			Arrays.asList(beanNames).forEach(System.out::println);
		};
	}
}
