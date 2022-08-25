package com.credManager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contents")
public class WritersContent {

    @Id
    private int id;

    private String text;
    private String lastEditedOn;
    private String createdOn;
    private String email;

    public WritersContent() {
    }

    public WritersContent( String text, String lastEditedOn, String createdOn,String email) {

        this.text = text;
        this.lastEditedOn = lastEditedOn;
        this.createdOn = createdOn;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLastEditedOn() {
        return lastEditedOn;
    }

    public void setLastEditedOn(String lastEditedOn) {
        this.lastEditedOn = lastEditedOn;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
