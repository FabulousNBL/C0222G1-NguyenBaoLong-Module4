package com.example.blogajax.model;

public class NewDTO {
    private int id;
    private String category;
    private String createDate;
    private String title;

    public NewDTO() {
    }

    public NewDTO(int id, String category, String createDate, String title) {
        this.id = id;
        this.category = category;
        this.createDate = createDate;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

