package com.grademojo.volley2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnJson, btnString, btnImage;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnImage = (Button) findViewById(R.id.btnImageRequest);
        btnJson = (Button) findViewById(R.id.btnJsonRequest);
        btnString = (Button) findViewById(R.id.btnStringRequest);



        btnImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, ImageRequestActivity.class);
                startActivity(i);
            }
        });

        btnString.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, StringRequestActivity.class);
                startActivity(i);
            }
        });

        btnJson.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, JsonRequestActivity.class);
                startActivity(i);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        //  this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}


