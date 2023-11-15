package com.example.monapplocation.controller;

import com.example.monapplocation.model.Publication;
import com.example.monapplocation.model.dto.PublicationDto;
import com.example.monapplocation.service.PublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class PublicationController {
    private PublicationService publicationService;

    @PostMapping("/publicationcreate")
    @ResponseStatus(HttpStatus.CREATED)
    public PublicationDto create(@RequestBody Publication publication) {
        return publicationService.create(publication);
    }

    @GetMapping("/publicationlist")
    @ResponseStatus(HttpStatus.OK)
    public List<PublicationDto> list() {
        return publicationService.list();
    }

    @GetMapping("/publicationread/url")
    @ResponseStatus(HttpStatus.OK)
    public PublicationDto getOne(@RequestBody String url) {
        return publicationService.getbyUrl(url);
    }

    @PutMapping("/publicationupdate/url")
    @ResponseStatus(HttpStatus.OK)
    public PublicationDto update(@RequestBody PublicationDto publicationDto, String url) {
        return publicationService.update(publicationDto, url);
    }

    @DeleteMapping("/publicationremove/url")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@RequestBody String url) {
        publicationService.remove(url);
        return true;
    }

}
