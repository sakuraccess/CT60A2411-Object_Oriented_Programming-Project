package Main;

public class Movie implements java.io.Serializable {
//    Title: Avatar
//    Director: James Cameron
//    Release Year: 2009-12-15
//    Review: In the 22nd century, a paraplegic Marine is dispatched to the moon Pandora on a unique mission, but becomes torn between following orders and protecting an alien civilization.
//    Genre: [Action, Adventure, Fantasy, Science Fiction]
//    Duration: 162
//    Rating: 7.569
//    Number of Ratings: 28872
    private final String title;
    private final String releaseYear;
    private String director;
    private int duration;
    private String genre;
    private String review;
    private float rating;

    private int numberOfRatings;

//    public Main.Movie(String title, String releaseYear, String director, int duration, String genre) {
//        this.title = title;
//        this.releaseYear = releaseYear;
//        this.director = director;
//        this.duration = duration;
//        this.genre = genre;
//    }

    public Movie(String title, String releaseYear, String genre, String review, float rating, int numberOfRatings) {
        this.title = title;
        this.releaseYear = releaseYear;
//        this.director = director;
//        this.duration = duration;
        this.genre = genre;
        this.review = review;
        this.rating = rating;
        this.numberOfRatings = numberOfRatings;
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getReleaseYear() {
        return releaseYear;
    }

//    public void setReleaseYear(String releaseYear) {
//        this.releaseYear = releaseYear;
//    }

    public String getDirector() {
        return director;
    }

//    public void setDirector(String director) {
//        this.director = director;
//    }

    public int getDuration() {
        return duration;
    }

//    public void setDuration(int duration) {
//        this.duration = duration;
//    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
