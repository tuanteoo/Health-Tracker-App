package com.example.healthtracker.Model;

public class HealthFactorsModel {
    String image, nameFactor,measure;
    int value;

    public HealthFactorsModel() {
    }

    public HealthFactorsModel(String image, String nameFactor, int value, String measure) {
        this.image = image;
        this.nameFactor = nameFactor;
        this.value = value;
        this.measure = measure;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameFactor() {
        return nameFactor;
    }

    public void setNameFactor(String nameFactor) {
        this.nameFactor = nameFactor;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}