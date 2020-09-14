package com.springrest.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	CourseService courseService;  //this is the interface
	
	@GetMapping("/hi")
	public String  firstpage()
	{
		return "hi";
		
	}
	
	
	//To obtain data in xml format--first add jackson -dataformat-xml in pom.xml---then in header --Key=Accept and Value=application/xml 
	//we can specificy which type of output(xml/json) our method produces..as well as what type of input our method consumes
	
	@GetMapping(path="/courses",produces={"application/json","application/xml"})
	public List<Course>  findAllCourse()
	{
		return this.courseService.getCourses();
		
	}

	@GetMapping(path="/courses/{id}",produces="application/xml")  //the id variable name should be same as id variable in entity class  
	public Optional<Course> getParticularCourse(@PathVariable String id)	
	{
		//we can also use (@PathVariable("id") String id) or (@PathVariable int id)
		
		return this.courseService.getCourse(Integer.parseInt(id));
		
	}
	
	@PostMapping("/courses")
	public Course addNewCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	  
	
	@PutMapping("/courses")
	public Course editCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);		
	}
	
	@DeleteMapping("/courses/{cid}")
	public ResponseEntity<HttpStatus>  deleteExistingCourse(@PathVariable("cid") int cid)
	{
		try
		{
			this.courseService.deleteCourse(cid);
			return new ResponseEntity<>(HttpStatus.OK);
	  }
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
