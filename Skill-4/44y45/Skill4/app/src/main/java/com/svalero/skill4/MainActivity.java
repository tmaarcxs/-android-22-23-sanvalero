package com.svalero.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listaDias;
    TextView etiSeleccion;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDias = findViewById(R.id.txtId);
        etiSeleccion = (TextView) findViewById(R.id.txtId);
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrayDias, android.R.layout.simple_list_item_1);
        listaDias.setAdapter(adapter);
        listaDias.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Has seleccionado el día " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        });*/
        ArrayList <String> ListaNombres = new ArrayList<>();
        ListaNombres.add("Cristian");
        ListaNombres.add("Sergio");
        ListaNombres.add("Javier");
        ListaNombres.add("Jorge");

        for(int i = 0; i < 10; i++){
            ListaNombres.add("Nombre " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListaNombres);
        listaDias.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(this, "Has seleccionado el día " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        etiSeleccion.setText("Has seleccionado el día " + parent.getItemAtPosition(position));
    }
}