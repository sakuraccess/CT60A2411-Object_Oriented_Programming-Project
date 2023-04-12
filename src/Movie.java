public class Movie {
    private String title;
    private String releaseYear;
    private String director;
    private int duration;
    private String genre;

    public Movie(String title, String releaseYear, String director, int duration, String genre) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
    }

    public Movie(String title, String director, int duration) {
        this.title = title;
        this.director = director;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
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

    public String genre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
