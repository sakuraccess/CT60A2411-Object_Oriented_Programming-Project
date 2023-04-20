package Main;

public class Movie implements java.io.Serializable {
    private final String title;
    private final String releaseYear;
    private final String genre;
    private final String review;
    private final float rating;
    private final int numberOfRatings;
    private String director;
    private int duration;

    public Movie(String title, String releaseYear, String genre, String review, float rating, int numberOfRatings) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.review = review;
        this.rating = rating;
        this.numberOfRatings = numberOfRatings;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getReview() {
        return review;
    }

    public float getRating() {
        return rating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }
}
