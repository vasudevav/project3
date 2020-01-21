
function validate(frm){
	//read form data
	var sname=frm.sname.value;
	var sadd=frm.sadd.value;
	var course=frm.course.value;
	//empty error messages
	document.getElementById("sname.err").innerHTML="";
	document.getElementById("sadd.err").innerHTML="";
	document.getElementById("course.err").innerHTML="";
	
	if(document.getElementById("sname.errors")!=null){
     	document.getElementById("sname.errors").innerHTML="";
	}
	
	if(document.getElementById("sadd.errors")!=null)
	   document.getElementById("sadd.errors").innerHTML="";
	
	if(document.getElementById("course.errors")!=null)
	    document.getElementById("course.errors").innerHTML="";
	

	//set vflag value "yes" indicating client side form validations are performed
	frm.vflag.value="yes";
	//perform form validations
	if(sname==""){
		document.getElementById("sname.err").innerHTML="name is required";
		frm.sname.focus();
		return false;
	}
	if(sadd==""){
		document.getElementById("sadd.err").innerHTML="sadd is required";
		frm.sadd.focus();
		return false;
	}
	else if(sadd.length<10){
		alert("45676");
		document.getElementById("sadd.err").innerHTML="sadd must have min 10 chars";
		frm.sadd.focus();
		return false;
	}
	
	if(course==""){
		document.getElementById("course.err").innerHTML="Course is required";
		frm.course.focus();
		return false;
	}
	return true;
}//function
