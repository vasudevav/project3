package com.nt.service;

import java.util.List;

import com.nt.command.Contact;

public interface ContactService {
    public boolean saveContact(Contact contact);
    public List<Contact> gatAllContact();
    public Contact getContactById(Integer id);
    public boolean deleteContactById(Integer id);
    
}
