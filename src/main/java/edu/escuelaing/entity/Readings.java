package edu.escuelaing.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "readings")
public class Readings {
    @Id
    private String id;
    private String username;
    private String techAddress;
    private double previousReading;
    private double currentReading;
    private int internalCode;
    private double consumption;
    private String counterNumber;
    private String month;
    private int year;

    public Readings() {
    }

    public Readings(String username, String techAddress, double previousReading, double currentReading,
                   int internalCode, double consumption, String counterNumber, String month, int year) {
        this.username = username;
        this.techAddress = techAddress;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.internalCode = internalCode;
        this.consumption = consumption;
        this.counterNumber = counterNumber;
        this.month = month;
        this.year = year;
    }

    // Métodos Getter
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTechAddress() {
        return techAddress;
    }

    public double getPreviousReading() {
        return previousReading;
    }

    public double getCurrentReading() {
        return currentReading;
    }

    public int getInternalCode() {
        return internalCode;
    }

    public double getConsumption() {
        return consumption;
    }

    public String getCounterNumber() {
        return counterNumber;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Métodos Setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setTechAddress(String techAddress) {
        this.techAddress = techAddress;
    }

    public void setPreviousReading(double previousReading) {
        this.previousReading = previousReading;
    }

    public void setCurrentReading(double currentReading) {
        this.currentReading = currentReading;
    }

    public void setInternalCode(int internalCode) {
        this.internalCode = internalCode;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setCounterNumber(String counterNumber) {
        this.counterNumber = counterNumber;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
