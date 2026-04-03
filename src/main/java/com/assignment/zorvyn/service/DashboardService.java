package com.assignment.zorvyn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.zorvyn.dto.CategorySummaryDTO;
import com.assignment.zorvyn.dto.MonthlyTrendDTO;
import com.assignment.zorvyn.entity.FinancialRecord;
import com.assignment.zorvyn.repository.DashboardRepository;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public Double getTotalIncome() {
        return dashboardRepository.getTotalIncome();
    }

    public Double getTotalExpense() {
        return dashboardRepository.getTotalExpense();
    }

    public Double getNetBalance() {
        Double income = getTotalIncome();
        Double expense = getTotalExpense();

        if (income == null) income = 0.0;
        if (expense == null) expense = 0.0;

        return income - expense;
    }
    
    public List<CategorySummaryDTO> getCategorySummary() {

        return dashboardRepository.getCategorySummary()
                .stream()
                .map(obj -> new CategorySummaryDTO(
                        (String) obj[0],
                        (Double) obj[1]
                ))
                .collect(Collectors.toList());
    }
    
    public List<FinancialRecord> getRecentActivity() {
        return dashboardRepository.findTop5ByOrderByDateDesc();
    }
    
    public List<MonthlyTrendDTO> getMonthlyTrends() {

        return dashboardRepository.getMonthlyTrends()
                .stream()
                .map(obj -> new MonthlyTrendDTO(
                        (Integer) obj[0],
                        (Double) obj[1]
                ))
                .toList();
    }
}