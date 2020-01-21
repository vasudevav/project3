package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentService {
	public String register(StudentDTO dto);
	public List<StudentDTO> findAllStudents();
	public StudentDTO  findStudentBySno(int sno);
	public  String  modifyStudentBySno(StudentDTO dto);
	public String removeStudentBySno(int sno);

}
