package com.coderscampus.assignment6;

import java.util.*;
import java.util.stream.Collectors;

public class SalesDataReportService {

    public void analyzeSales (List<TeslaSalesData> salesData){
        Map<Integer, Integer> yearlySales = salesData.stream()
                .collect(Collectors.groupingBy(sale -> sale.getDate().getYear(),
                        Collectors.summingInt(TeslaSalesData::getSales)));
        System.out.println("Yearly Sales Report: ");
        yearlySales.forEach((year, sales) -> System.out.println(year + "->" + sales));

        highAndLowMonths(salesData);
    }


    public void highAndLowMonths(List<TeslaSalesData> salesData) {

        TeslaSalesData highMonth = salesData.stream()
                .max(Comparator.comparingInt(TeslaSalesData::getSales)).orElse(null);

        TeslaSalesData lowMonth = salesData.stream()
                .min(Comparator.comparingInt(TeslaSalesData::getSales)).orElse(null);


        if (highMonth != null) {
            System.out.println("The highest month " + highMonth.getDate());

        }
        if (lowMonth != null) {
            System.out.println("The lowest month was " + lowMonth.getDate());
        }
    }

}