package com.sevak_avet.domain;

import javax.persistence.*;

@Entity
@Table(name = "QUESTIONARY")
public class Questionary {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "question", nullable = false)
    private String question;

    public Questionary(String question) {
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
