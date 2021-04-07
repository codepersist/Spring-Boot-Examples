package resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import configuration.DbSettings;

@RestController
public class GreetingController {

	@Value("${my.greeting: This is for setting default value}")	//configuration value being picked up from application.properties.
	private String greetingMessage;
	
	@Value("Some static Value")			//Configuration example of static values
	private String staticMessage;
	
	@Value("${my.list.values}")			//Configuration example to show fetching list of values from application.properties.
	private List<String> listValues;
	
	@Value("{${dbvalues}}") //Configuration example to show fetching key-value pair of values from application.properties.
							//'#' is using SpEL (Spring Expression language)
	private Map<String,String> dbValues;
	
	@Autowired
	private DbSettings DbSetting;
	
	@GetMapping("/greeting")
	public String greeting()
	{
		//return greetingMessage + '\n' + staticMessage + '\n' + listValues + '\n' + dbValues;
		return DbSetting.getConnection() + DbSetting.getHost() + DbSetting.getPort();
	}
	
}
