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
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "begin_timestamp", nullable = false)
    private Date dateOfCreating = new Date();
    private String masOfSymbols;
    private String creatingWay;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @MapsId("idLevel")
    @JoinColumns({@JoinColumn(foreignKey = @ForeignKey(name = "difficultyLevels_ibfk_1"), name = "idLevel", referencedColumnName = "idLevel")})
    private DifficultyLevel difficultyLevel;


    public Exercise() {
    }

    public Exercise(String name, String masOfSymbols, String creatingWay) {
        this.name = name;
        this.masOfSymbols = masOfSymbols;
        this.creatingWay = creatingWay;
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

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}