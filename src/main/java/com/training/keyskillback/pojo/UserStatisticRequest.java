package com.training.keyskillback.pojo;

public class UserStatisticRequest {
    private double average_speed;
    private int errors;
    private double exercise_time;
    private Long id_exercise;
    private Long id_user;

    public double getAverage_speed() {
        return average_speed;
    }

    public void setAverage_speed(double average_speed) {
        this.average_speed = average_speed;
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

    public Long getId_exercise() {
        return id_exercise;
    }

    public void setId_exercise(Long id_exercise) {
        this.id_exercise = id_exercise;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
}
