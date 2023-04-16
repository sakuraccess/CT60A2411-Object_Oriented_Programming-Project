package Main;

//import API.TMDBAPI;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String MENU = """
            1. Add a movie
            2. Remove a movie
            3. View a movie
            4. View all movies
            5. Add a showtime
            6. Remove a showtime
            7. View a showtime
            8. View all showtime
            9. Buy a ticket
            10. View seating
            11. Save data.
            12. Load exiting data.
            0. Exit""";

    public static void main(String[] args) {
        System.out.println("""
                If you want to use exiting data,
                please choose 11 first.""");

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

                case 11:
                    saveData(theater);
                    break;

                case 12:
                    if (warning(input))
                        break;

                    theater = loadData(theater);
                    break;

//                case 13:
//                    TMDBAPI api = new TMDBAPI();
//                    api.getMovies("Jack Reacher");
//                    break;

            }

        }

    }


    private static boolean warning(Scanner input) {
        System.out.println("""
                Changes you made in this procedure will be lost, continue?
                (Enter 'yes' to continue.)""");

        String confirmToken = input.nextLine();

        if (confirmToken.equals("yes")) {
            System.out.println("Operation confirmed.");
            return false;
        } else {
            System.out.println("Operation cancelled.");
            return true;
        }
    }

    private static Theater loadData(Theater cinema) {
        Object cinemaData;

        try {
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("cinema_data.ser"));

            cinemaData = objectIn.readObject();
            objectIn.close();

            System.out.println("Cinema data has been loaded from a file successfully.");

        } catch (IOException e) {
            cinemaData = cinema;
            System.out.println("""
                    Data loading failed, please try again.
                    Do not find exiting data.""");
        } catch (ClassNotFoundException c) {
            cinemaData = cinema;
            System.out.println("class not found.");
        }

        return (Theater) cinemaData;
    }

    private static void saveData(Theater cinema) {
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("cinema_data.ser"));

            objectOut.writeObject(cinema);
            objectOut.close();

            System.out.println("Data have been saved successfully.");

        } catch (IOException e) {
            System.out.println("Failed to save data, please try again.");
        }
    }
}