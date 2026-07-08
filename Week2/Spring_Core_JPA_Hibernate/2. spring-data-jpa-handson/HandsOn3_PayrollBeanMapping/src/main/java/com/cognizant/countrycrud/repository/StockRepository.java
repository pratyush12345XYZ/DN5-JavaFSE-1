package com.cognizant.countrycrud.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.countrycrud.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Query 1
    List<Stock> findByCodeAndDateBetween(
            String code,
            LocalDate startDate,
            LocalDate endDate);

    // Query 2
    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            BigDecimal close);

    // Query 3
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Query 4
    List<Stock> findTop3ByCodeOrderByCloseAsc(
            String code);

}