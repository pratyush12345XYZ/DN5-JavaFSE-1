package com.cognizant.countrycrud;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.countrycrud.model.Stock;
import com.cognizant.countrycrud.repository.StockRepository;

@SpringBootApplication
public class CountryCrudApplication implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(CountryCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        testQuery1();

        testQuery2();

        testQuery3();

        testQuery4();
    }

    private void testQuery1() {

        System.out.println("\n========== Query 1 ==========");

        List<Stock> stocks =
                stockRepository.findByCodeAndDateBetween(
                        "FB",
                        LocalDate.of(2019, 9, 1),
                        LocalDate.of(2019, 9, 30));

        stocks.forEach(System.out::println);
    }

    private void testQuery2() {

        System.out.println("\n========== Query 2 ==========");

        List<Stock> stocks =
                stockRepository.findByCodeAndCloseGreaterThan(
                        "GOOGL",
                        new BigDecimal("1250"));

        stocks.forEach(System.out::println);
    }

    private void testQuery3() {

        System.out.println("\n========== Query 3 ==========");

        List<Stock> stocks =
                stockRepository.findTop3ByOrderByVolumeDesc();

        stocks.forEach(System.out::println);
    }

    private void testQuery4() {

        System.out.println("\n========== Query 4 ==========");

        List<Stock> stocks =
                stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");

        stocks.forEach(System.out::println);
    }

}