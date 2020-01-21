package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.StudentCommand;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("StudentRegistrationValidator.supports(-)");
		//return clazz==StudentCommand.class;
		return clazz.isAssignableFrom(StudentCommand.class);

		
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		System.out.println("StudentRegistrationValidator.validate(-,-)");
		StudentCommand command=null;
		//type casting
		command=(StudentCommand)cmd;
		if(command.getVflag().equalsIgnoreCase("no")) {
			System.out.println("server side form validations are taking place");
		if(command.getSname()==null ||command.getSname().length()==0 || command.getSname().equals(""))
			errors.rejectValue("sname","sname.required");
		
		if(command.getSadd()==null || command.getSadd().equals("") ||command.getSadd().length()==0)
			errors.rejectValue("sadd","addrs.required");
		else if(command.getSadd().length()<10)
			errors.rejectValue("sadd","addrs.minlength");
		
		if(command.getCourse()==null || command.getCourse().equals("") ||command.getCourse().length()==0)
			errors.rejectValue("course","course.required");
		}
		
	}

}
