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

public class EditStudentController extends SimpleFormController {
	private StudentService service;

	public EditStudentController(StudentService service) {

		this.service = service;
	}
	
	@Override
	public Object formBackingObject(HttpServletRequest req) throws Exception {
		int sno=0;
		StudentDTO dto=null;
		StudentCommand cmd=null;
		//read addtional req param values
		sno=Integer.parseInt(req.getParameter("sno"));
		//use serivce
		dto=service.findStudentBySno(sno);
		//Convert DTO to Command obj
		cmd=new StudentCommand();
		BeanUtils.copyProperties(dto,cmd);
		return cmd;
	}
	
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		StudentDTO dto=null;
		String result=null;
		List<StudentDTO> listDTO=null;
		ModelAndView mav=null;
		//Convert Command obj to DTO
		dto=new StudentDTO();
		BeanUtils.copyProperties(((StudentCommand)command), dto);
		//use Service
		result=service.modifyStudentBySno(dto);
		listDTO=service.findAllStudents();
		//return MAV
		mav=new ModelAndView();
		mav.setViewName("report_stud");
		mav.addObject("reportData",listDTO);
		mav.addObject("msg",result);
		return mav;
	}
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	   return new ModelAndView("dbl_post");
	}

}
