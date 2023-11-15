package com.example.monapplocation.repository;

import com.example.monapplocation.model.CommunityManager;
import com.example.monapplocation.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    /*Optional<Contact> findByNom(String nom);

    List<Contact> findByNomContact(String nom);

    @Query("select c from Contact c where c.communityManager = ?1")
    List<Contact> findByCommunityManager(CommunityManager communityManager);

    List<Contact> findByCommunityManagerId(Integer id);*/
}
