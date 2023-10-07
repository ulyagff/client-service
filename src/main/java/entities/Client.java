package entities;

import exceptions.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
    public static String Get(String key) throws IOException, BadResponseException, ParseException {
        URL obj = new URL("http://app:8080/keys/" + key);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			Object json = new JSONParser().parse(response.toString());

			// typecasting obj to JSONObject
			JSONObject jo = (JSONObject) json;

			// getting firstName and lastName
			String value = (String) jo.get("value");
			return value;
		} else {
			throw new BadResponseException("Responce code is " + responseCode);
		}
    }
    
    public static void Set(String key, String value) throws IOException, BadResponseException {
        URL obj = new URL("http://app:8080/keys/" + key + "?value=" + value);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("PUT");
		int responseCode = con.getResponseCode();

		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} else {
			throw new BadResponseException("Responce code is " + responseCode);
		}
    }
}
