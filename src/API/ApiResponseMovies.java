package API;

import java.util.List;

/**
 * @param genres
 */

public record ApiResponseMovies(List<Genre> genres) {
    record Genre(String name) {
    }

}