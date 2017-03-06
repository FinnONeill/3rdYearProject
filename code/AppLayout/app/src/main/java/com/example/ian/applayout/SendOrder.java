package com.example.ian.applayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by Finn on 04/03/2017.
 */

public class SendOrder extends AsyncTask<String, String, String> {

    private final Order order;

    private HttpURLConnection conn;
    private URL url = null;
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 15000;

    SendOrder(Order order) {
        this.order = order;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO: attempt authentication against a network service.

        try {
            //Setup HTTPURLConnection class to send & recieve from php & mysql.
            url = new URL("http://192.168.0.2/android/login_android.php");

            conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setConnectTimeout(CONNECTION_TIMEOUT);
            conn.setRequestMethod("POST");

            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Append parameters to URL
            Uri.Builder builder = new Uri.Builder().appendQueryParameter("order", order.toString());

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

        if (result.equalsIgnoreCase("1")) {
            //Intent nextActivity = new Intent(LoginActivity.this, RoleActivity.class);
            //startActivity(nextActivity);
            //LoginActivity.this.finish();
            //Toast.makeText(LoginActivity.this, "Successful Login!", Toast.LENGTH_LONG).show();
        } else if(result.equalsIgnoreCase("0")){
            //If username & password don't match, display error message.
            //Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_LONG).show();
        }else if(result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")){
            //Toast.makeText(LoginActivity.this, "Oops! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();
        }
    }
}