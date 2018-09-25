package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rahulmehta
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "Welcome!! to SpringBootRestfulWebService tutorial.Let's get started..";
	}
}
