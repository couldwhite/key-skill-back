package com.training.keyskillback.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int levelNumber;
    private String keyZone;
    private int length;
    private int maxTimeKick;
    private int maxErrors;
    private String name;
    private String masOfSymbols;
    private String creatingWay;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "begin_timestamp", nullable = false)
    private Date dateOfCreating = new Date();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    @MapsId("idLevel")
//    @JoinColumns({@JoinColumn(foreignKey = @ForeignKey(name = "difficultyLevels_ibfk_1"), name = "idLevel", referencedColumnName = "idLevel")})
//    private DifficultyLevel difficultyLevel;


    public Exercise() {
    }

    public Exercise(int levelNumber, String keyZone,int length, int maxTimeKick, int maxErrors, String name, String masOfSymbols, String creatingWay) {
        this.levelNumber = levelNumber;
        this.keyZone = keyZone;
        this.maxTimeKick = maxTimeKick;
        this.maxErrors = maxErrors;
        this.name = name;
        this.masOfSymbols = masOfSymbols;
        this.creatingWay = creatingWay;
        this.length = length;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getKeyZone() {
        return keyZone;
    }

    public void setKeyZone(String keyZone) {
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

    public Date getDateOfCreating() {
        return dateOfCreating;
    }

    public void setDateOfCreating(Date dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
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