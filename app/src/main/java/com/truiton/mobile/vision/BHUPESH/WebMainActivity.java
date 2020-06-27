package com.truiton.mobile.vision.BHUPESH;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class WebMainActivity extends AppCompatActivity {
    private URL url;
    private WebView winw;
    private Button backb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String u = getIntent().getExtras().getString("url");
        try {
            url = new URL("https://192.168.43.70:5000/" +u);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Toast.makeText(WebMainActivity.this, "Cant convert to url", Toast.LENGTH_SHORT).show();
        }
        setContentView(R.layout.activity_web_main);
        winw = findViewById(R.id.ResultsDisplay);
        backb = findViewById(R.id.back);
        winw.getSettings().setJavaScriptEnabled(true);
        winw.loadUrl(String.valueOf(url));
        backb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(WebMainActivity.this, u, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        Button google = findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    url = new URL("https://www.google.com/search?query=" +u);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Toast.makeText(WebMainActivity.this, "Cant convert to url", Toast.LENGTH_SHORT).show();
                }
                winw.loadUrl(String.valueOf(url));
            }
        });

    }
}
