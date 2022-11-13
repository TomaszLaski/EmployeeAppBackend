package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployee {
    private int employeeNumber;
    private float commissionRate;
    private float totalSalesValue;

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public float getTotalSalesValue() {
        return totalSalesValue;
    }

    public void setTotalSalesValue(float totalSalesValue) {
        this.totalSalesValue = totalSalesValue;
    }


    public SalesEmployee() {
    }
    public SalesEmployee(@JsonProperty("Employee number") int employeeNumber) {
        this();
        this.setEmployeeNumber(employeeNumber);
    }
    public SalesEmployee(@JsonProperty("Employee number") int employeeNumber, @JsonProperty("Commission rate")float commissionRate) {
        this(employeeNumber);
        this.setCommissionRate(commissionRate);
    }
    @JsonCreator
    public SalesEmployee(@JsonProperty("Employee number") int employeeNumber, @JsonProperty("Commission rate") float commissionRate, @JsonProperty("Total sales value") float totalSalesValue) {
        this(employeeNumber, commissionRate);
        this.setTotalSalesValue(totalSalesValue);
    }


}
