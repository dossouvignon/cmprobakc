package com.example.monapplocation.controller;

import com.example.monapplocation.model.Contact;
import com.example.monapplocation.model.Reporting;
import com.example.monapplocation.model.dto.ContactDto;
import com.example.monapplocation.model.dto.ReportingDto;
import com.example.monapplocation.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")

public class ReportingController {

    @Autowired
    private ReportingService reportingService;

    @PostMapping("/reportingcreate")
    @ResponseStatus(HttpStatus.CREATED)
    public ReportingDto create(@RequestBody Reporting reporting){
        return reportingService.create(reporting);
    }


    @GetMapping("/reportinglist")
    @ResponseStatus(HttpStatus.OK)
    public List<ReportingDto> list(){
        return reportingService.listReporting();
    }


    @GetMapping("/reportingread/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportingDto getOne(@PathVariable Integer id){
        return reportingService.getOne(id);
    }


    @PutMapping("/reportingupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportingDto update(@RequestBody ReportingDto reportingDto, @PathVariable Integer id){
        return reportingService.update(reportingDto, id);
    }


    @DeleteMapping("/reportingremove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Integer id){
        reportingService.remove(id);
        return "Reporting supprimé";
    }


    @GetMapping("/pageloading")
    public ResponseEntity<Page<Reporting>> getPaginatedReportings(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Reporting> reportings = reportingService.getPaginatedReportings(page, size);
        return new ResponseEntity<>(reportings, HttpStatus.OK);
    }




}
