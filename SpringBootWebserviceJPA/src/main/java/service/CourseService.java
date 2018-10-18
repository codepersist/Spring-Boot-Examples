package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CourseRepository;
import model.Course;

/**
 * @author rahul mehta
 *
 */
@Service
public class CourseService {

	private static Logger logger = LoggerFactory.getLogger(CourseService.class);
	@Autowired
	private CourseRepository courseRepository;
	
	/**
	 * Get all the Courses from database.
	 * 
	 * @return the list of courses
	 */
	public List<Course> getAllCourses(String id)
	{
		logger.info("Request received for all courses. Making a database call..");
		List<Course> courseList = new ArrayList<>();
		courseRepository.findAll().forEach(courseList::add);
		return courseList;
	}

	public Course getCourse(String id) 
	{
		logger.info("Request received to get specific course. Making a database call..");
		Optional<Course> thecourse = courseRepository.findById(id);
		if(thecourse.isPresent())
		{
		return thecourse.get();
		}
		else
			return null;
	}

	public void addCourse(Course course) {
		logger.info("Request received to add course. Making a insert database call..");
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		logger.info("Request received to update course. Making a update database call..");
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		logger.info("Request received to delete course. Making a delete database call..");
		courseRepository.deleteById(id);
	}
}
