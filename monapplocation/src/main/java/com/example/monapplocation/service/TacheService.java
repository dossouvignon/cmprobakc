package com.example.monapplocation.service;

import com.example.monapplocation.model.Publication;
import com.example.monapplocation.model.Tache;
import com.example.monapplocation.model.dto.PublicationDto;
import com.example.monapplocation.model.dto.TacheDto;
import com.example.monapplocation.repository.PublicationRepository;
import com.example.monapplocation.repository.TacheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;
    @Autowired
    private ModelMapper modelMapper;

    public TacheDto create(Tache tache) {
        Tache tacheFound = modelMapper.map(tache, Tache.class);
        tache = tacheRepository.save(tache);
        var tacheFound1 = modelMapper.map(tache, TacheDto.class);
        return tacheFound1;

    }

    public List<TacheDto> list() {
        // List<CommunityManager> communityManagers = new ArrayList<>();
        List<Tache> taches = tacheRepository.findAll();
        return taches.stream().map(tache -> modelMapper.map(tache, TacheDto.class)).collect(Collectors.toList());
    }

    public TacheDto get(String nom) {
        Tache tacheFound = tacheRepository.findByNom(nom).get();
        if (tacheFound.equals(null)) {
            throw new RuntimeException("La tache n'exhiste pas");
        } else {
            var tacheFound1 = modelMapper.map(tacheFound, TacheDto.class);
            return tacheFound1;
        }
    }

    public TacheDto update(TacheDto tacheDto, String nom) {
        Tache tacheDtofound = tacheRepository.findByNom(nom).get();
        if (tacheDtofound != null) {
            tacheDtofound.setNom(tacheDto.getNom());
            tacheDtofound.setStatut(tacheDto.getStatut());
            tacheDtofound.setDescription(tacheDto.getDescription());
            tacheDtofound.setDate_debut(tacheDto.getDate_debut());
            tacheDtofound.setDate_fin(tacheDto.getDate_fin());

            modelMapper.map(tacheDto, tacheDtofound);
            tacheDtofound = tacheRepository.save(tacheDtofound);
            return modelMapper.map(tacheDtofound, TacheDto.class);
        } else {
            return null;
        }
    }

    public boolean remove(String nom){
        tacheRepository.deleteByNom(nom);
        return true;
    }
}
