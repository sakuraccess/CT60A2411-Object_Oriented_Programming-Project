package Main;

public class Showtime implements java.io.Serializable {
    private final Movie movie;
    private final String date;
    private final String time;
    private final double ticketPrice;
    private Seat[][] seats = new Seat[10][10];
//    private Boolean[][] seats = new Boolean[10][10];

    public Showtime(Movie movie, String date, String time, double ticketPrice) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.ticketPrice = ticketPrice;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j] = new Seat(i, j, true);
            }
        }
    }

    public Seat[][] getSeats() {
        return seats;
    }

//    private int ticketsSold = 0;

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public Movie getMovie() {
        return movie;
    }

//    public void setMovie(Main.Movie movie) {
//        this.movie = movie;
//    }

    public String getDate() {
        return date;
    }

//    public void setDate(String date) {
//        this.date = date;
//    }

    public String getTime() {
        return time;
    }

//    public void setTime(String time) {
//        this.time = time;
//    }

    public double getTicketPrice() {
        return ticketPrice;
    }

//    public void setTicketPrice(double ticketPrice) {
//        this.ticketPrice = ticketPrice;
//    }
}


