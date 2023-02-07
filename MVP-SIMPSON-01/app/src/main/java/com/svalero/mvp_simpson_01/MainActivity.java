package com.svalero.mvp_simpson_01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.mvp_simpson_01.lst_simpson.view.LstSimpsonActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        // SetTimeOut - setInterval
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent screenChanger = new Intent(getBaseContext(),
                        LstSimpsonActivity.class
                );
                startActivity(screenChanger);
            }
        }, 4000);
    }
}