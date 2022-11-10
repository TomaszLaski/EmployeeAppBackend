package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private String name;
    private String address;
    private String nationalInsuranceNo;
    private String bankAccountIBANorBic;
    private int startingSalary;
    private int employeeNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalInsuranceNo() {
        return nationalInsuranceNo;
    }

    public void setNationalInsuranceNo(String nationalInsuranceNo) {
        this.nationalInsuranceNo = nationalInsuranceNo;
    }

    public String getBankAccountIBANorBic() {
        return bankAccountIBANorBic;
    }

    public void setBankAccountIBANorBic(String bankAccountIBANorBic) {
        this.bankAccountIBANorBic = bankAccountIBANorBic;
    }

    public int getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(int startingSalary) {
        this.startingSalary = startingSalary;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Employee() {

    }


    public Employee(@JsonProperty("name") String name) {
        this();
        this.setName(name);
    }


    public Employee(@JsonProperty("name") String name, @JsonProperty("address") String address) {
        this(name);
        this.setAddress(address);
    }


    public Employee(@JsonProperty("name") String name, @JsonProperty("address") String address, @JsonProperty("national insurance") String nationalInsuranceNo) {
        this(name, address);
        this.setNationalInsuranceNo(nationalInsuranceNo);
    }


    public Employee(@JsonProperty("name") String name, @JsonProperty("address") String address, @JsonProperty("national insurance") String nationalInsuranceNo, @JsonProperty("Bank Account IBAN/BIC") String bankAccountIBANorBic) {
        this(name, address, nationalInsuranceNo);
        this.setBankAccountIBANorBic(bankAccountIBANorBic);
    }


    public Employee( @JsonProperty("name") String name, @JsonProperty("address") String address, @JsonProperty("national insurance") String nationalInsuranceNo, @JsonProperty("Bank Account IBAN/BIC") String bankAccountIBANorBic, @JsonProperty("Starting salary") int startingSalary) {
        this(name, address, nationalInsuranceNo, bankAccountIBANorBic);
        this.setStartingSalary(startingSalary);
    }

    @JsonCreator
    public Employee(@JsonProperty("name") String name, @JsonProperty("address") String address, @JsonProperty("national insurance") String nationalInsuranceNo, @JsonProperty("Bank Account IBAN/BIC") String bankAccountIBANorBic, @JsonProperty("Starting salary") int startingSalary, @JsonProperty("Employee number") int employeeNumber) {
        this(name, address, nationalInsuranceNo, bankAccountIBANorBic, startingSalary);
        this.setEmployeeNumber(employeeNumber);
    }
}

