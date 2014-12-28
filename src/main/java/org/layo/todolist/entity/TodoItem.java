package org.layo.todolist.entity;

import javax.persistence.*;

/**
 * Created by Layo on 22.12.2014.
 */
@Entity
@Table(name = "TODOITEM")
public class TodoItem {

    @Id
    @GeneratedValue
    @Column(name = "TASK_ID")
    private int id;

    @Column(name = "TASK_TITLE")
    private String title;

    @Column(name = "TASK_STATUS")
    private boolean completed;

    public TodoItem() {}

    public TodoItem(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean status) {
        this.completed = status;
    }
}
