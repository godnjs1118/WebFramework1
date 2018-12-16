package com.lab.hwkim.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab.hwkim.model.Course;
import com.lab.hwkim.model.CreditPerSemester;
import com.lab.hwkim.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/creditcount")
	public String creditCount(Model model) {
		List<CreditPerSemester> credits = courseService.getCount();
		model.addAttribute("credits",credits);
		return "creditcount";
	}
	
	@RequestMapping("/courselist")
	public String courseList(@RequestParam(value="year") int year,
				@RequestParam(value="semester") int semester,
				Model model) {
		List<Course> courses = courseService.getCourseList(year,semester);
		model.addAttribute("courses",courses);
		return "courselist";
	}
	
	@RequestMapping("/registercourse")
	public String registerCourse(Model model) {
		model.addAttribute("course",new Course());
		return "registercourse";
	}
	
	@RequestMapping("/checkregistration")
	public String checkRegistration(Model model) {
		List<Course> courses = courseService.getCourseList(2019,1);
		model.addAttribute("courses", courses);
		return "courselist";
	}
	
	@RequestMapping("/register")
	public String doCreate(Model model, @Valid Course course, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "registercourse";
		}
		
		courseService.insert(course);
		
		return "home";
	}
}
