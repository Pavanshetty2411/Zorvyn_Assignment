package com.assignment.zorvyn.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assignment.zorvyn.entity.FinancialRecord;
import com.assignment.zorvyn.entity.Type;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
	
	@Query("""
		    SELECT f FROM FinancialRecord f
		    WHERE (:type IS NULL OR f.type = :type)
		    AND (:category IS NULL OR f.category = :category)
		    AND (:startDate IS NULL OR f.date >= :startDate)
		    AND (:endDate IS NULL OR f.date <= :endDate)
		""")
		List<FinancialRecord> filterRecords(
		        @Param("type") Type type,
		        @Param("category") String category,
		        @Param("startDate") LocalDate startDate,
		        @Param("endDate") LocalDate endDate
		);
	
    List<FinancialRecord> findByType(Type type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByTypeAndCategory(Type type, String category);
}