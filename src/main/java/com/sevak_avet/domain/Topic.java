package com.sevak_avet.domain;

import javax.persistence.*;

@Entity
@Table(name = "TOPICS")
public class Topic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "lang_id")
    private long langId;

    @Column(name = "topic", nullable = false)
    private String topic;

    public Topic(long userId, long langId, String topic) {
        this.userId = userId;
        this.langId = langId;
        this.topic = topic;
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

    public long getLangId() {
        return langId;
    }

    public void setLangId(long langId) {
        this.langId = langId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
