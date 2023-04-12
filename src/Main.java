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

            }

        }

    }
}