package com.example.monapplocation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {
    private String nom;
    private String prenom;
    private String email;
    private String numTelephone;
    private String adresseHabitation;
    private String preoccupation;
}
