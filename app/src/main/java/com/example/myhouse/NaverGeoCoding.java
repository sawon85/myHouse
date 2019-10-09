package com.example.myhouse;

import android.graphics.Point;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NaverGeoCoding {

    /*

    final static String naverGeocodingURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";

    public Point getWeather(String address){

        Point point = new Point();

        String urlString = naverGeocodingURL + address;



        try {

            // call API by using HTTPURLConnection

            URL url = new URL(urlString);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setConnectTimeout(1000);
            urlConnection.setReadTimeout(1000);


            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            JSONObject json = new JSONObject(getStringFromInputStream(in));



            // parse JSON

            w = parseJSON(json);

            w.setIon(lon);

            w.setLat(lat);



        }catch(MalformedURLException e){

            System.err.println("Malformed URL");

            e.printStackTrace();

            return null;



        }catch(JSONException e) {

            System.err.println("JSON parsing error");

            e.printStackTrace();

            return null;

        }catch(IOException e){

            System.err.println("URL Connection failed");

            e.printStackTrace();

            return null;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // set Weather Object



        return w;

    }



    private Weather parseJSON(JSONObject json) throws JSONException {

        Weather w = new Weather();

        w.setTemprature(json.getJSONObject("main").getInt("temp"));

        w.setCity(json.getString("name"));

        //w.setCloudy();



        return w;

    }



    private static String getStringFromInputStream(InputStream is) {



        BufferedReader br = null;

        StringBuilder sb = new StringBuilder();



        String line;

        try {



            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {

                sb.append(line);

            }



        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (br != null) {

                try {

                    br.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }



        return sb.toString();



    }
    */

}

