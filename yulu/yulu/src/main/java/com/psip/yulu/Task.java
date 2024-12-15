package com.psip.yulu;

import java.util.Date;

public class Task {
    Integer id;
    String title;
    String description;
    Date due_date;
    String status;

    public Task(Integer id, String title, String description, Date due_date, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.due_date = due_date;
    }

    public Integer getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return due_date;
    }

    public void setDueDate(Date dueDate) {
        this.due_date = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void main(String[] args) {

    }
}
