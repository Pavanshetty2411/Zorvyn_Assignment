package com.assignment.zorvyn.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.assignment.zorvyn.entity.FinancialRecord;
import com.assignment.zorvyn.entity.Type;
import com.assignment.zorvyn.entity.User;
import com.assignment.zorvyn.repository.FinancialRecordRepository;
import com.assignment.zorvyn.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class FinancialRecordService {
	
	@Autowired
	private FinancialRecordRepository financialrepo;
	private UserRepository userrepo;
	public List<FinancialRecord> findAll() {
		return financialrepo.findAll();
	}

	public Page<FinancialRecord> findAll(PageRequest of) {
		return financialrepo.findAll(of);
	}

	public @Valid User save(@Valid User user) {
		return userrepo.save(user);
	}

	public void deleteById(Long id) {
		financialrepo.deleteById(id);
	}

	public FinancialRecord save(FinancialRecord record, Long id) {
		record.setId(id);
		return financialrepo.save(record);
	}

	public FinancialRecord save(@Valid FinancialRecord record) {
		return financialrepo.save(record);
	}
	
	public List<FinancialRecord> filterRecords(Type type, String category, LocalDate startDate, LocalDate endDate) {

		return financialrepo.filterRecords(type, category, startDate, endDate);
	}

	public FinancialRecord findById(long id) {
	    return financialrepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Record not found"));
	}

}
