package com.example.monapplocation.controller;

import com.example.monapplocation.model.EnvoiMail;
import com.example.monapplocation.model.dto.TacheDto;
import com.example.monapplocation.service.EnvoiMailService;
import jakarta.validation.constraints.Email;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class EnvoiMailController {
    private final EnvoiMailService envoiMailService;

    public EnvoiMailController(EnvoiMailService envoiMailService) {

        this.envoiMailService = envoiMailService;
    }

    @PostMapping("/send-email")
    public ResponseEntity envoimail(@RequestBody EnvoiMail envoiMail){
        this.envoiMailService.sendEmail(envoiMail.getMailer(), envoiMail.getReceiver(), envoiMail.getSubject(), envoiMail.getMessage());
       return ResponseEntity.ok("Success Message send");
    }


    @PutMapping("/mail/{id}")
    public ResponseEntity<EnvoiMail> updateMail(@PathVariable("id") int id, @RequestBody EnvoiMail envoiMail) {
        return ResponseEntity.ok(envoiMailService.updateMail(id,envoiMail));
    }

    @GetMapping("/list")
    public ResponseEntity<List<EnvoiMail>> listCommunityManagers() {
        return ResponseEntity.ok(envoiMailService.listMails());
    }

    @GetMapping("/mail/{id}")
    public ResponseEntity<EnvoiMail> getOne(@PathVariable("id") int id) {
        return ResponseEntity.ok(envoiMailService.getOne(id));
    }

    @DeleteMapping("/deleteMail/id")
    public void delete(@PathVariable("id") int id) {
        envoiMailService.deleteMail(id);
    }

}
