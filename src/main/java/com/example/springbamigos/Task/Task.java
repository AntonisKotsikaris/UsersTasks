package com.example.springbamigos.Task;

import com.example.springbamigos.Categories.Category;
import com.example.springbamigos.Users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Tasks")
public class Task {

   @Id
   @Column (name = "ID")
   @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "Title")
    private String title;

    @Column (name = "complDate")
    private LocalDate completionDate;

    @ManyToOne
    @JoinColumn(name="UserID", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "CategoryID",nullable=false)
    private Category category;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate complDate) {
        this.completionDate = complDate;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryId) {
        this.category = categoryId;
    }


}

