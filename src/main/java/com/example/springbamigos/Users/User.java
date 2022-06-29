package com.example.springbamigos.Users;

import com.example.springbamigos.Task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Users")
public class User {

    @Id
    @Column(name = "ID")
    private long id;

    @Column ( name = "UserName")
    private String userName;

    @OneToMany(mappedBy="user")
    @JsonIgnoreProperties ("user")
    @JsonIgnore
    private List<Task> tasks;

    public long getId() {
        return id;
    }

   // public List<Task> getTasks() {
       // return tasks;
    //}

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
