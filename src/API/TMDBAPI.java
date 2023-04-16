package API;

import Main.Movie;
import com.google.gson.Gson;

import java.lang.reflect.Type;
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
//            System.out.println(oriUrl);

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
//                ArrayList<String> informationString = new ArrayList<>();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    String thisLine = scanner.nextLine();
                    informationString.append(thisLine);
//                    System.out.println(thisLine);
                }
                //Close the scanner
                scanner.close();
//                System.out.println(informationString);
//                for (String list : lists) {
//                    System.out.println(list);
//                }
                Gson gson = new Gson();
                ApiResponseSearch response = gson.fromJson(String.valueOf(informationString), ApiResponseSearch.class);
//                System.out.println(response);
                var result = response.getResults().get(0);

//                for (var result : results) {
//                    System.out.println(result.getOriginal_title());
//                    System.out.println(result.getRelease_date());
//                    System.out.println(result.getTitle());
//                    System.out.println();
//                }
//                var title = result.getTitle();
//                var director = result.getOriginal_title();
                String releaseYear = result.getRelease_date();
                String review = result.getOverview();
                float rating = (float) result.getVote_average();
                int numberOfRatings = result.getVote_count();
                int id = result.getId();
                System.out.println(id);
                String genre = completeMovie(id);

                movie = new Movie(title, releaseYear, genre, review, rating, numberOfRatings);


//                Title: Avatar
//                Director: James Cameron
//                Release Year: 2009-12-15
//                Review: In the 22nd century, a paraplegic Marine is dispatched to the moon Pandora on a unique mission, but becomes torn between following orders and protecting an alien civilization.
//                Genre: [Action, Adventure, Fantasy, Science Fiction]
//                Duration: 162
//                Rating: 7.569
//                Number of Ratings: 28872

//                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movie;
    }

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
//                ArrayList<String> informationString = new ArrayList<>();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    String thisLine = scanner.nextLine();
                    informationString.append(thisLine);
//                    System.out.println(thisLine);
                }
                //Close the scanner
                scanner.close();
                System.out.println(informationString);

                Gson gson = new Gson();
                ApiResponseMovies response = gson.fromJson(String.valueOf(informationString), ApiResponseMovies.class);

                var genres = response.getGenres();
                StringBuilder genreString = new StringBuilder("[");

                for (var genre : genres) {
                    genreString.append(genre.getName()).append(", ");
                }

                genreString.setLength(genreString.length() - 2);
                genreString.append("]");

//                movie.setGenre(String.valueOf(genreString));

                return String.valueOf(genreString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}