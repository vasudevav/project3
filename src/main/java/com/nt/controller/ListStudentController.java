package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class ListStudentController extends AbstractController {
	private StudentService service;
	

	public ListStudentController(StudentService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<StudentDTO> listDTO=null;
		//use Servic
		listDTO=service.findAllStudents();
		//return MAV
		return new ModelAndView("report_stud","reportData",listDTO);
	}

}
