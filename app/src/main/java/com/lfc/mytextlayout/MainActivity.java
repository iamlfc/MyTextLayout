package com.lfc.mytextlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lfc.mytextlayout.view.SlidingLayout;

public class MainActivity extends AppCompatActivity {

    private com.lfc.mytextlayout.view.SlidingLayout activityMain;
    private Button btnScrollow;
    private Button btnWeb;
    private Button btnRlv;
    private Activity baseContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseContext = this;
        initView();
    }

    private void initView() {
        activityMain = (SlidingLayout) findViewById(R.id.activity_main);
        btnScrollow = (Button) findViewById(R.id.btn_scrollow);
        btnWeb = (Button) findViewById(R.id.btn_web);
        btnRlv = (Button) findViewById(R.id.btn_rlv);
        btnScrollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(baseContext, TestScrollowView.class));
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(baseContext, TestWebView.class));

            }
        });
        btnRlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(baseContext, TestRecyclerView.class));

            }
        });
    }
}
