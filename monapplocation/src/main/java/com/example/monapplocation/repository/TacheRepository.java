package com.example.monapplocation.repository;

import com.example.monapplocation.model.Publication;
import com.example.monapplocation.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TacheRepository extends JpaRepository<Tache,Integer> {
   Optional<Tache>findByNom(String nom);
    //Tache findbyNom(String nom);

    void deleteByNom(String nom);
}
