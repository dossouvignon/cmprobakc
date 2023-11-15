package com.example.monapplocation.service;

import com.example.monapplocation.model.CommunityManager;
import com.example.monapplocation.model.Contact;
import com.example.monapplocation.model.dto.ContactDto;
import com.example.monapplocation.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements Icontacts {
   @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact c) {
        return contactRepository.save(c);
    }

    @Override
    public Contact updateContact(Contact c, Integer id) {
        Contact contactFound = contactRepository.findById(id).get();
        if(contactFound !=null) {
            contactFound.setNom(c.getNom());
            contactFound.setPrenom(c.getPrenom());
            contactFound.setEmail(c.getEmail());
            contactFound.setNumTelephone(c.getNumTelephone());
            contactFound.setAdresseHabitation(c.getAdresseHabitation());
            contactFound.setPreoccupation(c.getPreoccupation());
            return  contactRepository.save(contactFound);
        } else {
        return null;

    }
    }

    /*@Override
    public void deleteContact(Contact c) {
        contactRepository.delete(c);

    }*/

    @Override
    public void deleteContactById(Integer id) {
        contactRepository.deleteById(id);

    }

    @Override
    public Contact getContact(Integer id) {
       return contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

   /* @Override
    public List<Contact> findByNomContact(String nom) {
        return contactRepository.findByNomContact(nom);
    }

    @Override
    public List<Contact> findByCommunityManager(CommunityManager communityManager) {
        return contactRepository.findByCommunityManager(communityManager);
    }

    @Override
    public List<Contact> findByCommunityManagerIdCm(Integer id) {
        return contactRepository.findByCommunityManagerId(id);
    }*/

    public Page<Contact> getPaginatedContacts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return contactRepository.findAll(pageable);
    }

}


