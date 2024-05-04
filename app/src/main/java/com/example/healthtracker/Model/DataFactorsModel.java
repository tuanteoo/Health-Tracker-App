package com.example.healthtracker.Model;

public class DataFactorsModel {
    String age,sex,chest_pain_type,resting_bp_s,cholesterol,fasting_blood_sugar,
            resting_ecg,max_heart_rate,exercise_angina,oldpeak,ST_slope,value_fasting_blood_sugar,testfeature;

    public DataFactorsModel() {
    }

    public DataFactorsModel(String age, String sex, String chest_pain_type, String resting_bp_s, String cholesterol, String fasting_blood_sugar, String resting_ecg, String max_heart_rate, String exercise_angina, String oldpeak, String ST_slope, String value_fasting_blood_sugar, String testfeature) {
        this.age = age;
        this.sex = sex;
        this.chest_pain_type = chest_pain_type;
        this.resting_bp_s = resting_bp_s;
        this.cholesterol = cholesterol;
        this.fasting_blood_sugar = fasting_blood_sugar;
        this.resting_ecg = resting_ecg;
        this.max_heart_rate = max_heart_rate;
        this.exercise_angina = exercise_angina;
        this.oldpeak = oldpeak;
        this.ST_slope = ST_slope;
        this.value_fasting_blood_sugar = value_fasting_blood_sugar;
        this.testfeature = testfeature;
    }

    public String getValue_fasting_blood_sugar() {
        return value_fasting_blood_sugar;
    }

    public void setValue_fasting_blood_sugar(String value_fasting_blood_sugar) {
        this.value_fasting_blood_sugar = value_fasting_blood_sugar;
    }

    public String getTestfeature() {
        return testfeature;
    }

    public void setTestfeature(String testfeature) {
        this.testfeature = testfeature;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getChest_pain_type() {
        return chest_pain_type;
    }

    public void setChest_pain_type(String chest_pain_type) {
        this.chest_pain_type = chest_pain_type;
    }

    public String getResting_bp_s() {
        return resting_bp_s;
    }

    public void setResting_bp_s(String resting_bp_s) {
        this.resting_bp_s = resting_bp_s;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getFasting_blood_sugar() {
        return fasting_blood_sugar;
    }

    public void setFasting_blood_sugar(String fasting_blood_sugar) {
        this.fasting_blood_sugar = fasting_blood_sugar;
    }

    public String getResting_ecg() {
        return resting_ecg;
    }

    public void setResting_ecg(String resting_ecg) {
        this.resting_ecg = resting_ecg;
    }

    public String getMax_heart_rate() {
        return max_heart_rate;
    }

    public void setMax_heart_rate(String max_heart_rate) {
        this.max_heart_rate = max_heart_rate;
    }

    public String getExercise_angina() {
        return exercise_angina;
    }

    public void setExercise_angina(String exercise_angina) {
        this.exercise_angina = exercise_angina;
    }

    public String getOldpeak() {
        return oldpeak;
    }

    public void setOldpeak(String oldpeak) {
        this.oldpeak = oldpeak;
    }

    public String getST_slope() {
        return ST_slope;
    }

    public void setST_slope(String ST_slope) {
        this.ST_slope = ST_slope;
    }
}
