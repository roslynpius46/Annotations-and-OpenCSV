package com.bridgelabz.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "D:\\GE_BridgeLabz\\Day21_Annotations_and_OpenCSV\\src\\com\\bridgelabz\\opencsv\\sample.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH))
        ) {
            CsvToBean<CSVUser> CsvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();

            Iterator<CSVUser> csvUserIterator = CsvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name: " + csvUser.getName());
                System.out.println("Email: " + csvUser.getEmail());
                System.out.println("PhoneNo: " + csvUser.getPhoneno());
                System.out.println("Country: " + csvUser.getCountry());
            }
        }
    }
}
