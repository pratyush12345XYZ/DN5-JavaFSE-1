package com.cognizant.quizhql.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_date")
    private LocalDate date;

    @Column(name = "at_score")
    private double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(mappedBy = "attempt", fetch = FetchType.LAZY)
    private Set<AttemptQuestion> attemptQuestions;

    public Attempt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }
}