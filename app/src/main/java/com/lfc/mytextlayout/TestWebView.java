package com.lfc.mytextlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class TestWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web_view);
        WebView webView = (WebView) this.findViewById(R.id.webView);
        webView.loadUrl("https://github.com/iamlfc");
    }
}
