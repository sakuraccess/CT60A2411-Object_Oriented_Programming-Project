package API;

import Main.Movie;
import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TMDBAPI {
    public TMDBAPI() {
    }

    public Main.Movie searchMovie(String title) {

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

                var result = response.getResults().get(0);

                String releaseYear = result.getRelease_date();
                String review = result.getOverview();
                float rating = (float) result.getVote_average();
                int numberOfRatings = result.getVote_count();
                int id = result.getId();

                String genre = completeMovie(id);

                movie = new Movie(title, releaseYear, genre, review, rating, numberOfRatings);

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

                var genres = response.getGenres();
                StringBuilder genreString = new StringBuilder("[");

                for (var genre : genres) {
                    genreString.append(genre.getName()).append(", ");
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