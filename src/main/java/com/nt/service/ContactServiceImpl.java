package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.command.Contact;
import com.nt.entity.ContactDetailsEntity;
import com.nt.repository.ContactDetailsRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDetailsRepository contactDtlsRepo;
    
	/**
	 * This method idicates the processing the B.Logic and 
	 * save the contact...
	 * Param Type::Contact
	 * return::: (true/false)the status for success and faliure 
	 */
	@Override
	public boolean saveContact(Contact contact) {
		ContactDetailsEntity entity=new ContactDetailsEntity();
		//converting domain object into entity...
		BeanUtils.copyProperties(contact,entity);
		entity.setStatus("y");
		//call the method..
		 ContactDetailsEntity entity1=contactDtlsRepo.save(entity);
		return entity1.getContactId()>0;
	}
    
	/**
	 * This method indicates to retrive All Contact.
	 * return::List<Contact> 
	 */
	@Override
	public List<Contact> gatAllContact() {
		List<Contact> listContact=new ArrayList<Contact>();
		List<ContactDetailsEntity> listEntity=contactDtlsRepo.findAll();
		//convert listEntity into listContact...
		for(ContactDetailsEntity entity:listEntity) {
			Contact contact=new Contact();
			//copy each entity into contact..
			if("y".equalsIgnoreCase(entity.getStatus())) {
			   BeanUtils.copyProperties(entity, contact);
			   listContact.add(contact);
			}
		}
		return listContact;
	}
    
	/**
	 * This method indicate for retriving the contact by contact Id.
	 * Param Type::Integer id
	 * return type::Contact(Means return the record.) 
	 */
	@Override
	public Contact getContactById(Integer id) {
		Contact c=null;
		Optional<ContactDetailsEntity> optional=contactDtlsRepo.findById(id);
		if(optional.isPresent()) {
			ContactDetailsEntity entity=optional.get();
			c=new Contact();
			BeanUtils.copyProperties(entity, c);
		}
		return c;
	}
    
	/**
	 * This method indicates for deleting the specific contact
	 * Param Type::Integer id
	 * return:::true,if record updated successfully....
	 */
	@Override
	public boolean deleteContactById(Integer id) {
		contactDtlsRepo.updateRecord("n", id);
	    return true;
	}
}
