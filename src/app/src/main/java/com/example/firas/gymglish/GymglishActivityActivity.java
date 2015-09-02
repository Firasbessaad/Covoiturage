package com.example.firas.gymglish;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class GymglishActivityActivity extends ActionBarActivity {
ProgressBar progress ;
WebView mWebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gymglish_activity);
        progress =(ProgressBar) findViewById(R.id.progressBar);
        mWebview =  (WebView) findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true);



        mWebview.setWebViewClient(new SpecificWebClient());

        mWebview .loadUrl("http://www.gymglish.com ");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gymglish, menu);
        return true;
    }

    //la fonction qui charge le webview et le progressBar
    public void Serfing(String url){
        setContentView(R.layout.gymglish_activity);
        progress =(ProgressBar) findViewById(R.id.progressBar);
        mWebview =  (WebView) findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript



        mWebview.setWebViewClient(new SpecificWebClient());




        mWebview .loadUrl(url);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        switch (id) {
            case R.id.gymglish:
                Serfing("http://www.gymglish.com");
                return true;
            case R.id.frantastique:
                Serfing("http://www.frantastique.com");
                return true;
            case R.id.vatefaireconjuguer:
                Serfing("http://www.vatefaireconjuguer.com");
                return true;

        }




        return super.onOptionsItemSelected(item);
    }
    public class SpecificWebClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            progress.setVisibility(view.GONE);

            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {


            super.onPageStarted(view, url, favicon);
        }
    }


}
