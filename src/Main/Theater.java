package Main;

import API.TMDBAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//import org.apache.commons.lang3.*;
//import commons-lang3;

class Theater extends Venue {
    private final ArrayList<Movie> movies = new ArrayList<>();
    private final ArrayList<Showtime> showtimes = new ArrayList<>();
//    private Seat[][] seats;

    public Theater(String name, String location) {
        super(name, location);
    }

    private Movie findMovie(Iterator<Movie> movieIterator, String title) {
//        boolean found = false;

//        Iterator<Movie> movieIterator = movies.iterator();

        while (movieIterator.hasNext()) {
            Movie movie = movieIterator.next();
            if (movie.getTitle().equals(title)) {
                return movie;
//                break;
            }
        }

        return null;
    }

    private Showtime findShowtime(Iterator<Showtime> showtimeIterator, String date, String time) {
//        boolean found = false;

//        Iterator<Movie> movieIterator = movies.iterator();

        while (showtimeIterator.hasNext()) {
            Showtime showtime = showtimeIterator.next();
            if (showtime.getDate().equals(date) && showtime.getTime().equals(time)) {
                return showtime;
//                break;
            }
        }

        return null;
    }

    public void addMovie(Scanner input) {
        System.out.println("Enter the movie title:");
        String title = input.nextLine();

        TMDBAPI api = new TMDBAPI();
        Movie movie = api.searchMovie(title);

//        for (Movie movie : movies) {
//            if (title.equals(movie.getTitle())) {
//                System.out.println("""
//                        There already have this movie.
//                        Do you want to edit it?
//               """);
//            }
//        }

        System.out.println("Enter the director:");
        String director = input.nextLine();
        movie.setDirector(director);

        int duration;
        while (true) {
            try {
                System.out.println("Enter the duration:");
                duration = Integer.parseInt(input.nextLine());
                movie.setDuration(duration);
                break;
            } catch (Exception e) {
                System.out.println("""
                        Please enter a legal integer.
                        Try again.""");
            }
        }

        movies.add(movie);

        System.out.println("Movie added successfully!");
    }

    public void removeMovie(Scanner input) {
        System.out.println("Enter the movie title:");
        String title = input.nextLine();

//        boolean found = false;
//
//        Iterator<Movie> movieIterator = movies.iterator();
//
//        while (movieIterator.hasNext()) {
//            Movie movie = movieIterator.next();
//            if (movie.getTitle().equals(title)) {
//                found = true;
//                break;
//            }
//        }
        Iterator<Movie> movieIterator = movies.iterator();
        Movie movie = findMovie(movieIterator, title);

//        if (!found) {
        if (movie == null) {
            System.out.println("The movie you selected doesn't exit.");
            return;
        }

        System.out.println("""
                Are you sure you want to delete this movie?
                Enter 'YES' to confirm.""");

        String confirmToken = input.nextLine();

        if (confirmToken.equals("YES")) {
            movieIterator.remove();
            System.out.println("Successful removed.");
        } else {
            System.out.println("Removing operation cancelled.");
        }

    }

    private void printMovieInfo(Movie movie) {
        System.out.println();
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("ReleaseYear: " + movie.getReleaseYear());
        System.out.println("Review: " + movie.getReview());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Duration: " + movie.getDuration());
        System.out.println("Rating: " + movie.getRating());
        System.out.println("Number of Ratings:" + movie.getNumberOfRatings());
        System.out.println();
    }

    private void printShowtimeInfo(Showtime showtime) {
        System.out.println();
        System.out.println("Movie: " + showtime.getMovie().getTitle());
        System.out.println("Time: " + showtime.getTime());
        System.out.println("Date: " + showtime.getDate());
        System.out.println("Price: " + showtime.getTicketPrice());
        System.out.println();
    }

    public void viewMovie(Scanner input) {
        System.out.println("Enter the movie title:");
        String title = input.nextLine();

        Iterator<Movie> movieIterator = movies.iterator();
        Movie movie = findMovie(movieIterator, title);

        if (movie == null) {
            System.out.println("The movie you selected doesn't exit.");
            return;
        }

        printMovieInfo(movie);

        System.out.println("All information has been printed.");
    }

    public void viewAllMovies() {
        Iterator<Movie> movieIterator = movies.iterator();

        if (!movieIterator.hasNext()) {
            System.out.println("There doesn't have movies right now.");
            return;
        }

        while (movieIterator.hasNext()) {
            var movie = movieIterator.next();
            printMovieInfo(movie);
        }

        System.out.println("All information has been printed.");
    }

    public void addShowtime(Scanner input) {
        System.out.println("Enter the title of the movie:");
        String title = input.nextLine();

        Iterator<Movie> movieIterator = movies.iterator();

        var movie = findMovie(movieIterator, title);

        if (movie == null) {
            System.out.println("The movie you selected doesn't exit.");
            return;
        }

        System.out.println("Enter the time of the showtime (e.g. 7:00 PM):");
        String time = input.nextLine();

        System.out.println("Enter the date of the showtime (e.g. 2022-12-15):");
        String date = input.nextLine();

        double ticketPrice;
        while (true) {
            try {
                System.out.println("Enter the ticket price for the showtime:");
                ticketPrice = Double.parseDouble(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("""
                        Please enter a legal floating point price.
                        Try again.""");
            }
        }

        showtimes.add(new Showtime(movie, date, time, ticketPrice));

        System.out.println("Showtime added successfully!");
    }

    public void removeShowtime(Scanner input) {
        System.out.println("Enter the time of the showtime:");
        String time = input.nextLine();

        System.out.println("Enter the showtime date:");
        String date = input.nextLine();

        Iterator<Showtime> showtimeIterator = showtimes.iterator();
        Showtime showtime = findShowtime(showtimeIterator, date, time);

        if (showtime == null) {
            System.out.println("The showtime you selected doesn't exit.");
            return;
        }

        System.out.println("""
                Are you sure you want to delete this showtime?
                Enter 'yes' to confirm.""");

        String confirmToken = input.nextLine();

        if (confirmToken.equals("yes")) {
            showtimeIterator.remove();
            System.out.println("Successful removed.");
        } else {
            System.out.println("Removing operation cancelled.");
        }

    }

    public void viewShowtime(Scanner input) {
        System.out.println("Enter the time of the showtime:");
        String time = input.nextLine();

        System.out.println("Enter the showtime date:");
        String date = input.nextLine();

        Iterator<Showtime> showtimeIterator = showtimes.iterator();
        Showtime showtime = findShowtime(showtimeIterator, date, time);

        if (showtime == null) {
            System.out.println("The showtime you selected doesn't exit.");
            return;
        }

        printShowtimeInfo(showtime);

        System.out.println("All information has been printed.");
    }

    public void viewAllShowtime() {
        for (Showtime showtime : showtimes) {
            printShowtimeInfo(showtime);
        }

        System.out.println("All information has been printed.");
    }

    public void buyTicket(Scanner input) {
        System.out.println("Enter the movie title:");
        String title = input.nextLine();

        System.out.println("Enter the showtime (time):");
        String time = input.nextLine();

        System.out.println("Enter the showtime (date):");
        String date = input.nextLine();

        System.out.println("Enter the seat (row and column):");

        int row, column;

        while (true) {
            try {
                row = Integer.parseInt(input.next());
                column = Integer.parseInt(input.next());
                input.nextLine();
                break;

            } catch (Exception e) {
                System.out.println("""
                        The input is not a valid number.
                        Please try again.""");
            }
        }

        Iterator<Showtime> showtimeIterator = showtimes.iterator();
        Showtime showtime = findShowtime(showtimeIterator, date, time);

        if (showtime == null) {
            System.out.println("The showtime you selected doesn't exit.");
            return;
        }

        Seat[][] seats = showtime.getSeats();
        row -= 1;
        column -= 1;

        if (seats[row][column].isAvailable()) {
            showtimeIterator.remove();
            seats[row][column].setAvailable(false);
            showtime.setSeats(seats);
            showtimes.add(showtime);
            System.out.println("Ticket bought!");

        } else {
            System.out.println("""
                    The seat is not available...
                    Please choose another seat.""");
        }
    }

    public void viewSeating(Scanner input) {
        System.out.println("Enter the movie title:");
        String title = input.nextLine();

        System.out.println("Enter the showtime (time):");
        String time = input.nextLine();

        System.out.println("Enter the showtime (date):");
        String date = input.nextLine();

        Iterator<Showtime> showtimeIterator = showtimes.iterator();
        Showtime showtime = findShowtime(showtimeIterator, date, time);

        if (showtime == null) {
            System.out.println("The showtime you selected doesn't exit.");
            return;
        }

        var seats = showtime.getSeats();

        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if (seats[row][column].isAvailable()) {
                    System.out.print("[0] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }
}