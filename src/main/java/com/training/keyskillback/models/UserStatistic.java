package com.training.keyskillback.models;

import javax.persistence.*;

@Entity
@Table(name = "user_stat")
public class UserStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String difficultyLevel;
    private int length_symbols;
    private int errors;
    private double exercise_time;
    private double average_speed;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("id")
//    @JoinColumns({@JoinColumn(foreignKey = @ForeignKey(name = "exercises_ibfk_1"), name = "idExercise", referencedColumnName = "idExercise")})
//    private Exercise exercise;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("id")
//    @JoinColumns({@JoinColumn(foreignKey = @ForeignKey(name = "users_ibfk_1"), name = "idUser", referencedColumnName = "idUser")})
//    private User user;


    public UserStatistic() {
    }

    public UserStatistic(String name, String difficultyLevel, int length_symbols, int errors, double exercise_time, double average_speed, Exercise exercise, User user) {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.length_symbols = length_symbols;
        this.errors = errors;
        this.exercise_time = exercise_time;
        this.average_speed = average_speed;
        this.exercise = exercise;
        this.user = user;
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

    public int getLength_symbols() {
        return length_symbols;
    }

    public void setLength_symbols(int length_symbols) {
        this.length_symbols = length_symbols;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public double getExercise_time() {
        return exercise_time;
    }

    public void setExercise_time(double exercise_time) {
        this.exercise_time = exercise_time;
    }

    public double getAverage_speed() {
        return average_speed;
    }

    public void setAverage_speed(double average_speed) {
        this.average_speed = average_speed;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
