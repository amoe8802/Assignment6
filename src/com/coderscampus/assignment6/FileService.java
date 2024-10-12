package com.coderscampus.assignment6;

import java.io.*;
import java.util.*;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FileService {
    public List<TeslaSalesData> data (String fileName) throws IOException {
        List<TeslaSalesData> salesData = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();

            while ((line= br.readLine()) != null) {
                String[] parts = line.split(",");
                YearMonth date = YearMonth.parse(parts[0], formatter);
                int sales = Integer.parseInt(parts[1]);
                salesData.add(new TeslaSalesData(date,sales));
            }
        }
        return salesData;
    }
}