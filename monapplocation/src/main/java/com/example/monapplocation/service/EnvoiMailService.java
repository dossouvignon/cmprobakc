package com.example.monapplocation.service;

import com.example.monapplocation.model.EnvoiMail;
import com.example.monapplocation.repository.EnvoiMailRepository;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvoiMailService implements EnvoiMailInter {

    private EnvoiMailRepository envoiMailRepository;
   private final JavaMailSender javaMailSender; // Envoi de messages a pluiseurs personnes

    public EnvoiMailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String from, String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        this.javaMailSender.send(simpleMailMessage);

    }

    @Override
    public EnvoiMail updateMail(int id, EnvoiMail envoiMail) {

            // Retrieve the existing mail by its ID or any other unique identifier
        EnvoiMail existingMail = envoiMailRepository.getReferenceById(envoiMail.getId());
        if(!existingMail.equals(null)){

            // Update the fields as needed
            existingMail.setReceiver(envoiMail.getReceiver());
            existingMail.setMailer(envoiMail.getMailer());
            existingMail.setSubject(envoiMail.getSubject());
            existingMail.setMessage(envoiMail.getMessage());

            return envoiMailRepository.save(existingMail);
        }

        else {
             throw new RuntimeException("Le mail n'existe pas.");
        }

    }

    @Override
    public EnvoiMail getOne(int id) {

        EnvoiMail existingMail = envoiMailRepository.getReferenceById(id);
        if(!existingMail.equals(null)){
            return this.envoiMailRepository.findById(id).get();
        }
        else {
            throw new RuntimeException("Le mail n'existe pas.");
        }
    }

    @Override
    public void deleteMail(int id) {
        EnvoiMail existingMail = envoiMailRepository.getReferenceById(id);
        this.envoiMailRepository.deleteById(id);
    }

    @Override
    public List<EnvoiMail> listMails() {
        return this.envoiMailRepository.findAll();
    }




     /*public void envoiMail(String from, String to, String subject, String text){

         SimpleMailMessage message = new SimpleMailMessage();
         //FileSystemResource file = new FileSystemResource(new File("attachment.jpg"));
         message.setFrom(from);
         message.setTo(new String[] {"recipient1@example.com", "recipient2@example.com", "recipient3@example.com"});
         message.setSubject(subject);
         message.setText(text);
        javaMailSender.send(message);

     }

      //Send message with attachment
    public String sendEmailWithAttachment(String to, String subject, String body) throws MessagingException, IOException {

        MimeMessage messageA = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(messageA, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        FileSystemResource file = new FileSystemResource(new File("attachment.jpg"));
        helper.addAttachment("attachment.jpg", file);

        javaMailSender.send(messageA);

        return "Success";
    }*/

}
