import java.net.*;
import java.io.*;
import java.util.Map;
import org.json.*;
class Getdata {
 public String call() {
   String retval = null;
   try {
     String urlString = "https://api.geocod.io/v1.4/reverse?q=36.1627,-86.7816&api_key=30daa570d0d0052082a733e00772e0277e25792";
     URL url = new URL(urlString);
     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
     connection.setRequestMethod("GET");
     BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
     StringBuffer add = new StringBuffer();
     String line = read.readLine();
     while(line != null) {
       add.append(line);
       line = read.readLine();
     }
     read.close();
     retval = add.toString();
   } catch (Exception e) {
     System.out.println(e.getMessage());
   }
   return retval;
 }
 public String zillowCall(String address) {
   String retval = null;
   try {
     String urlString ="http://www.zillow.com/webservice/GetSearchResults.htm?zws-id=X1-ZWz17iezcu3wgb_5cfwc&rentzestimate=true&citystatezip=Nashville,TN&address=" + address;
     URL url = new URL(urlString);
     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
     connection.setRequestMethod("GET");
     BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
     StringBuffer add = new StringBuffer();
     String line = read.readLine();
     while(line != null) {
       add.append(line);
       line = read.readLine();
     }
     read.close();
     retval = add.toString();
   } catch (Exception e) {
     System.out.println(e.getMessage());
   }
   return retval;
 }
 public String forSaleCall (String zpid) {
   String retval = null;
   try {
     String urlString ="http://www.zillow.com/webservice/GetUpdatedPropertyDetails.htm?zws-id=X1-ZWz17gpdm3i87f_98wrk&zpid=" + zpid;
     URL url = new URL(urlString);
     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
     connection.setRequestMethod("GET");
     BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
     StringBuffer add = new StringBuffer();
     String line = read.readLine();
     while(line != null) {
       add.append(line);
       line = read.readLine();
     }
     read.close();
     retval = add.toString();
   } catch (Exception e) {
     System.out.println(e.getMessage());
   }
   return retval;
 }
 public String[] parse(String output) {
  JSONObject parse = new JSONObject(output);
  JSONArray arr = parse.getJSONArray("results");
  String[] houses = new String[arr.length()];
  for (int i = 0; i < houses.length; i++) {
    houses[i] = arr.getJSONObject(i).getString("formatted_address");
  }
  return houses;
  }
}
