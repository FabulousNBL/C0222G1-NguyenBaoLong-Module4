package mailBox.model;

public class MailBox {
    private String language;
    private int pageSize;
    private boolean spam;
    private String signature;

    public MailBox() {
    }

    public MailBox(String language, int pageSize, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.signature = signature;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
