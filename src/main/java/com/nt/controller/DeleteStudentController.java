package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class DeleteStudentController extends AbstractController {
	private StudentService service;

	public DeleteStudentController(StudentService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String resultMsg=null;
		ModelAndView mav=null;
		List<StudentDTO> listDTO=null;
		//use Service
		resultMsg=service.removeStudentBySno(Integer.parseInt(req.getParameter("sno")));
		listDTO=service.findAllStudents();
		//return MAV
		mav=new ModelAndView();
		mav.addObject("msg",resultMsg);
		mav.addObject("reportData",listDTO);
		mav.setViewName("report_stud");
		return mav;
	}

}
