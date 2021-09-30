package entity;

public class Gato {

    private String id;
    private String url;
    private String apiKey = "77809408-7c7f-4100-8954-307d8980654e";
    private String image;

    public Gato(String id, String url, String apiKey, String image) {
        this.id = id;
        this.url = url;
        this.apiKey = apiKey;
        this.image = image;
    }

    public Gato(String url, String apiKey, String image) {
        this.url = url;
        this.apiKey = apiKey;
        this.image = image;
    }

    public Gato() {
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

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
