import java.util.ArrayList;

public class Venue {
    protected String name;
    protected String location;

    public Venue(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

class Theater extends Venue {
    private ArrayList<Movie> movies;
    private ArrayList<Showtime> showtimes;
    private Seat[][] seats;

    public Theater(String name, String location) {
        super(name, location);
    }
}
