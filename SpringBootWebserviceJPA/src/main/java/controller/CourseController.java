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

import model.Course;
import model.Topic;
import service.CourseService;

/**
 * @author rahul mehta
 *
 */
@RestController
@ComponentScan("service")
public class CourseController {
	
	private static Logger logger = LoggerFactory.getLogger(CourseController.class);
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		logger.debug("GET Request for all courses under topic id:  {}", id);
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id)
	{
		logger.debug("GET Request for courses under topic id:  {}", id);
		return courseService.getCourse(id);
	}
	
	@PostMapping(path = "/topics/{topicId}/courses", consumes = "application/json", produces ="application/json")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		logger.debug("POST Request for course addition under topic id:  {}", topicId);
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@PutMapping(path = "/topics/{topicId}/courses/{id}", consumes = "application/json")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id)
	{
		logger.debug("PUT Request for updating course under topic id:  {}  course id: {}", topicId, id);
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping(path = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		logger.debug("DELETE Request to delete course under topic id:  {}", id);
		courseService.deleteCourse(id);
	}
}
