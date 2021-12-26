package com.training.keyskillback.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "general_stat")
public class GeneralStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private String difficultyLevel;
    private int successfulAttempts;
    private int unsuccessfulAttempts;

    @OneToMany(mappedBy = "generalStatistic", fetch = FetchType.EAGER)
    private Set<Exercise> exercises = new HashSet<>();

    public GeneralStatistic() {
    }

    public GeneralStatistic(String name, String difficultyLevel, int successfulAttempts, int unsuccessfulAttempts) {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.successfulAttempts = successfulAttempts;
        this.unsuccessfulAttempts = unsuccessfulAttempts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getSuccessfulAttempts() {
        return successfulAttempts;
    }

    public void setSuccessfulAttempts(int successfulAttempts) {
        this.successfulAttempts = successfulAttempts;
    }

    public int getUnsuccessfulAttempts() {
        return unsuccessfulAttempts;
    }

    public void setUnsuccessfulAttempts(int unsuccessfulAttempts) {
        this.unsuccessfulAttempts = unsuccessfulAttempts;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}
