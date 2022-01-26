package com.js.springmvc4;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class DAO {

	public void calc(StudentDTO s, HttpServletRequest req) {

		double avg = (s.getM() + s.getF()) / 2;
		String grade = "F";
		
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		}
		
		s.setAvg(avg);
		s.setGrade(grade);
		
		req.setAttribute("student", s);
		
	}

}
