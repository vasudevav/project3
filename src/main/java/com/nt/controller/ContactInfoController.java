package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.command.Contact;
import com.nt.service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactService contactService;
    
	/**
	 * this method indicates the binding the form data
	 * into the Command Class Object...
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String displayContactForm(Model model) {
		System.out.println("Hi");
		Contact contact=new Contact();
		model.addAttribute("contact", contact);
		return "contact_info";
	}
	
	/**
	 * This method indicates for Saving the Contact 
	 * of Form Data.
	 * @param model
	 * @param contact
	 * @return This method redirect to the geting mode means this go to the
	 * initial load page..
	 */
	@RequestMapping(value="/saveContact",method = RequestMethod.POST)
	public String handleSubmitButton(/*Model model*/RedirectAttributes attribute,@ModelAttribute("contact") Contact contact) {
		
		boolean flag=contactService.saveContact(contact);
		if(flag) {
			attribute.addFlashAttribute("successMsg", "Contact Saved");
		}
		else {
		    attribute.addFlashAttribute("errMsg", "Contact Not Saved");
		}
		return "redirect:/";
	}
	
	/**
	 * This method indicates to mapping for getting
	 * all the Contact and calling the Service mehtod
	 * of getAllContact()....
	 * @return all the PhoneBook Contact...
	 */
	@RequestMapping(value="/getAllContact")
	public String ViewContact(Model model) {
		List<Contact> listContact=contactService.gatAllContact();
	    model.addAttribute("listContact", listContact);
		return "view_contact";
	}
}
