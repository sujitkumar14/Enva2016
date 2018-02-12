package com.sujit.enva2016;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Rajkumar on 01-13-2016.
 */
public class Registration extends AppCompatActivity{

    final String url = "https://docs.google.com/forms/d/1ZjW6uD4GZ5mHqxo2Nndj4VpV1AUP3z-iOdCPl-sCIwE/viewform?c=0&w=1&usp=mail_form_link";
    WebView webView;
     int i=0;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registration);

        overridePendingTransition(R.anim.up_in, R.anim.up_out);
        toolbar = (Toolbar) findViewById(R.id.registrationToolbar);
        toolbar.setTitle("Registration");
        setSupportActionBar(toolbar);

       webView = (WebView) findViewById(R.id.register);

        webView.getSettings().setJavaScriptEnabled(true);


        new LoadUrl(webView).execute(url);



    }

    class LoadUrl extends AsyncTask<String,Integer,String>
    {
        WebView webView;
        LoadUrl(WebView webView)
        {
            this.webView = webView;
        }

        @Override
        protected String doInBackground(String... params) {

            return params[0];
        }




        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            webView.loadUrl(s);
            toolbar.setTitle("Registration");

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.down_in,R.anim.down_out);
    }
}
