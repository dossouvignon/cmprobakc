package com.example.monapplocation.model.dto;

import com.example.monapplocation.model.Statut;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TacheDto {
    private String nom;
    private String description;
    private Date date_debut;
    private Date date_fin;
    private Statut statut;
}
