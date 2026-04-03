package com.assignment.zorvyn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.zorvyn.entity.FinancialRecord;

public interface DashboardRepository extends JpaRepository<FinancialRecord, Long> {
	
	@Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = 'INCOME'")
	Double getTotalIncome();

	@Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = 'EXPENSE'")
	Double getTotalExpense();
	
	@Query("SELECT f.category, SUM(f.amount) FROM FinancialRecord f GROUP BY f.category")
	List<Object[]> getCategorySummary();
	
	@Query("""
		    SELECT MONTH(f.date), SUM(f.amount)
		    FROM FinancialRecord f
		    GROUP BY MONTH(f.date)
		    ORDER BY MONTH(f.date)
		""")
		List<Object[]> getMonthlyTrends();
	
	List<FinancialRecord> findTop5ByOrderByDateDesc();
	

}
