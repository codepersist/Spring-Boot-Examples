package application.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(value = { SpringExtension.class })
@ContextConfiguration(classes = { SpringRunner.class })
@SpringBootTest
public class SpringWebserviceJpaApplicationTests {

	
	public void contextLoads() {
	}

}
