package com.example.monapplocation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reporting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomReseauSocial;
    private String typeContenu;
    private Date date_publication;
    private int nombreProspect;
    private int messageEnvoyes;
    /*@ManyToOne
    private CommunityManager communityManager;*/
}
