package entity;

public class Imagex {

    private String id;
    private String url;

    public Imagex(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public Imagex(String url) {
        this.url = url;
    }

    public Imagex() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
