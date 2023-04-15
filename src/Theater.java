import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//import org.apache.commons.lang3.*;
//import commons-lang3;

class Theater extends Venue{
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

        int duration;
        while (true) {
            try {
                System.out.println("Enter the duration:");
                duration = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("""
                        Please enter a legal integer.
                        Try again.""");
            }
        }

        movies.add(new Movie(title, director, duration));

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
        System.out.println("Title: " + movie.getTitle());
        System.out.println("ReleaseYear: " + movie.getReleaseYear());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Duration: " + movie.getDuration());
        System.out.println("Genre: " + movie.genre());
        System.out.println();
    }

    public void viewMovie(Scanner input) {
        System.out.println("Please enter the title of the movie you want to view:");
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

        while (movieIterator.hasNext()) {
            var movie = movieIterator.next();
            printMovieInfo(movie);
        }

        System.out.println("All information has been printed.");
    }

    public void addShowtime(Scanner input) {
        System.out.println("Enter the movie title of the showtime:");
        String title = input.nextLine();

        Iterator<Movie> movieIterator = movies.iterator();

        var movie = findMovie(movieIterator, title);

        if (movie == null) {
            System.out.println("The movie you selected doesn't exit.");
            return;
        }

        System.out.println("Enter the date of the showtime:");
        String date = input.nextLine();

        System.out.println("Enter the time(yyyy-mm-dd) of the showtime:");
        String time = input.nextLine();

        double ticketPrice;
        while (true) {
            try {
                System.out.println("Enter the ticket price of the showtime:");
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
        System.out.println("Enter the showtime date:");
        String date = input.nextLine();

        System.out.println("Enter the time of the showtime:");
        String time = input.nextLine();

        Iterator<Showtime> showtimeIterator = showtimes.iterator();
        Showtime showtime = findShowtime(showtimeIterator, date, time);

        if (showtime == null) {
            System.out.println("The showtime you selected doesn't exit.");
            return;
        }

        System.out.println("""
                Are you sure you want to delete this showtime?
                Enter 'YES' to confirm.""");

        String confirmToken = input.nextLine();

        if (confirmToken.equals("YES")) {
            showtimeIterator.remove();
            System.out.println("Successful removed.");
        } else {
            System.out.println("Removing operation cancelled.");
        }

    }

    public void viewShowtime() {

    }
}