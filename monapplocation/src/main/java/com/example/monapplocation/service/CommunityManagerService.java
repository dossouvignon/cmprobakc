package com.example.monapplocation.service;

import com.example.monapplocation.model.CommunityManager;
import com.example.monapplocation.model.Contact;
import com.example.monapplocation.model.dto.CommunityManagerDto;
import com.example.monapplocation.repository.CommunityManagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommunityManagerService {
    @Autowired
    private CommunityManagerRepository communityManagerRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CommunityManager create(CommunityManager communityManager) {
       return communityManagerRepository.save(communityManager);
        }


    public List<CommunityManager> list() {
        return communityManagerRepository.findAll();
    }


    public CommunityManager updateCommunityManager(CommunityManager cm) { return communityManagerRepository.save(cm);
    }

    public void deleteCommunityManagerById(Integer id) {
      communityManagerRepository.deleteById(id);
    }

    public CommunityManager getCommunityManager(Integer id) { return communityManagerRepository.findById(id).get();
    }

   /* public CommunityManager getOne(Integer id) throws Exception {
        CommunityManager communityManagerFound = communityManagerRepository.findById(id).get();
        if (communityManagerFound.equals(null)){
            throw new Exception(String.format("communityManager with id %s not found!" + id));
        }
        return this.communityManagerRepository.findById(id).get();
    }

    /*public CommunityManager update(CommunityManager communityManager, Integer id) throws Exception {
        CommunityManager communityManagerFound = communityManagerRepository.findById(id).get();
        if (communityManagerFound.equals(null)){
            throw new Exception(String.format("communityManager with id %s not found!" + id));
        }
        communityManagerFound.setPrenom(communityManagerFound.getPrenom());
        communityManagerFound.setNom(communityManagerFound.getNom());
        communityManagerFound.setEmail(communityManagerFound.getEmail());
        communityManagerFound.setPassword(communityManagerFound.getEmail());
        return communityManagerRepository.save(communityManagerFound);
    }*/

   /* public CommunityManager update(CommunityManager communityManager, Integer id) throws Exception {
        Optional<CommunityManager> communityManagerFound = communityManagerRepository.findById(id);
        if (communityManagerFound.isPresent()){
           CommunityManager communityManager1 = communityManagerFound.get();
           communityManager1.setNom(communityManager1.getNom());
           communityManager1.setPrenom(communityManager1.getPrenom());
           return communityManagerRepository.save(communityManager1);
        }
      else {

            throw new Exception(String.format("communityManager with id %s not found!" + id));
        }
    }



    public void remove(Integer id){
        communityManagerRepository.deleteById(id);
    }*/
}