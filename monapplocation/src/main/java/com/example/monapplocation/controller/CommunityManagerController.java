package com.example.monapplocation.controller;

import com.example.monapplocation.model.CommunityManager;
import com.example.monapplocation.model.dto.CommunityManagerDto;
import com.example.monapplocation.service.CommunityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class CommunityManagerController {
    @Autowired
    private CommunityManagerService communityManagerService;

    @PostMapping("/createCommunityManager")
    public ResponseEntity<CommunityManager> create(@RequestBody CommunityManager communityManager) {
        return ResponseEntity.ok(communityManagerService.create(communityManager));
    }


    @GetMapping("/listCommunityManager")
    public ResponseEntity<List<CommunityManager>> listCommunityManagers() {
        return ResponseEntity.ok(communityManagerService.list());
    }

    @GetMapping("/readCommunityManager/{id}")
    public ResponseEntity<CommunityManager>getCommunityManagers(@PathVariable Integer id) {
        return ResponseEntity.ok(communityManagerService.getCommunityManager(id));
    }

    @PutMapping("/updateCommunityManager")
    public ResponseEntity<CommunityManager>updateCommunityManagers(@RequestBody CommunityManager cm) {
        return ResponseEntity.ok(communityManagerService.updateCommunityManager(cm));
    }

     @DeleteMapping("/deleteCommunityManager/{id}")
    public void delete(@PathVariable Integer id) {

        communityManagerService.deleteCommunityManagerById(id);
    }



   /* @GetMapping("/readCommunityManager/{id}")
    public ResponseEntity<CommunityManager> getOne(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(communityManagerService.getOne(id));
    }*/




   /* @PutMapping("/updateCommunityManager/{id}")
    public ResponseEntity<CommunityManager> update(@RequestBody CommunityManager communityManager, @PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(communityManagerService.update(communityManager, id));
    }*/

   /* @DeleteMapping("/deleteCommunityManager/{id}")
    public void delete(@PathVariable Integer id) {
        communityManagerService.remove(id);
    }*/

}
