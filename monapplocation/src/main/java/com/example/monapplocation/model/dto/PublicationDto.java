package com.example.monapplocation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicationDto {
    private String libelle;
    private String media;
    private Date datePublication;
    private String heure;
    private String url;
    private Integer commentaire;
    private Integer partage;
    private Integer jaime;
}
