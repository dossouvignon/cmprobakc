package com.example.monapplocation.repository;

import com.example.monapplocation.model.Reporting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportingRepository extends JpaRepository<Reporting,Integer> {
}
