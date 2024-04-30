package com.example.healthtracker.Model;

public class HealthFactorsModel {
    String nameFactor,measure,value;
    int image;

    public HealthFactorsModel() {
    }

    public HealthFactorsModel(String nameFactor, String measure, String value, int image) {
        this.nameFactor = nameFactor;
        this.measure = measure;
        this.value = value;
        this.image = image;
    }

    public String getNameFactor() {
        return nameFactor;
    }

    public void setNameFactor(String nameFactor) {
        this.nameFactor = nameFactor;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}