package com.austin.csci490_lab_04;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class AsinkTask extends AsyncTask<String, Void, String> {

    private TextView text;

    public AsinkTask (TextView textView){
        this.text = textView;
    }

    @Override
    protected String doInBackground(String... strings){

        String string = "";

        try {
            URL url = new URL(strings[0]);
            URLConnection connection = url.openConnection();

            InputStreamReader inputStreamReader = new InputStreamReader((connection.getInputStream()));

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            if(bufferedReader.readLine() != null){
                string += bufferedReader.readLine();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return string;
    }

    @Override
    protected void onPostExecute(String s){

        super.onPostExecute(s);
        text.setText(s.substring(10,24));

    }

}
