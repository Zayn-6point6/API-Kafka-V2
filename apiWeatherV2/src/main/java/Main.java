import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        String[] cityNames = new String[]{"London", "Paris", "Berlin"};
        for(String cityName : cityNames) {
            JSONObject data_obj = HttpGetFunction.doHttpGet(cityName); //entire json object
            System.out.println(cityName + ": " + data_obj);
        }
    }
}