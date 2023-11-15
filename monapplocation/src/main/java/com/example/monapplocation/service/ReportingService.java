package com.example.monapplocation.service;

import com.example.monapplocation.model.Contact;
import com.example.monapplocation.model.Reporting;
import com.example.monapplocation.model.dto.ContactDto;
import com.example.monapplocation.model.dto.ReportingDto;
import com.example.monapplocation.repository.ReportingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportingService {

    @Autowired
    private ReportingRepository reportingRepository;
    @Autowired
    private ModelMapper modelMapper;


    public ReportingDto create(Reporting reporting){
        Reporting reportingFound = modelMapper.map(reporting,Reporting.class);
        reporting = reportingRepository.save(reporting);
        var reportingDto1 = modelMapper.map(reporting, ReportingDto.class);
        return reportingDto1;
    }

    public List<ReportingDto> listReporting() {
        // List<CommunityManager> communityManagers = new ArrayList<>();
        List<Reporting> reportings = reportingRepository.findAll();
        return reportings.stream().map(reporting -> modelMapper.map(reporting, ReportingDto.class)).collect(Collectors.toList());
    }

    public ReportingDto getOne(Integer id){
        Reporting reportingfound = reportingRepository.findById(id).get();
        if( reportingfound.equals(null)) {
            throw new RuntimeException("Le reporting n'exhiste pas");
        } else {
            var reportingfound1 = modelMapper.map( reportingfound, ReportingDto.class);
            return reportingfound1;
        }
    }

    public ReportingDto update(ReportingDto reportingDto, Integer id){
        Reporting reporting = reportingRepository.findById(id).get();
        if (reporting!= null) {
            reporting.setNomReseauSocial(reporting.getNomReseauSocial());
            reporting.setDate_publication(reporting.getDate_publication());
            reporting.setTypeContenu(reporting.getTypeContenu());
            reporting.setMessageEnvoyes(reporting.getMessageEnvoyes());
            reporting.setNombreProspect(reporting.getNombreProspect());
            modelMapper.map(reportingDto, reporting);
            reporting = reportingRepository.save(reporting);
            return modelMapper.map(reporting, ReportingDto.class);
        }
        return null;
    }


    public String remove(Integer id){
        reportingRepository.deleteById(id);
        return "Reporting supprimé";
    }

    public Page<Reporting> getPaginatedReportings(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return reportingRepository.findAll(pageable);
    }

}
