package com.lab.hwkim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.hwkim.dao.CourseDAO;
import com.lab.hwkim.model.Course;
import com.lab.hwkim.model.CreditPerSemester;

@Service
public class CourseService {
	
	@Autowired
	private CourseDAO courseDAO;

	public List<CreditPerSemester> getCount() {
		return courseDAO.getCount();
	}

	public List<Course> getCourseList(int year, int semester) {
		return courseDAO.getCourseList(year,semester);
	}

	public boolean insert(Course course) {
		return courseDAO.insert(course);
	}

}
