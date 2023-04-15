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

        Theater cinema = new Theater("LUT Kino", "Yliopistonkatu");

        Scanner input = new Scanner(System.in);
        int option = -1;

        while (true) {
            System.out.printf("\nWelcome to the %s at %s!\n", cinema.getName(), cinema.getLocation());
            System.out.println(MENU);
            System.out.println("Enter your choice:");

            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 0:
                    System.exit(0);

                case 1:
                    cinema.addMovie(input);
                    break;

                case 2:
                    cinema.removeMovie(input);
                    break;

                case 3:
                    cinema.viewMovie(input);
                    break;

                case 4:
                    cinema.viewAllMovies();
                    break;

                case 5:
                    cinema.addShowtime(input);
                    break;

                case 6:
                    cinema.removeShowtime(input);
                    break;

                case 11:
                    saveData(cinema);
                    break;

                case 12:
                    if (warning(input))
                        break;

                    cinema = loadData(cinema);
                    break;

            }

        }

    }


    private static boolean warning(Scanner input) {
        System.out.println("""
                Changes you made in this procedure will be lost, continue?
                (Enter 'YES' to continue.)""");

        String confirmToken = input.nextLine();

        if (confirmToken.equals("YES")) {
            System.out.println("Operation confirmed.");
            return false;
        } else {
            System.out.println("Operation cancelled.");
            return true;
        }
    }

    private static Theater loadData(Theater cinema) {
        Object cinemaData = null;

        try {
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("cinema_data.ser"));

            cinemaData = objectIn.readObject();
            objectIn.close();

            System.out.println("Cinema data has been loaded from a file successfully.");

        } catch (IOException | ClassNotFoundException e) {
            cinemaData = cinema;
            System.out.println("""
                    Data loading failed, please try again.
                    Do not find exiting data.""");
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