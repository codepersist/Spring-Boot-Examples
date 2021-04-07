package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rahul mehta
 *
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Changed the packaging to war file.";
	}
}
