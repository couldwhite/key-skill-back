package com.training.keyskillback.pojo;

public class CreateExerciseRequest {

    private String name;
    private String masOfSymbols;
    private String creatingWay;
    private String idLevel;

    public String getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(String idLevel) {
        this.idLevel = idLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMasOfSymbols() {
        return masOfSymbols;
    }

    public void setMasOfSymbols(String masOfSymbols) {
        this.masOfSymbols = masOfSymbols;
    }

    public String getCreatingWay() {
        return creatingWay;
    }

    public void setCreatingWay(String creatingWay) {
        this.creatingWay = creatingWay;
    }
}