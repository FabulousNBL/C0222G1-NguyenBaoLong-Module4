package com.example.blogajax.model;

public class BlogDTO {
    private String title;
    private String content;
    private String createDay;
    private int id;
    private int category;

    public BlogDTO() {
    }

    public BlogDTO(String title, String createDay, int id, int category) {
        this.title = title;
        this.createDay = createDay;
        this.id = id;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
