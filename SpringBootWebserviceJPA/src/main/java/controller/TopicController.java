package controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Topic;
import service.TopicService;

/**
 * @author rahul mehta
 *
 */
@RestController
@ComponentScan("service")
public class TopicController {
	
	private static Logger logger = LoggerFactory.getLogger(TopicController.class);
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		logger.debug("GET Request received for all topics.");
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		logger.debug("GET Request for topic with id: {}", id);
		return topicService.getTopic(id);
	}
	
	@PostMapping(path = "/topics", consumes = "application/json", produces ="application/json")
	public void addTopic(@RequestBody Topic topic)
	{
		logger.debug("POST Request for adding new topic");
		topicService.addTopic(topic);
	}
	
	@PutMapping(path = "/topics/{id}", consumes = "application/json")
	public void addTopic(@RequestBody Topic topic, @PathVariable String id)
	{
		logger.debug("PUT Request for updating topic with id: {}", id);
		topicService.updateTopic(id,topic);
	}
	
	@DeleteMapping(path = "/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		logger.debug("DELETE Request for deleting topic with id: {}", id);
		topicService.deleteTopic(id);
	}
}
