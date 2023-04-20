package API;

import java.util.ArrayList;
import java.util.List;

public class ApiResponseSearch {
    List<Movie> results = new ArrayList<>();

    public List<Movie> getResults() {
        return results;
    }

    static final class Movie {
        private final String title;
        private final int id;
        private final String overview;
        private final String release_date;
        private final double vote_average;
        private final int vote_count;
        private final String original_title;
        private final String original_language;
        private final double popularity;

        public Movie(String title, int id, String overview, String release_date, double vote_average, int vote_count, String original_title, String original_language, double popularity) {
            this.title = title;
            this.id = id;
            this.overview = overview;
            this.release_date = release_date;
            this.vote_average = vote_average;
            this.vote_count = vote_count;
            this.original_title = original_title;
            this.original_language = original_language;
            this.popularity = popularity;
        }

        public String title() {
            return title;
        }

        public int id() {
            return id;
        }

        public String overview() {
            return overview;
        }

        public String release_date() {
            return release_date;
        }

        public double vote_average() {
            return vote_average;
        }

        public int vote_count() {
            return vote_count;
        }

        public String original_title() {
            return original_title;
        }

        public String original_language() {
            return original_language;
        }

        public double popularity() {
            return popularity;
        }

    }
}
