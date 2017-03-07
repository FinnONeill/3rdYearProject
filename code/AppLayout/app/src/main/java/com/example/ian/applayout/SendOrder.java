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

    private HttpURLConnection conn;
    private URL url = null;
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 15000;

    private String username,password,orderNumber,orderDetails,orderPrice;

    public SendOrder(String username, String password, String orderNumber, String orderDetails, String orderPrice){
        this.username = username;
        this.password = password;
        this.orderNumber = orderNumber;
        this.orderDetails = orderDetails;
        this.orderPrice = orderPrice;
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
            url = new URL("http://order66.finnianoneill.ie/android/recieve_order.php");

            conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setConnectTimeout(CONNECTION_TIMEOUT);
            conn.setRequestMethod("POST");

            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Append parameters to URL
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("username", username)
                    .appendQueryParameter("password", password)
                    .appendQueryParameter("order_number", orderNumber)
                    .appendQueryParameter("order_details",orderDetails)
                    .appendQueryParameter("order_price", orderPrice);

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
    protected void onProgressUpdate(String... almostResult){
        System.out.println("DETAILS "+username+" "+password+" "+orderNumber+" "+orderDetails+" "+orderPrice);
    }

    @Override
    protected void onPostExecute(String result) {
        //Run this method on UI Thread
        System.out.println("DETAILS "+username+" "+password+" "+orderNumber+" "+orderDetails+" "+orderPrice);
        System.out.println(result);
        if (result.equalsIgnoreCase("1")) {
            //Order Sent
        } else if(result.equalsIgnoreCase("0")){
            //If username & password don't match, display error message.
            //Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_LONG).show();
        }else if(result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")){
            //Toast.makeText(LoginActivity.this, "Oops! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();
        }
    }
}