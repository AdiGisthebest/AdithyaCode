import java.net.*;
import java.io.File;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.LinkedList;
import org.json.*;
import org.apache.commons.io.IOUtils;
import java.util.concurrent.TimeUnit;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ListIterator;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class Getdata {
    LinkedList<String> filterHome =  new LinkedList<>();
    String username;
    public LinkedList<String> read(String baths, String beds, String username, String price, String minprice, String year, String city, String state) {
        LinkedList<String> addressList = new LinkedList<>();
        String projurl;
        String params;
        int num = 7;
        try {
            projurl = "https://www.parsehub.com/api/v2/projects/tkfRX3G5O4TF/run";
            params = "api_key=tkgYeW-gNUAi&start_url=" + URLEncoder.encode("https://homefinder.com/for-sale/"+state+ "/"+city+"?maxPrice="+price+"&beds="+beds+"&baths="+baths+"&propertyTypes=SFH",StandardCharsets.UTF_8);
            byte[] postData = params.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            URL url = new URL(projurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            try( DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }
            String str = IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8);
            System.out.println(str + "llllllllllllllllllllllllllllllllllllll");
            JSONObject obj = new JSONObject(str);
            String runToken = obj.getString("run_token");
            projurl = "https://www.parsehub.com/api/v2/runs/" + runToken + "?api_key=tkgYeW-gNUAi";
            String stat = "";
            connection.disconnect();
            while (!stat.equals("complete")) {
                url = new URL(projurl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");
                str = IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8);
                JSONObject status = new JSONObject(str);
                stat = status.getString("status");
                System.out.println(stat + runToken);
                connection.disconnect();
                TimeUnit.SECONDS.sleep(3);
            }
            projurl = "https://www.parsehub.com/api/v2/runs/" + runToken + "/data?api_key=tkgYeW-gNUAi";
            url = new URL(projurl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept-Encoding", "gzip");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "text/plain,charset=UTF-8");
            connection.connect();
            InputStreamReader reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()));
            BufferedReader read = new BufferedReader(reader);
            StringBuffer add = new StringBuffer();
            String line = read.readLine();
            while (line != null) {
                add.append(line);
                line = read.readLine();
            }
            read.close();
            str = add.toString();
            System.out.println(str);
            JSONObject res = new JSONObject(str);
            JSONArray arr = res.getJSONArray("selection1");
            num = Integer.parseInt(arr.getJSONObject(arr.length() - 2).getString("name"));
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int k = 1; k <= num; k++) {
            boolean breakbool = false;
            try {
                if(k == 1) {
                    projurl = "https://www.parsehub.com/api/v2/projects/teOFUzvTOKdo/run";
                    params = "api_key=tkgYeW-gNUAi&start_url=" + URLEncoder.encode("https://homefinder.com/for-sale/"+state+ "/"+city+"?maxPrice="+price+"&beds="+beds+"&baths="+baths+"&propertyTypes=SFH",StandardCharsets.UTF_8);
                } else {
                    projurl = "https://www.parsehub.com/api/v2/projects/teOFUzvTOKdo/run";
                    params = "api_key=tkgYeW-gNUAi&start_url=" + URLEncoder.encode("https://homefinder.com/for-sale/"+state+ "/"+city+"?maxPrice="+price+"&beds="+beds+"&baths="+baths+"&propertyTypes=SFH&page=" + k,StandardCharsets.UTF_8);
                }
                byte[] postData = params.getBytes(StandardCharsets.UTF_8);
                int postDataLength = postData.length;
                URL url = new URL(projurl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("charset", "utf-8");
                connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
                try( DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                    wr.write(postData);
                }
                String str = IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8);
                System.out.println(str + "llllllllllllllllllllllllllllllllllllll");
                JSONObject obj = new JSONObject(str);
                String runToken = obj.getString("run_token");
                projurl = "https://www.parsehub.com/api/v2/runs/" + runToken + "?api_key=tkgYeW-gNUAi";
                String stat = "";
                connection.disconnect();
                while (!stat.equals("complete")) {
                    url = new URL(projurl);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Content-Type", "application/json");
                    str = IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8);
                    JSONObject status = new JSONObject(str);
                    stat = status.getString("status");
                    System.out.println(stat + runToken);
                    connection.disconnect();
                    TimeUnit.SECONDS.sleep(3);
                }
                projurl = "https://www.parsehub.com/api/v2/runs/" + runToken + "/data?api_key=tkgYeW-gNUAi";
                url = new URL(projurl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Accept-Encoding", "gzip");
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "text/plain,charset=UTF-8");
                connection.connect();
                InputStreamReader reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()));
                BufferedReader read = new BufferedReader(reader);
                StringBuffer add = new StringBuffer();
                String line = read.readLine();
                while (line != null) {
                    add.append(line);
                    line = read.readLine();
                }
                read.close();
                str = add.toString();
                System.out.println(str);
                JSONObject res = new JSONObject(str);
                JSONArray JArr = res.getJSONArray("homes");
                for (int i = 0; i < JArr.length(); i++) {
                    String[] arr = JArr.getJSONObject(i).getString("home").split("\n");
                    String homeStr = arr[0] + arr[1];
                    addressList.add(homeStr);
                    System.out.println(homeStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(breakbool) {
                break;
            }
        }
        return addressList;
    }
    public void filter(ListIterator<String> iter) {
        while(iter.hasNext()) {
            String address = iter.next();
            try {
                String[] concat = address.split(" ");
                StringBuilder build = new StringBuilder();
                for (int i = 0; i < concat.length - 1; i++) {
                    build.append(concat[i] + "+");
                }
                build.append(concat[concat.length - 1]);
                //System.out.println(build.toString());
                String projurl = "http://www.zillow.com/webservice/GetSearchResults.htm?zws-id=X1-ZWz17iezcu3wgb_5cfwc&address=" + build.toString() + "&citystatezip=" + concat[concat.length - 1] + "&rentzestimate=true";
                URL url = new URL(projurl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                DocumentBuilderFactory dbc = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbc.newDocumentBuilder();
                Document doc = db.parse(connection.getInputStream());
                doc.getDocumentElement().normalize();
                Element elem = doc.getDocumentElement();
                if (!((Element) elem.getElementsByTagName("message").item(0)).getElementsByTagName("text").item(0).getTextContent().equals("Request successfully processed")) {
                    //System.out.println("FAILED");
                    System.out.println(((Element) elem.getElementsByTagName("message").item(0)).getElementsByTagName("text").item(0).getTextContent());
                } else {
                    int zest = Integer.parseInt(((Element) ((Element) ((Element) ((Element) elem.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").item(0)).getElementsByTagName("zestimate").item(0)).getElementsByTagName("amount").item(0).getTextContent());
                    int rentzest = Integer.parseInt(((Element) ((Element) ((Element) ((Element) elem.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").item(0)).getElementsByTagName("rentzestimate").item(0)).getElementsByTagName("amount").item(0).getTextContent());
                    System.out.println(address + " SUCCESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
                    if (rentzest > 0.0075 * zest) {
                        System.out.println("helloOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO \n ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
                        filterHome.add(address);
                    }
                }
            } catch (Exception e) {
                System.out.println(address);
            }
        }
    }
    public void filter2() {
        System.out.println("worked");
    }
    public static void main(String[] args) {
        System.out.println("Started");
        File file = new File("file1.json");
        Scanner scan = null;
        Getdata get = new Getdata();
        try {
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder build = new StringBuilder();
        while(scan.hasNext()) {
            build.append(scan.nextLine());
        }
        String JString = build.toString();
        JSONArray jarray = new JSONArray(JString);
        for(int i = 0; i < jarray.length(); i++) {
            System.out.println(jarray.length());
            JSONObject jobj = jarray.getJSONObject(i);
            //String username  = jobj.getString("username");
            get.filter2();
            File jFile = new File("file2.json");
            Scanner scanner = null;
            try {
                scanner = new Scanner(jFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StringBuilder builder = new StringBuilder();
            while(scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
            String JSONString = builder.toString();
            JSONArray arr = new JSONArray(JSONString);
            JSONArray jarr = null;
            for(int j = 0; j < arr.length(); j++) {
                try {
                    jarr = arr.getJSONObject(j).getJSONArray(username);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(jarr == null) {
                JSONObject newUser = new JSONObject();
                JSONArray newHomeArr = new JSONArray();
                newUser.put(username,newHomeArr);
                arr.put(newUser);
                jarr = newHomeArr;
            }
            JSONArray jsonArr = new JSONArray();
            ListIterator iter = get.filterHome.listIterator();
            while(iter.hasNext()) {
                jsonArr.put(iter.next());
            }
            while (jarr.length() >= 7) {
                jarr.remove(0);
            }
            jarr.put(jsonArr);
            System.out.println(get.filterHome);
            FileWriter writer = null;
            try {
                writer = new FileWriter(jFile);
            } catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println(arr.toString());
            try {
                writer.write(arr.toString());
                writer.flush();
                writer.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}