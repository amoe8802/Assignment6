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

        bestAndWorstMonths(salesData);
    }


    public void bestAndWorstMonths(List<TeslaSalesData> salesData) {

        TeslaSalesData bestMonth = salesData.stream()
                .max(Comparator.comparingInt(TeslaSalesData::getSales)).orElse(null);

        TeslaSalesData worstMonth = salesData.stream()
                .min(Comparator.comparingInt(TeslaSalesData::getSales)).orElse(null);


        if (bestMonth != null) {
            System.out.println("The best month was" + bestMonth.getDate());

        }
        if (worstMonth != null) {
            System.out.println("The worst month was" + worstMonth.getDate());
        }
    }

}