package com.example.monapplocation.service;

import com.example.monapplocation.model.EnvoiMail;

import java.util.List;

public interface EnvoiMailInter {

    void sendEmail(String from, String to, String subject, String message);
    EnvoiMail updateMail(int id, EnvoiMail envoiMail);

    EnvoiMail getOne(int id);

    void deleteMail(int id);

    List<EnvoiMail>listMails();
}
