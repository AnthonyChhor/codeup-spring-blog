package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 500)
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(Long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(long id, String title, String deleteBody) {
        this.title = title;
    }

    public Post(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Post(String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}