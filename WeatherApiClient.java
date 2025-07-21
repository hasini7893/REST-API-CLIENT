package Internship;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApiClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("🌍 Enter city name: ");
        String city = sc.nextLine();

        String apiKey = "your_api_key_here";  // Replace with your real OpenWeatherMap API key
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" 
                + city + "&appid=" + apiKey + "&units=metric";

        try {
            // Step 1: Send HTTP GET Request
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int code = conn.getResponseCode();
            if (code != 200) {
                System.out.println("❌ Error: Failed to fetch data. HTTP code: " + code);
                return;
            }

            // Step 2: Read JSON response as plain text
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
            in.close();

            // Step 3: Extract data manually
            String response = json.toString();

            // Extract city name
            String cityName = extractValue(response, "\"name\":\"", "\"");

            // Extract weather condition
            String weatherMain = extractValue(response, "\"main\":\"", "\"");

            // Extract temperature
            String temp = extractValue(response, "\"temp\":", ",");

            // Extract humidity
            String humidity = extractValue(response, "\"humidity\":", ",");

            // Extract wind speed
            String wind = extractValue(response, "\"speed\":", ",");

            // Step 4: Display
            System.out.println("\n📍 City: " + cityName);
            System.out.println("🌤️ Weather: " + weatherMain);
            System.out.println("🌡️ Temperature: " + temp + "°C");
            System.out.println("💧 Humidity: " + humidity + "%");
            System.out.println("💨 Wind Speed: " + wind + " m/s");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to extract value between start and end markers
    public static String extractValue(String json, String start, String end) {
        int startIndex = json.indexOf(start);
        if (startIndex == -1) return "N/A";
        startIndex += start.length();
        int endIndex = json.indexOf(end, startIndex);
        if (endIndex == -1) return "N/A";
        return json.substring(startIndex, endIndex);
    }
}
