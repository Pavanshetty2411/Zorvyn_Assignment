package com.assignment.zorvyn.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.zorvyn.entity.FinancialRecord;
import com.assignment.zorvyn.entity.Type;
import com.assignment.zorvyn.service.FinancialRecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService recordService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public List<FinancialRecord> getAllRecords() {
        return recordService.findAll();
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public FinancialRecord getAllRecords(@PathVariable long id) {
        return recordService.findById(id);
    }
    
    @GetMapping("/paged")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public Page<FinancialRecord> getRecords(
            @RequestParam int page,
            @RequestParam int size) {

        return recordService.findAll(PageRequest.of(page, size));
    }
    
    @GetMapping("/filter")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public List<FinancialRecord> filterRecords(
            @RequestParam(required = false) Type type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {

        return recordService.filterRecords(type, category, startDate, endDate);
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public FinancialRecord createRecord(@Valid @RequestBody FinancialRecord record) {
        return recordService.save(record);
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public FinancialRecord update(@PathVariable Long id,
    		@Valid @RequestBody FinancialRecord record) {

        return recordService.save(record,id);
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteRecord(@PathVariable Long id) {
        recordService.deleteById(id);
    }
    
}
