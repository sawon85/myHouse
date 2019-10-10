package com.example.myhouse.Network;

import android.content.Context;
import android.os.AsyncTask;

public class NetworkTask extends AsyncTask<Void, Void, String> {
    private Context context;
    private String url;
    private String data;

    @Override
    protected String doInBackground(Void... voids) {
        String result = null;

        try {
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            //result = requestHttpURLConnection.Request(url, data);

        }catch (Exception e){
            result = "Error";
        }

        return result;

    }
}
