package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TopicRepository;
import model.Topic;

/**
 * @author rahul mehta
 *
 */
@Service
public class TopicService {

	private static Logger logger = LoggerFactory.getLogger(TopicService.class);
	@Autowired
	private TopicRepository topicRepository;
	
	/**
	 * Get all the topics from database.
	 * 
	 * @return the list of Topics
	 */
	public List<Topic> getAllTopics()
	{
		logger.info("Request received for all topics. Making a database call..");
		List<Topic> topicsList = new ArrayList<>();
		topicRepository.findAll().forEach(topicsList::add);
		return topicsList;
	}

	public Topic getTopic(String id) {
		logger.info("Request received to get specific topic. Making a database call..");
		Optional<Topic> theTopic = topicRepository.findById(id);
		if(theTopic.isPresent())
		{
		return theTopic.get();
		}
		else
			return null;
	}

	public void addTopic(Topic topic) {
		logger.info("Request received to add topic. Making a insert database call..");
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		logger.info("Request received to update topic. Making a update database call..");
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		logger.info("Request received to delete topic. Making a delete database call..");
		topicRepository.deleteById(id);
	}
}
