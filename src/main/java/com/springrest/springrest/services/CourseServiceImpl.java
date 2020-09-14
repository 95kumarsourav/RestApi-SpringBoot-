package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;



@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao  courseDao;
	
	
	
	
	public List<Course> getCourses()
	{
		return courseDao.findAll();
		
	}
	
	public Optional<Course> getCourse(int courseId)
	{
		
		
		Optional<Course> c= courseDao.findById(courseId);
		System.out.println(c);
		return c;
		
	}
	
   public Course addCourse(Course course)
        {
    	
    	courseDao.save(course);
    	return course;
    	
      }
   
     public Course updateCourse(Course course)
     {
        courseDao.save(course);
        return course;
   
   
     }
     
      public void deleteCourse(int courseId)
      {
    	Course c= courseDao.getOne(courseId);
    	courseDao.delete(c);
    	
    	  
      } 
    	  
    
     
    
    
    
    
    
    
    
    }
	
	
	


