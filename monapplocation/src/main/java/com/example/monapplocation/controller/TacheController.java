package com.example.monapplocation.controller;

import com.example.monapplocation.model.Tache;
import com.example.monapplocation.model.dto.TacheDto;
import com.example.monapplocation.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class TacheController {
    @Autowired
    private TacheService tacheService;

    @GetMapping("/listTache")
    public ResponseEntity<List<TacheDto>> listTache() {
        return ResponseEntity.ok(tacheService.list());
    }

    @GetMapping("/readOne/nom")
    public ResponseEntity<TacheDto> getOne(@RequestBody String nom) {
        return ResponseEntity.ok(tacheService.get(nom));
    }


    @PostMapping("/createTache")
    public ResponseEntity<TacheDto> create(@RequestBody Tache tache) {
        return ResponseEntity.ok(tacheService.create(tache));
    }


    @PutMapping("/updateTache/nom")
    public ResponseEntity<TacheDto> update(@RequestBody TacheDto tacheDto, @ModelAttribute String nom) {
        return ResponseEntity.ok(tacheService.update(tacheDto,nom));
    }

    @DeleteMapping("/deleteTache/nom")
    public void delete(@ModelAttribute String nom) {
        tacheService.remove(nom);
    }

}

