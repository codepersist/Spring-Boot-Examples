package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	 @Value("${welcome.message}")
	    private String message;
	
	
	private List<String> theTasks = Arrays.asList("a", "b", "c" , "d" , "e", "f","g");
	
	@GetMapping("/")
	private String hello(Model model)
	{
		model.addAttribute("message", message);
		model.addAttribute("tasks", theTasks);
		return "welcome"; //view
	}
	
	// /hello?name=abcd
	@GetMapping("/hello")
	private String helloWithParams(@RequestParam(name ="name" , required = false , defaultValue = "")String name , Model model)
	{
		model.addAttribute("message", name);
		return "welcome";   //view
	}
}
