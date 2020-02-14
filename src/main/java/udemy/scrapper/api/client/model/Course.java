package udemy.scrapper.api.client.model;

public class Course {
    int id;
    String title;
    String url;
    String price;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Course(int id, String title, String url, String price) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;

    }

    @Override
    public String toString() {
        return id + ";" + (title.length() > 150 ? title.replace(';', '-').substring(0,149) : title.replace(';', '-')) + ";" + (url.length() > 200 ? url.substring(0, 199) : url) + ";" + price.substring(2) + ";\n" ;
    }
}
