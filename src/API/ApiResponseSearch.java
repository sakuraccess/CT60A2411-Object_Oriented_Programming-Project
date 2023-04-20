package API;

import java.util.List;

/**
 * @param results
 */
public record ApiResponseSearch(List<Movie> results) {
    /**
     * @param title
     * @param id
     * @param overview
     * @param release_date
     * @param vote_average
     * @param vote_count
     * @param original_title
     * @param original_language
     * @param popularity
     */
    public record Movie(String title, int id, String overview, String release_date, double vote_average, int vote_count,
                        String original_title, String original_language, double popularity) {
    }
}
