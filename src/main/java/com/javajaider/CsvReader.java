package com.javajaider;

import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {

    public static List<String> readFrom(String fileName) throws FileNotFoundException {
        InputStream inputStream = getFileCsv(fileName);
        return csvFileToList(inputStream);
    }

    private static InputStream getFileCsv(String fileName) {
        return CsvReader.class.getClassLoader().getResourceAsStream(fileName);
    }

    private static List<String> csvFileToList(InputStream inputStream) throws FileNotFoundException {
        List<String> csvRowList = new ArrayList<>();
        try (Scanner fileReader = new Scanner(inputStream)) {
            while (fileReader.hasNextLine()) {
                String row = fileReader.nextLine();
                csvRowList.add(row);
            }
        }
        return csvRowList;
    }
}
