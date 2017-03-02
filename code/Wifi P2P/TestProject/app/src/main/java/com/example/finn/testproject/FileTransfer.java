package com.example.finn.testproject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Finn on 02/03/2017.
 */

public class FileTransfer extends AsyncTask {

    private Context mContext;

    public FileTransfer(Context mContext){
        this.mContext = mContext;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try{
            /**
             * Create a server socket and wait for client connections. This
             * call blocks until a connection is accepted from a client
             */
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket client = serverSocket.accept();

            /**
             * If this code is reached, a client has connected and transferred data
             * Save the input stream from the client as a JPEG file
             */

            InputStream inputStream = client.getInputStream();
           
            serverSocket.close();

            return null;
        }catch (IOException e){
            Log.e(MainActivity.TAG, e.getMessage());
            return null;
        }
    }
}
