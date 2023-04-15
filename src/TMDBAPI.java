import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TMDBAPI {
    public TMDBAPI() {
    }

    public Movie getMovies(String title) {
        try {
            //Public API:

            String oriUrl = "https://api.themoviedb.org/3/movie/movie?api_key=ff1e0b07b7f0408929248290388d0312";

            oriUrl += title.replace(" ", "+");

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
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);
//                for (String list : lists) {
//                    System.out.println(list);
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}