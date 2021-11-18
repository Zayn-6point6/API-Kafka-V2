import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpGetFunction {
    public static JSONObject doHttpGet(String cityName){

        try {
            //https://api.openweathermap.org/data/2.5/weather?q=London&appid=3cb3858daf95395c68d867b887ccc8f3
            String apiKey = "3cb3858daf95395c68d867b887ccc8f3";
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=";
            URL url = new URL(urlString + apiKey);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);  //creates a data object for the entire JSON

                return data_obj;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
}
