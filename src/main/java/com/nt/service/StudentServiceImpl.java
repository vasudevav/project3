package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;

	public StudentServiceImpl(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public String register(StudentDTO dto) {
		int count = 0;
		StudentBO bo = null;
		// convert DTO to BO
		bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		// use DAO
		count = dao.insert(bo);
		if (count == 0)
			return "Student registration failed";
		else
			return "Student registration succeded";
	}

	@Override
	public List<StudentDTO> findAllStudents() {
		List<StudentDTO> listDTO = new ArrayList();
		List<StudentBO> listBO = null;
		// use DAO
		listBO = dao.getAllStudents();
		// convert ListBO to listDTO
		listBO.stream().forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});

		return listDTO;
	}// method

	@Override
	public StudentDTO findStudentBySno(int sno) {
		StudentBO bo = null;
		StudentDTO dto = null;
		// use DAO
		bo = dao.getStudentBySno(sno);
		// convert BO to DTO
		dto = new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	@Override
	public String modifyStudentBySno(StudentDTO dto) {
		int count=0;
		StudentBO bo=null;
		// Convert DTO to BO
		bo=new StudentBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.updateStudentBySno(bo);
		if(count==0)
			return dto.getSno()+" updatation failed";
		else
			return dto.getSno()+" updatation succeded";
	}
	
	@Override
	public String removeStudentBySno(int sno) {
		int count=0;
		//use DAO
		count=dao.deleteStudentBySno(sno);
		if(count==0)
			return "Record not found for Deletion";
		else
			return "Record  found and Deleted";
	
	}

}
