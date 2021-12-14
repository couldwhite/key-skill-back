package com.training.keyskillback.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "difficultyLevels")
public class DifficultyLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLevel;
    private int length;
    private int keyZone;
    private int maxTimeKick;
    private int maxErrors;
    @OneToMany(mappedBy = "difficultyLevel")
    private List<Exercise> exerciseList;

    public DifficultyLevel() {
    }

    public DifficultyLevel(Long idLevel, int length, int keyZone, int maxTimeKick, int maxErrors) {
        this.idLevel = idLevel;
        this.length = length;
        this.keyZone = keyZone;
        this.maxTimeKick = maxTimeKick;
        this.maxErrors = maxErrors;
    }

    public Long getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Long idLevel) {
        this.idLevel = idLevel;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getKeyZone() {
        return keyZone;
    }

    public void setKeyZone(int keyZone) {
        this.keyZone = keyZone;
    }

    public int getMaxTimeKick() {
        return maxTimeKick;
    }

    public void setMaxTimeKick(int maxTimeKick) {
        this.maxTimeKick = maxTimeKick;
    }

    public int getMaxErrors() {
        return maxErrors;
    }

    public void setMaxErrors(int maxErrors) {
        this.maxErrors = maxErrors;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }
}