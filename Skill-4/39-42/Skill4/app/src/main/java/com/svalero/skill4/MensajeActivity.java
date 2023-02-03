package com.svalero.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MensajeActivity extends AppCompatActivity {
    TextView msj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        msj = findViewById(R.id.txtNombreMensaje);
        Bundle miBundle = getIntent().getExtras();

        if (miBundle != null) {
            msj.setText("Bienvenido " + miBundle.getString("nombre"));
        }
    }

    public void onclick(View view){
        finish();
    }
}