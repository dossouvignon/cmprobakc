package com.example.monapplocation.repository;

import com.example.monapplocation.model.EnvoiMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvoiMailRepository extends JpaRepository<EnvoiMail, Integer> {

}
