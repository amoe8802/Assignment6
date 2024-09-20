package com.coderscampus.assignment6;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FileService reader = new FileService();
        List<TeslaSalesData> model3Sales = reader.data("src/com/coderscampus/model3.txt");
        List<TeslaSalesData> modelSSales = reader.data("src/com/coderscampus/modelS.txt");
        List<TeslaSalesData> modelXSales = reader.data("src/com/coderscampus/modelX.txt");

        SalesDataReportService analyzer = new SalesDataReportService();
       
        System.out.println("Model 3 Sales Report: ");
        analyzer.analyzeSales(model3Sales);

        System.out.println("\n Model S Sales Report: ");
        analyzer.analyzeSales(modelSSales);

        System.out.println("\n Model X Sales Report: ");
        analyzer.analyzeSales(modelXSales);
        }
}