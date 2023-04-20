package Main;

public class Venue implements java.io.Serializable {
    protected String name;
    protected String location;

    public Venue(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

}

