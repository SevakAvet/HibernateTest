package com.sevak_avet.domain;

import javax.persistence.*;

@Entity
@Table(name = "ANSWERS")
public class Answer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "question_id")
    private long questionId;

    @Column(name = "answer", nullable = false)
    private int answer;

    public Answer(long userId, long questionId, int answer) {
        this.userId = userId;
        this.questionId = questionId;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
