package com.sevak_avet.old;

import javax.persistence.*;

@Entity
@Table(name = "QUESTIONARY")
public class Questionary {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "question", nullable = false)
    private String question;

    public Questionary(String question) {
        this.question = question;
    }

    public Questionary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
