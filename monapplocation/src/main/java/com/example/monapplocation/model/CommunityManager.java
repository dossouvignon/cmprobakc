package com.example.monapplocation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "communityManager")
public class CommunityManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
   @OneToMany(mappedBy = "communityManager")
    private List<Contact>contacts;
    /*@OneToMany(mappedBy = "communityManager", fetch = FetchType.EAGER)
    private Collection<Tache> taches;
    @OneToMany(mappedBy = "communityManager", fetch = FetchType.EAGER)
    private Collection<Reporting> reportings;
    @OneToMany(mappedBy = "communityManager", fetch = FetchType.EAGER)
    private Collection<EnvoiMail> envoiMails;*/



}
