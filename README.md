# REST-API-CLIENT

*COMPANY*:CODTECH IT SOLUTIONS

*NAME*:MOTHUKURI HASINI

*INTERN ID*::CITS0D169

*DOMAIN*:JAVA

*DURATION*:6 WEEKS

*MENTOR*:NEELA SANTOSH

## DESCRIPTION ##

This Java application uses the OpenWeatherMap public REST API to retrieve real-time weather information for a city that the user has entered. The application satisfies the requirements for a REST API client by 

demonstrating how to handle HTTP requests and parse JSON responses.

Important attributes:

User Input: Using the console, the application asks the user to enter the name of the city. The API request URL is dynamically constructed using this input.

HTTP Request: The application sends an HTTP GET request with the city name and a valid API key to the OpenWeatherMap API endpoint using Java's HttpURLConnection class. You must register on the OpenWeatherMap 

website in order to receive the API key.

Response Handling: The application verifies the HTTP response code. It prints an error message and ends gracefully if it is not 200 (OK). If not, the input stream's JSON response is read.

JSON Parsing: Nestled objects like "main" (for temperature and humidity), "wind" (for wind speed), and an array called "weather" (for weather conditions) are all present in the JSON response. This JSON string is 

parsed into a JSONObject by the program using the org.json library. It uses the right keys to extract pertinent data points.

Structured Output: Following data extraction, the application presents the data in an easy-to-use, organized manner. The city name, temperature in Celsius, humidity percentage, wind speed in meters per second, 

and weather conditions (main and description) are printed.

Basic error handling is included in the program by examining the HTTP response code, encircling the network, and parsing logic using try-catch blocks to catch exceptions and print stack traces in the event that 

unexpected errors arise.

