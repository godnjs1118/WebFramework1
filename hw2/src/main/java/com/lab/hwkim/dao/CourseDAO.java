package com.lab.hwkim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lab.hwkim.model.Course;
import com.lab.hwkim.model.CreditPerSemester;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<CreditPerSemester> getCount() {
		String sqlStatement = "select year, semester, sum(credit) from subject group by year, semester";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<CreditPerSemester>() {
			@Override
			public CreditPerSemester mapRow(ResultSet rs, int rowNum) throws SQLException {
				CreditPerSemester credit = new CreditPerSemester();
				
				credit.setYear(rs.getInt("year"));
				credit.setSemester(rs.getInt("semester"));
				credit.setCredit(rs.getInt("sum(credit)"));
				
				return credit;
			}
		});
	}

	public List<Course> getCourseList(int year, int semester) {
		String sqlStatement = "select * from subject where year=? and semester=?";

		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setTitle(rs.getString("title"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}
		});
	}

	public boolean insert(Course course) {
		String code = course.getCode();
		String title = course.getTitle();
		String division = course.getDivision();
		int credit = course.getCredit();
		
		String sqlStatement = "insert into subject (year, semester, code, title, division, credit) values(2019, 1, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {code, title, division, credit}) == 1);
	}
}
