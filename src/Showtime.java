public class Showtime {
    private Movie movie;
    private String date;
    private String time;
    private double ticketPrice;

    public Showtime(Movie movie, String date, String time, double ticketPrice) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.ticketPrice = ticketPrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
