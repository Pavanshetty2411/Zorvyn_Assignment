package com.assignment.zorvyn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.zorvyn.dto.CategorySummaryDTO;
import com.assignment.zorvyn.dto.MonthlyTrendDTO;
import com.assignment.zorvyn.entity.FinancialRecord;
import com.assignment.zorvyn.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/summary")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public Map<String, Double> getSummary() {

        return Map.of(
                "totalIncome", dashboardService.getTotalIncome(),
                "totalExpense", dashboardService.getTotalExpense(),
                "netBalance", dashboardService.getNetBalance()
        );
    }
    
    @GetMapping("/category-summary")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public List<CategorySummaryDTO> getCategorySummary() {
        return dashboardService.getCategorySummary();
    }
    
    @GetMapping("/recent")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public List<FinancialRecord> getRecentActivity() {
        return dashboardService.getRecentActivity();
    }
    
    @GetMapping("/monthly-trends")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public List<MonthlyTrendDTO> getMonthlyTrends() {
        return dashboardService.getMonthlyTrends();
    }
    
}