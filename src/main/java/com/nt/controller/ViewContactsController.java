package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.Contact;
import com.nt.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService contactService;
    
	/**
	 * this method indicates that getting the contact by the id
	 * for the editing purpose..
	 * @param req
	 * @param model
	 * @return one record based on the id
	 */
	@RequestMapping(value="/editContact")
	public String editContact(HttpServletRequest req,Model model) {
		Integer id=Integer.parseInt(req.getParameter("contactId"));
		if(id!=null&&id!=0) {
	         Contact contact=contactService.getContactById(id);
	         model.addAttribute("contact",contact);
		}
		return "contact_info";
	}	
	/**
	 * this method indicates that removing the contact...
	 * @param req
	 * @param model
	 * @return after performing deletion this method redirect to the
	 *        getting latest PhoneBoook Record... 
	 */
	@RequestMapping(value="/deleteContact")
	public String deleteContact(HttpServletRequest req,Model model) {
		Integer id=Integer.parseInt(req.getParameter("contactId"));
		boolean flag=contactService.deleteContactById(id);
		if(flag) {
			model.addAttribute("delete","Deleted Successfull");
		}
		else {
			model.addAttribute("delete","Delation failed");
		}
		return "redirect:/getAllContact";
	}
}
