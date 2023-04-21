package Main;

import API.TMDBAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Theater extends Venue {
    private final ArrayList<Showtime> showtimes = new ArrayList<>();
    private final ArrayList<Movie> movies = new ArrayList<>();

//    The seats shouldn't be in the theater, it has been placed in each Showtime.
//    private Seat[][] seats;

    public Theater(String name, String location) {
        super(name, location);
    }

    private Movie findMovie(Iterator<Movie> movieIterator, String title) {
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
        while (showtimeIterator.hasNext()) {
            Showtime showtime = showtimeIterator.next();
            if (showtime.getDate().equals(date) && showtime.getTime().equals(time)) {
                return showtime;
            }
        }

        return null;
    }

    public void addMovie(Scanner input) {
        System.out.println("Enter the movie title:");
        String title = input.nextLine();

        Iterator<Movie> movieIterator = movies.iterator();

        if (findMovie(movieIterator, title) != null) {
            System.out.println("The movie already exists. Do you want to override it?");
            System.out.println("Enter 'yes' to confirm.");

            String confirmToken = input.nextLine();

            if (confirmToken.equals("yes")) {
                movieIterator.remove();
                System.out.println("Successful removed old one.");
                System.out.println("Then please enter the new one.\n");
            } else {
                System.out.println("Removing operation cancelled.");
                return;
            }
        }

        TMDBAPI api = new TMDBAPI();
        Movie movie = api.searchMovie(title, input);

        if (movie == null) {
            return;
        }

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
                System.out.println("Please enter a legal integer.\n" + "Try again.");
            }
        }

        movies.add(movie);

        System.out.println("Movie added successfully!");
    }

    public void removeMovie(Scanner input) {
        System.out.println("Enter the movie title:");
        String title = input.nextLine();

        Iterator<Movie> movieIterator = movies.iterator();
        Movie movie = findMovie(movieIterator, title);

        if (movie == null) {
            System.out.println("The movie you selected doesn't exit.");
            return;
        }

        System.out.println("Here is the movie you want to remove.");

        printMovieInfo(movie);

        System.out.println("Are you sure you want to delete this movie?\n" + "Enter 'yes' to confirm.");


        String confirmToken = input.nextLine();

        if (confirmToken.equals("yes")) {
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
        if (movies.isEmpty()) {
            System.out.println("No movie has been added yet.");
            return;
        }

        for (Movie movie : movies) {
            printMovieInfo(movie);
        }

        System.out.println("All information has been printed.");
    }

    public void addShowtime(Scanner input) {
        if (movies.isEmpty()) {
            System.out.println("No movie has been added yet.");
            return;
        }

        System.out.println("Enter the title of the movie:");
        String title = input.nextLine();

        Iterator<Movie> movieIterator = movies.iterator();

        Movie movie = findMovie(movieIterator, title);

        if (movie == null) {
            System.out.println("The movie you selected doesn't exit.");
            return;
        }

        System.out.println("Enter the time of the showtime (e.g. 7:00 PM):");
        String time = input.nextLine();

        System.out.println("Enter the date of the showtime (e.g. 2022-12-15):");
        String date = input.nextLine();


        Iterator<Showtime> showtimeIterator = showtimes.listIterator();
        Showtime showtime = findShowtime(showtimeIterator, date, time);

        if (showtime != null) {
            boolean override = false;
            if (showtime.getMovie().getTitle().equals(title)) {
                System.out.println("The showtime for this movie already existed at the time.\nDo you want to reset its fare?");
            } else {
                System.out.println("This showtime is gearing up for another movie.\nDo you want to override it?");
                override = true;
            }

            System.out.println("Enter 'yes' to confirm.");

            String confirmToken = input.nextLine();

            if (confirmToken.equals("yes")) {
                showtimeIterator.remove();
                System.out.println("Successful removed old one.");

                if (override) {
                    System.out.println("Then please enter the new one.\n");
                } else {
                    System.out.println("Then please enter the new ticket price.\n");
                }

            } else {
                System.out.println("Operation cancelled.");
                return;
            }

        }

        double ticketPrice;
        while (true) {
            try {
                System.out.println("Enter the ticket price for the showtime:");
                ticketPrice = Double.parseDouble(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a legal floating point price.\n" + "Try again.");

            }
        }

        showtimes.add(new Showtime(movie, date, time, ticketPrice));

        System.out.println("Showtime added successfully!");
    }

    public void removeShowtime(Scanner input) {
        System.out.println("Enter the title of the movie:");
        input.nextLine();

        System.out.println("Enter the time of the showtime (e.g. 7:00 PM):");
        String time = input.nextLine();

        System.out.println("Enter the date of the showtime (e.g. 2022-12-15):");
        String date = input.nextLine();

        Iterator<Showtime> showtimeIterator = showtimes.iterator();
        Showtime showtime = findShowtime(showtimeIterator, date, time);

        if (showtime == null) {
            System.out.println("The showtime you selected doesn't exit.");
            return;
        }

        System.out.println("Here is the showtime you want to remove.");

        printShowtimeInfo(showtime);

        System.out.println("Are you sure you want to delete this showtime?\n" + "Enter 'yes' to confirm.");


        String confirmToken = input.nextLine();

        if (confirmToken.equals("yes")) {
            showtimeIterator.remove();
            System.out.println("Successful removed.");
        } else {
            System.out.println("Removing operation cancelled.");
        }

    }

    public void viewShowtime(Scanner input) {
        System.out.println("Enter the title of the movie:");
        input.nextLine();

        System.out.println("Enter the time of the showtime (e.g. 7:00 PM):");
        String time = input.nextLine();

        System.out.println("Enter the date of the showtime (e.g. 2022-12-15):");
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
        if (showtimes.isEmpty()) {
            System.out.println("No showtime has been arranged yet.");
            return;
        }

        for (Showtime showtime : showtimes) {
            printShowtimeInfo(showtime);
        }

        System.out.println("All information has been printed.");
    }

    public void buyTicket(Scanner input) {
        System.out.println("Enter the movie title:");
        input.nextLine();

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

        Seat[][] seats = showtime.getSeats();
        boolean fullSeats = true;

        for (Seat[] rows : seats) {
            for (Seat column : rows) {
                if (column.isAvailable()) {
                    fullSeats = false;
                    break;
                }
            }

            if (!fullSeats) {
                break;
            }
        }

        if (fullSeats) {
            System.out.println("All seats for this time period are sold out.");
            return;
        }

        int row, column;

        while (true) {
            try {
                System.out.println("Enter the seat (row and column, separate by blank, like '5 6'):");
                String line = input.nextLine();
//                row = Integer.parseInt(input.next());
//                column = Integer.parseInt(input.next());
//                input.nextLine();
                String[] values = line.split(" ");
                row = Integer.parseInt(values[0]);
                column = Integer.parseInt(values[1]);
                break;

            } catch (Exception e) {
                System.out.println("The input is not a valid number.\nPlease try again.");

            }
        }

        if (seats[--row][--column].isAvailable()) {
            showtimeIterator.remove();
            seats[row][column].setAvailable(false);
            showtime.setSeats(seats);
            showtimes.add(showtime);
            System.out.println("Ticket bought!");

        } else {
            System.out.println("The seat is not available...\n" + "Please choose another seat.");

        }
    }

    public void viewSeating(Scanner input) {
        System.out.println("Enter the movie title:");
        input.nextLine();

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

        Seat[][] seats = showtime.getSeats();

        for (Seat[] row : seats) {
            for (Seat column : row) {
                if (column.isAvailable()) {
                    System.out.print("[0] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }

    /*public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setShowtimes(ArrayList<Showtime> showtimes) {
        this.showtimes = showtimes;
    }*/
}