import java.net.*;
import java.io.*;
import java.util.Map;
import org.json.*;
//class getdata is used to get data from the api, and to another class that interprets that data
class Getdata {
// this method calls the api, and gets all its data, it its raw form
 public String call() {
   //This is the string containing all the data from the api, this will be returned by this method
   String retval = null;
   //If there is an error, you want to exit, so we are using try and catch statements
   try {
     //this is the url, in which the api stays, and the website we need to call to get our data
     String urlString = "https://api.darksky.net/forecast/10aa5bd4b8f6ce5460e619e18153d47d/37.3688,-122.0363";
     //This is a url class that helps us reach this address in the internet
     URL url = new URL(urlString);
     //This is one way to open the connection between my computer, and the api
     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
     //This tells we want to do a get request, which asks the api for data
     connection.setRequestMethod("GET");
     //This helps read the data returned by the api because connection.getInputStream is all the data we want
     BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
     // This is a class that helps us add to a string line by line
     StringBuffer add = new StringBuffer();
     // This is each line of the data from the api
     String line = read.readLine();
     //What this does is while the next line is not empty, we add the next line to our string buffer, making it a combination of every line
     while(line != null) {
       add.append(line);
       line = read.readLine();
     }
     //This is how to close the data, because we opened it, and need to close the data
     read.close();
     //This turns out class StringBuffer into a string, that we return
     retval = add.toString();
   } catch (Exception e) {
     // For every error, we print that errors message
     System.out.println(e.getMessage());
   }
   //returning the Datatofile
   return retval;
 }
 //this method takes in JSON, and parses it
 public float[] parseWeekend(String output) {
   // this is a class for parsing json
  JSONObject parse = new JSONObject(output);
  JSONArray hi = parse.getJSONObject("daily").getJSONArray("data");
  //using the parse method to get our data
  float[] weather = {(hi.getJSONObject(0).getFloat("apparentTemperatureHigh") + hi.getJSONObject(0).getFloat("apparentTemperatureLow"))/2,hi.getJSONObject(0).getFloat("precipIntensity"),hi.getJSONObject(0).getFloat("precipProbability")};
  //returning our data
  return weather;
  }
  public float[] parseWeekday(String output) {
    // this is a class for parsing json
    JSONObject parse = new JSONObject(output);
    JSONArray hi = parse.getJSONObject("hourly").getJSONArray("data");
    //using the parse method to get our data
    float temp = 0;
    float precipIntensity = 0;
    float precipProbability = 0;
    if (hi.getJSONObject(0).getFloat("apparentTemperature") < hi.getJSONObject(2).getFloat("apparentTemperature") && hi.getJSONObject(0).getFloat("apparentTemperature") < hi.getJSONObject(5).getFloat("apparentTemperature")) {
      temp = hi.getJSONObject(0).getFloat("apparentTemperature");
    } else if (hi.getJSONObject(2).getFloat("apparentTemperature") < hi.getJSONObject(0).getFloat("apparentTemperature") && hi.getJSONObject(2).getFloat("apparentTemperature") < hi.getJSONObject(5).getFloat("apparentTemperature")) {
      temp = hi.getJSONObject(2).getFloat("apparentTemperature");
    } else {
      temp = hi.getJSONObject(5).getFloat("apparentTemperature");
    }
    if (hi.getJSONObject(0).getFloat("precipProbability") > hi.getJSONObject(2).getFloat("precipProbability") && hi.getJSONObject(0).getFloat("precipProbability") > hi.getJSONObject(5).getFloat("precipProbability")) {
      temp = hi.getJSONObject(0).getFloat("precipProbability");
    } else if (hi.getJSONObject(2).getFloat("precipProbability") > hi.getJSONObject(0).getFloat("precipProbability") && hi.getJSONObject(2).getFloat("precipProbability") > hi.getJSONObject(5).getFloat("precipProbability")) {
      temp = hi.getJSONObject(2).getFloat("precipProbability");
    } else {
      precipProbability = hi.getJSONObject(5).getFloat("precipProbability");
    }
    if (hi.getJSONObject(0).getFloat("precipIntensity") > hi.getJSONObject(2).getFloat("precipIntensity") && hi.getJSONObject(0).getFloat("precipIntensity") > hi.getJSONObject(5).getFloat("precipIntensity")) {
      temp = hi.getJSONObject(0).getFloat("precipIntensity");
    } else if (hi.getJSONObject(2).getFloat("precipIntensity") > hi.getJSONObject(0).getFloat("precipIntensity") && hi.getJSONObject(2).getFloat("precipIntensity") > hi.getJSONObject(5).getFloat("precipIntensity")) {
      temp = hi.getJSONObject(2).getFloat("precipIntensity");
    } else {
      precipIntensity = hi.getJSONObject(5).getFloat("precipIntensity");
    }
    float[] weather = {temp,precipIntensity,precipProbability};
    //returning our data
    return weather;
 }
}

