package API;

import java.util.List;

public class ApiResponseMovies {
    //    private boolean adult;
//    private String backdropPath;
//    private Collection belongsToCollection;
//    private int budget;
    private final List<Genre> genres;
//    private String homepage;
//    private int id;
//    private String imdbId;
//    private String originalLanguage;
//    private String originalTitle;
//    private String overview;
//    private double popularity;
//    private String posterPath;
//    private List<ProductionCompany> productionCompanies;
//    private List<ProductionCountry> productionCountries;
//    private String releaseDate;
//    private long revenue;
//    private int runtime;
//    private List<SpokenLanguage> spokenLanguages;
//    private String status;
//    private String tagline;
//    private String title;
//    private boolean video;
//    private double voteAverage;
//    private int voteCount;

    // Add constructors, getters, and setters here

    public ApiResponseMovies(List<Genre> genres) {
        this.genres = genres;
    }


//    public boolean isAdult() {
//        return adult;
//    }
//
//    public void setAdult(boolean adult) {
//        this.adult = adult;
//    }
//
//    public String getBackdropPath() {
//        return backdropPath;
//    }
//
//    public void setBackdropPath(String backdropPath) {
//        this.backdropPath = backdropPath;
//    }
//
//    public Collection getBelongsToCollection() {
//        return belongsToCollection;
//    }
//
//    public void setBelongsToCollection(Collection belongsToCollection) {
//        this.belongsToCollection = belongsToCollection;
//    }

//    public int getBudget() {
//        return budget;
//    }
//
//    public void setBudget(int budget) {
//        this.budget = budget;
//    }

    public List<Genre> getGenres() {
        return genres;
    }

//    public void setGenres(List<Genre> genres) {
//        this.genres = genres;
//    }
//
//    public String getHomepage() {
//        return homepage;
//    }
//
//    public void setHomepage(String homepage) {
//        this.homepage = homepage;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

//    public String getImdbId() {
//        return imdbId;
//    }
//
//    public void setImdbId(String imdbId) {
//        this.imdbId = imdbId;
//    }
//
//    public String getOriginalLanguage() {
//        return originalLanguage;
//    }
//
//    public void setOriginalLanguage(String originalLanguage) {
//        this.originalLanguage = originalLanguage;
//    }
//
//    public String getOriginalTitle() {
//        return originalTitle;
//    }
//
//    public void setOriginalTitle(String originalTitle) {
//        this.originalTitle = originalTitle;
//    }
//
//    public String getOverview() {
//        return overview;
//    }
//
//    public void setOverview(String overview) {
//        this.overview = overview;
//    }
//
//    public double getPopularity() {
//        return popularity;
//    }
//
//    public void setPopularity(double popularity) {
//        this.popularity = popularity;
//    }
//
//    public String getPosterPath() {
//        return posterPath;
//    }

//    public void setPosterPath(String posterPath) {
//        this.posterPath = posterPath;
//    }

//    public List<ProductionCompany> getProductionCompanies() {
//        return productionCompanies;
//    }

//    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
//        this.productionCompanies = productionCompanies;
//    }
//
//    public List<ProductionCountry> getProductionCountries() {
//        return productionCountries;
//    }
//
//    public void setProductionCountries(List<ProductionCountry> productionCountries) {
//        this.productionCountries = productionCountries;
//    }
//
//    public String getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    public long getRevenue() {
//        return revenue;
//    }
//
//    public void setRevenue(long revenue) {
//        this.revenue = revenue;
//    }
//
//    public int getRuntime() {
//        return runtime;
//    }
//
//    public void setRuntime(int runtime) {
//        this.runtime = runtime;
//    }
//
//    public List<SpokenLanguage> getSpokenLanguages() {
//        return spokenLanguages;
//    }

//    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
//        this.spokenLanguages = spokenLanguages;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getTagline() {
//        return tagline;
//    }
//
//    public void setTagline(String tagline) {
//        this.tagline = tagline;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public boolean isVideo() {
//        return video;
//    }
//
//    public void setVideo(boolean video) {
//        this.video = video;
//    }
//
//    public double getVoteAverage() {
//        return voteAverage;
//    }
//
//    public void setVoteAverage(double voteAverage) {
//        this.voteAverage = voteAverage;
//    }
//
//    public int getVoteCount() {
//        return voteCount;
//    }

    //    public void setVoteCount(int voteCount) {
//        this.voteCount = voteCount;
//    }
//    static class Collection {
//        private int id;
//        private String name;
//        private String posterPath;
//        private String backdropPath;
//
//        // Add constructors, getters, and setters here
//
//        public Collection(int id, String name, String posterPath, String backdropPath) {
//            this.id = id;
//            this.name = name;
//            this.posterPath = posterPath;
//            this.backdropPath = backdropPath;
//        }
//
////    public int getId() {
////        return id;
////    }
////
////    public void setId(int id) {
////        this.id = id;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public String getPosterPath() {
////        return posterPath;
////    }
////
////    public void setPosterPath(String posterPath) {
////        this.posterPath = posterPath;
////    }
////
////    public String getBackdropPath() {
////        return backdropPath;
////    }
////
////    public void setBackdropPath(String backdropPath) {
////        this.backdropPath = backdropPath;
////    }
//    }

    static class Genre {
        private final String name;

        // Add constructors, getters, and setters here

        public Genre(int id, String name) {
            this.name = name;
        }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

        public String getName() {
            return name;
        }

//    public void setName(String name) {
//        this.name = name;
//    }
    }

//    static class ProductionCompany {
//        private final int id;
//        private final String logoPath;
//        private final String name;
//        private final String originCountry;
//
//        // Add constructors, getters, and setters here
//
//        public ProductionCompany(int id, String logoPath, String name, String originCountry) {
//            this.id = id;
//            this.logoPath = logoPath;
//            this.name = name;
//            this.originCountry = originCountry;
//        }
//
////    public int getId() {
////        return id;
////    }
////
////    public void setId(int id) {
////        this.id = id;
////    }
////
////    public String getLogoPath() {
////        return logoPath;
////    }
////
////    public void setLogoPath(String logoPath) {
////        this.logoPath = logoPath;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public String getOriginCountry() {
////        return originCountry;
////    }
////
////    public void setOriginCountry(String originCountry) {
////        this.originCountry = originCountry;
////    }
//    }

//    static class ProductionCountry {
//        private final String iso31661;
//        private final String name;
//
//        // Add constructors, getters, and setters here
//
//        public ProductionCountry(String iso31661, String name) {
//            this.iso31661 = iso31661;
//            this.name = name;
//        }
//
////    public String getIso31661() {
////        return iso31661;
////    }
////
////    public void setIso31661(String iso31661) {
////        this.iso31661 = iso31661;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
//    }

//    static class SpokenLanguage {
//        private final String englishName;
//        private final String iso6391;
//        private final String name;
//
//        // Add constructors, getters, and setters here
//
//        public SpokenLanguage(String englishName, String iso6391, String name) {
//            this.englishName = englishName;
//            this.iso6391 = iso6391;
//            this.name = name;
//        }
//
////    public String getEnglishName() {
////        return englishName;
////    }
////
////    public void setEnglishName(String englishName) {
////        this.englishName = englishName;
////    }
////
////    public String getIso6391() {
////        return iso6391;
////    }
////
////    public void setIso6391(String iso6391) {
////        this.iso6391 = iso6391;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
//    }
}