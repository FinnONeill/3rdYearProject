package com.example.ian.applayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.SyncStateContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Finn on 06/03/2017.
 */

public class MenuGetter extends AsyncTask<String, String, String> {

    private final String mUsername;
    private final String mPassword;

    private HttpURLConnection conn;
    private URL url = null;

    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 15000;
    public static ArrayList<Item> menu;

    MenuGetter(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO: attempt authentication against a network service.

        try {
            //Setup HTTPURLConnection class to send & recieve from php & mysql.
            url = new URL("http://192.168.0.2/android/getItemList.php");

            conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setConnectTimeout(CONNECTION_TIMEOUT);
            conn.setRequestMethod("POST");

            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Append parameters to URL
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("username", mUsername)
                    .appendQueryParameter("password", mPassword);

            String query = builder.build().getEncodedQuery();

            //Open Connection for sending data
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            writer.write(query);
            writer.flush();

            writer.close();
            os.close();
            conn.connect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Exception: Malformed";
        }catch (IOException e){
            e.printStackTrace();
            return "Exception: IOException";
        }

        try{
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                //Read data from Server
                InputStream input = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;
                while((line = reader.readLine())!=null){
                    result.append(line);
                }
                return (result.toString());
            }else {
                return "Unsuccessful";
            }

        }catch (IOException e){
            e.printStackTrace();
            return "Exception: IOException 2";
        }finally {
            conn.disconnect();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Run this method on UI Thread
        menu = new ArrayList<Item>();

        try{
            JSONArray jArray = new JSONArray(result);
            for(int i=0; i<jArray.length(); i++){
                JSONObject jObject = jArray.getJSONObject(i);
                String name = jObject.get("item_name").toString();
                String catagory = jObject.get("item_name").toString();
                String description = jObject.get("item_name").toString();
                String price = jObject.get("item_name").toString();
                menu.add(new Item(name,catagory,description,price));
            }
            System.out.println(menu.get(0).toString());

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
