package Main;

import java.util.Scanner;

public class Menu {
    private static final String MENU =
                    "1. Add a movie\n" +
                    "2. Remove a movie\n" +
                    "3. View a movie\n" +
                    "4. View all movies\n" +
                    "5. Add a showtime\n" +
                    "6. Remove a showtime\n" +
                    "7. View a showtime\n" +
                    "8. View all showtime\n" +
                    "9. Buy a ticket\n" +
                    "10. View seating\n" +
                    "0. Exit";

    public static void main(String[] args) {
        Theater theater = new Theater("LUT Kino", "Yliopistonkatu");

        Scanner input = new Scanner(System.in);
        int option;

        while (true) {
            System.out.printf("\nWelcome to the %s at %s!\n", theater.getName(), theater.getLocation());
            System.out.println(MENU);
            System.out.println("Enter your choice:");

            try {
                option = Integer.parseInt(input.nextLine());

            } catch (Exception e) {
                System.out.println("The input is not a valid number.");
                continue;
            }

            switch (option) {
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);

                case 1:
                    theater.addMovie(input);
                    break;

                case 2:
                    theater.removeMovie(input);
                    break;

                case 3:
                    theater.viewMovie(input);
                    break;

                case 4:
                    theater.viewAllMovies();
                    break;

                case 5:
                    theater.addShowtime(input);
                    break;

                case 6:
                    theater.removeShowtime(input);
                    break;

                case 7:
                    theater.viewShowtime(input);
                    break;

                case 8:
                    theater.viewAllShowtime();
                    break;

                case 9:
                    theater.buyTicket(input);
                    break;

                case 10:
                    theater.viewSeating(input);
                    break;

//                    Used for texting, only the movies will be saved into file "movies.ser".
                /*case 11:
                    saveData(theater.getMovies());
                    break;

                case 12:
                    if (warning(input)) break;

                    theater.setMovies(loadData());
                    break;

                case 13:
                    TMDBAPI api = new TMDBAPI();
                    api.getMovies("Jack Reacher");
                    break;*/

                default:
                    System.out.println("Invalid input number.\nPLease try again.");
            }

        }

    }

//    Functions used for texting.
   /*private static boolean warning(Scanner input) {
        System.out.println("Changes you made in this procedure will be lost, continue?\n" + "(Enter 'yes' to continue.)");

        String confirmToken = input.nextLine();

        if (confirmToken.equals("yes")) {
            System.out.println("Operation confirmed.");
            return false;
        } else {
            System.out.println("Operation cancelled.");
            return true;
        }
    }

    private static ArrayList<Movie> loadData() {
        Object movieData;

        try {
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("movies.ser"));

            movieData = objectIn.readObject();
            objectIn.close();

            System.out.println("Movies' data has been loaded from a file successfully.");

        } catch (IOException e) {
            movieData = null;
            System.out.println("Data loading failed, please try again.\n" + "Do not find existing data.");

        } catch (ClassNotFoundException c) {
            movieData = null;
            System.out.println("class not found.");
        }

        return (ArrayList<Movie>) movieData;
    }

    private static void saveData(ArrayList<Movie> movies) {
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("movies.ser"));

            objectOut.writeObject(movies);
            objectOut.close();

            System.out.println("Movies' data have been saved successfully.");

        } catch (IOException e) {
            System.out.println("Failed to save data, please try again.");
        }
    }*/

}