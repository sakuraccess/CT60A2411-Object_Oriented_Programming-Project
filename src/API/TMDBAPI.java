package API;

import Main.Movie;
import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class TMDBAPI {
    public TMDBAPI() {
    }

    public Main.Movie searchMovie(String title, Scanner input) {

        Movie movie = null;

        try {
            //Public API:
            String oriUrl = "https://api.themoviedb.org/3/search/movie?api_key=ff1e0b07b7f0408929248290388d0312";
            oriUrl += "&query=" + title.replace(" ", "+");

            URL url = new URL(oriUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            //Check if connect is made
            int responseCode = conn.getResponseCode();
            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);

            } else {
                StringBuilder informationString = new StringBuilder(1024);

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    String thisLine = scanner.nextLine();
                    informationString.append(thisLine);

                }
                //Close the scanner
                scanner.close();
                Gson gson = new Gson();
                ApiResponseSearch response = gson.fromJson(String.valueOf(informationString), ApiResponseSearch.class);


                List<ApiResponseSearch.Movie> results = response.results();

                if (results.isEmpty()) {
                    System.out.println("The movie you specified could not be found in the TMDB database.");
                    return null;
                }

                ApiResponseSearch.Movie result;

                if (!results.get(0).title().equals(title)) {
                    System.out.println("The movie you specified has some matches the TMDB database.\nHere are movies with titles similar to the one you specified.\n");

                    int resultNumber = 0;
                    for (var eachResult : results) {
                        System.out.println("Match No." + ++resultNumber);
                        System.out.println("Title: " + eachResult.title());
                        System.out.println("ReleaseYear: " + eachResult.release_date());
                        System.out.println("Review: " + eachResult.overview());
                        System.out.println("Rating: " + eachResult.vote_average());
                        System.out.println("Number of Ratings: " + eachResult.vote_count());
                        System.out.println("Original Title: " + eachResult.original_title());
                        System.out.println("Original Language: " + eachResult.original_language());
                        System.out.println("Popularity: " + eachResult.popularity());
                        System.out.println();

                        if (resultNumber >= 10) {
                            System.out.println("There are more than 10 results.\nBut only the current top 10 matching results are listed.");
                            break;
                        }
                    }

                    int resultNumberChosen;
                    while (true) {
                        try {
                            System.out.println("Please select a similar movie you want to add, using the single \"Match Number\":");
                            resultNumberChosen = Integer.parseInt(input.nextLine());

                            if (resultNumberChosen < 0 || resultNumberChosen > 10) {
                                System.out.println("Integer not between 1 and 10.");
                                throw new NumberFormatException();
                            } else {
                                break;
                            }

                        } catch (NumberFormatException x) {
                            System.out.println("Please enter valid integer.\n");
//                            x.printStackTrace();
                        }
                    }

                    result = results.get(resultNumberChosen - 1);

                } else {
                    result = results.get(0);
                }

                String chosenTitle = result.title();
                String releaseYear = result.release_date();
                String review = result.overview();
                float rating = (float) result.vote_average();
                int numberOfRatings = result.vote_count();
                int id = result.id();

                String genre = completeMovie(id);

                movie = new Movie(chosenTitle, releaseYear, genre, review, rating, numberOfRatings);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movie;
    }

    //    Searching for the genre based on the movie id, and return it.
    private String completeMovie(int id) {

        try {
            String urlLink = "https://api.themoviedb.org/3/movie/id?api_key=ff1e0b07b7f0408929248290388d0312".replace("id", Integer.toString(id));
            URL url = new URL(urlLink);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();
            //Check if connect is made
            int responseCode = conn.getResponseCode();
            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);

            } else {
                StringBuilder informationString = new StringBuilder(1024);

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    String thisLine = scanner.nextLine();
                    informationString.append(thisLine);
                }
                //Close the scanner
                scanner.close();

                Gson gson = new Gson();
                ApiResponseMovies response = gson.fromJson(String.valueOf(informationString), ApiResponseMovies.class);

                var genres = response.genres();

                if (genres.isEmpty()) {
                    return null;
                }

                StringBuilder genreString = new StringBuilder("[");

                for (var genre : genres) {
                    genreString.append(genre.name()).append(", ");
                }

                genreString.setLength(genreString.length() - 2);
                genreString.append("]");

                return String.valueOf(genreString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}