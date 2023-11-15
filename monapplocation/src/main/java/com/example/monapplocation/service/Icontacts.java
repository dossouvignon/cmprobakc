package com.example.monapplocation.service;

import com.example.monapplocation.model.CommunityManager;
import com.example.monapplocation.model.Contact;

import java.util.List;

public interface Icontacts {

    Contact createContact(Contact c);
    Contact updateContact(Contact c, Integer id);
    /*void deleteContact(Contact c);*/
    void deleteContactById(Integer id);
    Contact getContact(Integer id);
    List<Contact> getAllContacts();
    /* List<Contact> findByNomContact(String nom);
    List<Contact> findByCommunityManager (CommunityManager communityManager);
    List<Contact> findByCommunityManagerIdCm(Integer id);*/
}
