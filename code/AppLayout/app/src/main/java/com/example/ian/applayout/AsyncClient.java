package com.example.ian.applayout;

import android.os.AsyncTask;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Finn on 06/03/2017.
 */

public class AsyncClient extends AsyncTask<String, String, Socket>{
    private Socket s;
    private PrintWriter pw;
    private BufferedReader br;

    private int PORT = 7777;
    private String HOST = "192.168.0.2";

    private static String msg;
    private boolean loggedIn = false;

    @Override
    protected Socket doInBackground(String... params) {

        try {
            loggedIn = true;
            s = new Socket(HOST,PORT);
            pw = new PrintWriter(s.getOutputStream(),true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            pw.println(params[0]);
            pw.flush();

            String incomingOrder;
            while((incomingOrder = br.readLine()) != null){
               msg = msg + incomingOrder;
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return s;
    }

    @Override
    protected void onPostExecute(Socket message){
        System.out.println("In post exec");
        System.out.println(msg);
        System.out.println("In post End");
    }

    public void sendMessage(String order){
        System.out.println("send message start");

        System.out.println("send message finish");
    }

    public boolean logout(){
        try{
            loggedIn = false;
            pw.close();
            br.close();
            s.close();
            System.out.println("Logged in: "+loggedIn +"\nSocket status: "+s.isConnected());
        }catch (IOException e){
            e.printStackTrace();
        }
        return !loggedIn;
    }
}
