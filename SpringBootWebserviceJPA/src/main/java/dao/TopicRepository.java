package dao;

import org.springframework.data.repository.CrudRepository;

import model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
