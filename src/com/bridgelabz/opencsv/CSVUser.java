package com.bridgelabz.opencsv;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {

    @CsvBindByName private String name;
    @CsvBindByName(column = "email", required = true) private String email;
    @CsvBindByName(column = "phone") private String phoneNo;
    @CsvBindByName
    private String country;

    @Override
    public String toString() {
        return "CSVUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    // Default constructor (required by OpenCSV)
    public CSVUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    // Getters and setters for each field
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneno() {
        return phoneNo;
    }

    public String getCountry() {
        return country;
    }

}
