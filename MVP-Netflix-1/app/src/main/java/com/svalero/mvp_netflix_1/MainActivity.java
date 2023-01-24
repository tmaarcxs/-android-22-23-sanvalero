package com.svalero.mvp_netflix_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.svalero.mvp_netflix_1.view.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Handler handler = new Handler();
        //SetTimeOut es una función que se ejecuta después de un tiempo
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Aquí se ejecuta el código que queremos que se ejecute después de 3 segundos
                Intent screenChanger = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(screenChanger);
                //finish();
            }
        }, 3000);
    }
}