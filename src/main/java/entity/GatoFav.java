package entity;

public class GatoFav {

    private String id;
    private String image_id;
    private Imagex image;

    public GatoFav(String id, String image_id, Imagex image) {
        this.id = id;
        this.image_id = image_id;
        this.image = image;
    }

    public GatoFav(String image_id, Imagex image) {
        this.image_id = image_id;
        this.image = image;
    }

    public GatoFav() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public Imagex getImage() {
        return image;
    }

    public void setImage(Imagex image) {
        this.image = image;
    }
}
