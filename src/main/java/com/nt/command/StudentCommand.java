package com.nt.command;

import lombok.Data;

@Data
public class StudentCommand {
	private int sno;
	private String sname;
	private String sadd;
	private String course="hyd";
	private String vflag="no";
	private int age;
	
	public StudentCommand() {
		System.out.println("StudentCommand::0-param constructor");
	}

}
