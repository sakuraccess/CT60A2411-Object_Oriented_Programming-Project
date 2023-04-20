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
    private final String genre;
    private final String review;
    private final float rating;
    private final int numberOfRatings;
    private String director;
    private int duration;

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

    public void setDirector(String director) {
        this.director = director;
    }

//    public void setDuration(int duration) {
//        this.duration = duration;
//    }

    public int getDuration() {
        return duration;
    }

//    public void setGenre(String genre) {
//        this.genre = genre;
//    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

//    public void setReview(String review) {
//        this.review = review;
//    }

    public String getGenre() {
        return genre;
    }

//    public void setRating(float rating) {
//        this.rating = rating;
//    }

    public String getReview() {
        return review;
    }

//    public void setNumberOfRatings(int numberOfRatings) {
//        this.numberOfRatings = numberOfRatings;
//    }

    public float getRating() {
        return rating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }
}
