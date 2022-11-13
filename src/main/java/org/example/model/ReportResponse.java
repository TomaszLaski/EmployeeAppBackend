package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportResponse {
    String name;
    float numericData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNumericData() {
        return numericData;
    }

    public void setNumericData(float numericData) {
        this.numericData = numericData;
    }


    public ReportResponse() {
    }
    public ReportResponse(@JsonProperty("Employee name") String name) {
        this();
        this.setName(name);
    }
    @JsonCreator
    public ReportResponse(@JsonProperty("Employee name") String name, @JsonProperty("numeric data")float numericData) {
        this(name);
        this.setNumericData(numericData);
    }

}
