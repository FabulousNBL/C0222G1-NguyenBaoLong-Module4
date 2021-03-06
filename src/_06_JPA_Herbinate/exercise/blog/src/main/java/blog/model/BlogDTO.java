package blog.model;

public class BlogDTO {
    private String title;
    private String content;
    private String createDay;

    public BlogDTO() {
    }

    public BlogDTO(String title, String content, String createDay) {
        this.title = title;
        this.content = content;
        this.createDay = createDay;
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
}
