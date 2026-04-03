package com.assignment.zorvyn.dto;

public class MonthlyTrendDTO {

    private Integer month;
    private Double total;

    public MonthlyTrendDTO(Integer month, Double total) {
        this.month = month;
        this.total = total;
    }

    public Integer getMonth() { return month; }
    public Double getTotal() { return total; }
}