package com.svalero.skill2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();

        btn1 = findViewById(R.id.btnClaseAnonima);
        btn2 = findViewById(R.id.btnImplements);
        btn2.setOnClickListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Desde la clase anonima", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnImplements:
                Toast.makeText(getApplicationContext(), "Desde la clase implements", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnOnclick:
                Toast.makeText(getApplicationContext(), "Desde la clase implements 2", Toast.LENGTH_LONG).show();
                break;
        }
    }
}