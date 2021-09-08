//package Usaco2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Api {
    public static void main(String[] args) {
        try {
            String data  = "Name=Akki";
            String type = "application/x-www-form-urlencoded";
            URL u = new URL("https://psyched-bonfire-317319.uc.r.appspot.com/putApi");
            Map<String,String> arguments = new HashMap<>();
            arguments.put("username", "root");
            arguments.put("password", "sjh76HSn!"); // This is a fake password obviously
            StringJoiner sj = new StringJoiner("&");
            for(Map.Entry<String,String> entry : arguments.entrySet())
                sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                        + URLEncoder.encode(entry.getValue(), "UTF-8"));
            byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            String encodedData = URLEncoder.encode( data, "UTF-8" );
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty( "Content-Type", type );
            conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
            conn.setFixedLengthStreamingMode(length);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.connect();
            try(OutputStream os = conn.getOutputStream()) {
                os.write(out);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            System.out.println(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
