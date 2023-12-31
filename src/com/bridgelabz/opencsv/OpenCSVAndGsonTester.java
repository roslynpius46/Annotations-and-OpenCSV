package com.bridgelabz.opencsv;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVAndGsonTester {
        private static final String SAMPLE_CSV_FILE_PATH = "D:\\GE_BridgeLabz\\Day21_Annotations_and_OpenCSV\\src\\com\\bridgelabz\\opencsv\\sample.csv";
        private static final String SAMPLE_JSON_FILE_PATH = "D:\\GE_BridgeLabz\\Day21_Annotations_and_OpenCSV\\src\\com\\bridgelabz\\opencsv\\sample.json";
        public static void main(String[] args) {
            try {
                    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                    CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder(reader);
                    csvToBeanBuilder.withType(CSVUser.class);
                    csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                    CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
                    List<CSVUser> csvUsers = csvToBean.parse();
                    Gson gson = new Gson();
                    String json = gson.toJson(csvUsers);
                    FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
                    writer.write(json);
                    writer.close();
                    BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
                    CSVUser[] usr0bj = gson.fromJson(br, CSVUser[].class);
                    List<CSVUser> csvUserList = Arrays.asList(usr0bj);
                } catch (IOException e) {
                    e.printStackTrace();
                }

}
}