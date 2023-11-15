package com.example.monapplocation.service;

import com.example.monapplocation.model.Contact;
import com.example.monapplocation.model.Publication;
import com.example.monapplocation.model.dto.ContactDto;
import com.example.monapplocation.model.dto.PublicationDto;
import com.example.monapplocation.repository.PublicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public PublicationDto create(Publication publication) {
        Publication publicationFound = modelMapper.map(publication, Publication.class);
        publication = publicationRepository.save(publication);
        var publicationDtoFound = modelMapper.map(publication, PublicationDto.class);
        return publicationDtoFound;

    }

    public List<PublicationDto> list() {
        // List<CommunityManager> communityManagers = new ArrayList<>();
        List<Publication> publications = publicationRepository.findAll();
        return publications.stream().map(publication -> modelMapper.map(publication, PublicationDto.class)).collect(Collectors.toList());
    }

    public PublicationDto getbyUrl(String url) {
        Publication publicationFound = publicationRepository.findByUrl(url).get();
        if (publicationFound.equals(null)) {
            throw new RuntimeException("La publication n'exhiste pas");
        } else {
            var publicationFound1 = modelMapper.map(publicationFound, PublicationDto.class);
            return publicationFound1;
        }
    }

    public PublicationDto update(PublicationDto publicationDto, String url) {
        Publication publication = publicationRepository.findByUrl(url).get();
        if (publication != null) {
            publication.setLibelle(publicationDto.getUrl());
            publication.setUrl(publicationDto.getUrl());
            publication.setMedia(publicationDto.getMedia());
            publication.setDatePublication(publicationDto.getDatePublication());
            modelMapper.map(publicationDto, publication);
            publication = publicationRepository.save(publication);
            return modelMapper.map(publication, PublicationDto.class);
        } else {
            return null;
        }
    }

    public boolean remove(String url){
        publicationRepository.deleteByUrl(url);
        return true;
    }
}
