package com.example.healthtracker.Model;

public class DataFactorsModel {
    int Age,Sex,Cholesterol,Heart_Rate,Diabetes,Obesity,Alcohol_Consumption,
            Exercise_Hours_Per_Week,Diet,Medication_Use,Stress_Level,Sedentary_Hours_Per_Day,Physical_Activity_Days_Per_Week,
            Sleep_Hours_Per_Day,Diastolic_BP,Systolic_BP;

    public DataFactorsModel() {
    }

    public DataFactorsModel(int age, int sex, int cholesterol, int heart_Rate, int diabetes, int obesity, int alcohol_Consumption, int exercise_Hours_Per_Week, int diet, int medication_Use, int stress_Level, int sedentary_Hours_Per_Day, int physical_Activity_Days_Per_Week, int sleep_Hours_Per_Day, int diastolic_BP, int systolic_BP) {
        Age = age;
        Sex = sex;
        Cholesterol = cholesterol;
        Heart_Rate = heart_Rate;
        Diabetes = diabetes;
        Obesity = obesity;
        Alcohol_Consumption = alcohol_Consumption;
        Exercise_Hours_Per_Week = exercise_Hours_Per_Week;
        Diet = diet;
        Medication_Use = medication_Use;
        Stress_Level = stress_Level;
        Sedentary_Hours_Per_Day = sedentary_Hours_Per_Day;
        Physical_Activity_Days_Per_Week = physical_Activity_Days_Per_Week;
        Sleep_Hours_Per_Day = sleep_Hours_Per_Day;
        Diastolic_BP = diastolic_BP;
        Systolic_BP = systolic_BP;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public int getCholesterol() {
        return Cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        Cholesterol = cholesterol;
    }

    public int getHeart_Rate() {
        return Heart_Rate;
    }

    public void setHeart_Rate(int heart_Rate) {
        Heart_Rate = heart_Rate;
    }

    public int getDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(int diabetes) {
        Diabetes = diabetes;
    }

    public int getObesity() {
        return Obesity;
    }

    public void setObesity(int obesity) {
        Obesity = obesity;
    }

    public int getAlcohol_Consumption() {
        return Alcohol_Consumption;
    }

    public void setAlcohol_Consumption(int alcohol_Consumption) {
        Alcohol_Consumption = alcohol_Consumption;
    }

    public int getExercise_Hours_Per_Week() {
        return Exercise_Hours_Per_Week;
    }

    public void setExercise_Hours_Per_Week(int exercise_Hours_Per_Week) {
        Exercise_Hours_Per_Week = exercise_Hours_Per_Week;
    }

    public int getDiet() {
        return Diet;
    }

    public void setDiet(int diet) {
        Diet = diet;
    }

    public int getMedication_Use() {
        return Medication_Use;
    }

    public void setMedication_Use(int medication_Use) {
        Medication_Use = medication_Use;
    }

    public int getStress_Level() {
        return Stress_Level;
    }

    public void setStress_Level(int stress_Level) {
        Stress_Level = stress_Level;
    }

    public int getSedentary_Hours_Per_Day() {
        return Sedentary_Hours_Per_Day;
    }

    public void setSedentary_Hours_Per_Day(int sedentary_Hours_Per_Day) {
        Sedentary_Hours_Per_Day = sedentary_Hours_Per_Day;
    }

    public int getPhysical_Activity_Days_Per_Week() {
        return Physical_Activity_Days_Per_Week;
    }

    public void setPhysical_Activity_Days_Per_Week(int physical_Activity_Days_Per_Week) {
        Physical_Activity_Days_Per_Week = physical_Activity_Days_Per_Week;
    }

    public int getSleep_Hours_Per_Day() {
        return Sleep_Hours_Per_Day;
    }

    public void setSleep_Hours_Per_Day(int sleep_Hours_Per_Day) {
        Sleep_Hours_Per_Day = sleep_Hours_Per_Day;
    }

    public int getDiastolic_BP() {
        return Diastolic_BP;
    }

    public void setDiastolic_BP(int diastolic_BP) {
        Diastolic_BP = diastolic_BP;
    }

    public int getSystolic_BP() {
        return Systolic_BP;
    }

    public void setSystolic_BP(int systolic_BP) {
        Systolic_BP = systolic_BP;
    }
}
