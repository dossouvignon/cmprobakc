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
public class ReportingDto {
    private String nomReseauSocial;
    private String typeContenu;
    private Date date_publication;
    private int nombreProspect;
    private int messageEnvoyes;
}
