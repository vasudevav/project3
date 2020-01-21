package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?)";
	private static final String GET_STUDENT_BY_SNO="SELECT SNO,SNAME,SADD,COURSE FROM STUDENT WHERE SNO=?";
	private static final String GET_ALL_STUDENT="SELECT SNO,SNAME,SADD,COURSE FROM STUDENT";
	private static final String UPDATE_STUDENT="UPDATE STUDENT SET SNAME=?,SADD=?,COURSE=? WHERE SNO=?";
	private static final String  DELETE_STUDENT="DELETE FROM STUDENT WHERE SNO=?";
	private JdbcTemplate jt;

	public StudentDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insert(StudentBO bo) {
		int count=0;
		count=jt.update(STUDENT_INSERT_QUERY, bo.getSname(),bo.getSadd(),bo.getCourse());
		return count;
	}
	
	@Override
	public List<StudentBO> getAllStudents() {
		List<StudentBO> listBO=null;
		listBO=jt.query(GET_ALL_STUDENT,rs->{
			List<StudentBO> listBO1=null;
			StudentBO bo=null;
			listBO1=new ArrayList();
			while(rs.next()) {
				bo=new StudentBO();
				bo.setSno(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setSadd(rs.getString(3));
				bo.setCourse(rs.getString(4));
				listBO1.add(bo);
			}//while
			return listBO1;
		});
		return listBO;
	}//method
	
	@Override
	public StudentBO getStudentBySno(int sno) {
		StudentBO bo=null;
		//use DAO
		bo=jt.queryForObject(GET_STUDENT_BY_SNO, (rs,index)->{
			StudentBO bo1=null;
			bo1=new StudentBO();
			bo1.setSno(rs.getInt(1));
			bo1.setSname(rs.getString(2));
			bo1.setSadd(rs.getString(3));
			bo1.setCourse(rs.getString(4));
			return bo1;
		}, sno);
		return bo;
	}//method
	
	@Override
	public int updateStudentBySno(StudentBO bo) {
		int  count=0;
		count=jt.update(UPDATE_STUDENT,bo.getSname(),bo.getSadd(),bo.getCourse(),bo.getSno());
		return count;
	}
	
	@Override
	public int deleteStudentBySno(int sno) {
		int count=0;
		count=jt.update(DELETE_STUDENT,sno);
		return count;
	}
	
}//class
