package com.example.monapplocation.controller;

import com.example.monapplocation.model.CommunityManager;
import com.example.monapplocation.model.Contact;
import com.example.monapplocation.model.dto.ContactDto;
import com.example.monapplocation.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/contactcreate")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact create(@RequestBody  Contact contact){
       return contactService.createContact(contact);
    }

    @GetMapping("/contactlist")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> list(){return contactService.getAllContacts();
    }

    @GetMapping("/contactread/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact getOne(@PathVariable Integer id){return contactService.getContact(id);
    }

    /*@GetMapping("/contactreadNom/{nom}")
    @ResponseStatus(HttpStatus.OK)
    public Contact getNom(@PathVariable String nom){
        return contactService.;
    }*/

    @PutMapping("/contactupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact update(@RequestBody Contact contact, @PathVariable Integer id) {
        return contactService.updateContact(contact, id);
    }

    @DeleteMapping("/contactremove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        contactService.deleteContactById(id);
    }



   /* @GetMapping("/listcontactcm")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> findByCommunityManager(CommunityManager communityManager){
        return contactService.findByCommunityManager(communityManager);
    }

    @GetMapping("/listcontactcmid")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> findByCommunityManagerIdCm(Integer id){
        return contactService.findByCommunityManagerIdCm(id);
    }*/



    @GetMapping("/pageload")
    public ResponseEntity<Page<Contact>> getPaginatedContacts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Contact> contacts = contactService.getPaginatedContacts(page, size);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }


}
