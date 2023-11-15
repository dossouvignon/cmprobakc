package com.example.monapplocation.repository;

import com.example.monapplocation.model.CommunityManager;
import com.example.monapplocation.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityManagerRepository extends JpaRepository<CommunityManager, Integer> {
    List<CommunityManager> findByContacts(Contact contact);
}
