package API;

import java.util.List;

public final class ApiResponseMovies {
    private final List<Genre> genres;

    public ApiResponseMovies(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> genres() {
        return genres;
    }


    class Genre {
        private int id;
        private String name;

        public String getName() {
            return name;
        }
    }

}