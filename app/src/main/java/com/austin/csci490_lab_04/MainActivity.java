package com.austin.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("String: ",returnString("https://www.google.com"));

    }

    private String returnString(String s){

        String string = "";

        try {
            URL url = new URL(s);
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

}
