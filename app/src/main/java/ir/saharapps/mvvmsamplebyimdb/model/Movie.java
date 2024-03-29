package ir.saharapps.mvvmsamplebyimdb.model;

public class Movie {
    private String id;
    private String name;
    private String imgURL;
    private String type;
    private String year;
    private String imdb;


    public Movie(String id, String name, String imgURL) {
        this.id = id;
        this.name = name;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", type='" + type + '\'' +
                ", year='" + year + '\'' +
                ", imdb='" + imdb + '\'' +
                '}';
    }
}
