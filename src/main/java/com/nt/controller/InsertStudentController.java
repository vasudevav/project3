package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class InsertStudentController extends SimpleFormController {
	

	private StudentService service;
	
	public InsertStudentController(StudentService service) {
		this.service = service;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		String resultMsg=null;
		StudentCommand cmd=null;
		StudentDTO dto=null;
		ModelAndView mav=null;
		List<StudentDTO> listDTO=null;
		//convert cmd to DTO
		cmd=(StudentCommand)command;
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use Service
		resultMsg=service.register(dto);
		listDTO=service.findAllStudents();
		//return MAV
		mav=new ModelAndView();
		mav.addObject("msg",resultMsg);
		mav.addObject("reportData",listDTO);
		mav.setViewName("report_stud");
		return mav;
	}//method
	
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	  return new ModelAndView("dbl_post");
	}
	
}//class
