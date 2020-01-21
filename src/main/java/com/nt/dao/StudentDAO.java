package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;

public interface StudentDAO {
	public  int insert(StudentBO bo);
	public List<StudentBO> getAllStudents();
	public StudentBO  getStudentBySno(int sno);
    public  int  updateStudentBySno(StudentBO bo);
    public  int deleteStudentBySno(int sno);
}
