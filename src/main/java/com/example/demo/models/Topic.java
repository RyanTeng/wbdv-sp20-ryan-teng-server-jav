package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @OneToMany(mappedBy = "topic")
    private List<Widget> widgets;
    @ManyToOne
    private String lessonId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    Topic(String title, String description, List<Widget> widgets, String lessonId) {
        this.title = title;
        this.description = description;
        this.widgets = widgets;
        this.lessonId = lessonId;
    }
}
