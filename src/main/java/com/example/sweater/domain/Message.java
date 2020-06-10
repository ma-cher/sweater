package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // помечает класс как сущность, которую мы будем сохранять в бд
public class Message {
    @Id // сообщает нашему фреймворку, что это поле - наш уникальный идентификатор
    @GeneratedValue(strategy= GenerationType.AUTO) // говорим, чтобы они автоматически идентифицировались
    private Integer id;

    private String text;
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
