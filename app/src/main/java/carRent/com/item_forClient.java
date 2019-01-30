package carRent.com;

public class item_forClient {
    private String title , description;

    public item_forClient() {
    }

    public item_forClient(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
