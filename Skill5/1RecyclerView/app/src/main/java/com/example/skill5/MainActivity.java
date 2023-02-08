package com.example.skill5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listDatos;
    RecyclerView recycler;

    ArrayList<PersonajeVo> listaPersonajes;
    RecyclerView recyclerPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        //3 columnas
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listDatos = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listDatos.add("Dato: " + i);
        }
        AdapterDatos adapter = new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);


        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = (RecyclerView) findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        llenarPersonajes();

        AdaptadorPersonajes adapterPersonajes = new AdaptadorPersonajes(listaPersonajes);
        recyclerPersonajes.setAdapter(adapterPersonajes);
    }

    private void llenarPersonajes() {
        listaPersonajes.add(new PersonajeVo("Goku", "Saiyajin", R.drawable.goku));
        listaPersonajes.add(new PersonajeVo("Vegeta", "Saiyajin", R.drawable.vegeta));
        listaPersonajes.add(new PersonajeVo("Gohan", "Saiyajin", R.drawable.gohan));
        listaPersonajes.add(new PersonajeVo("Piccolo", "Namekusei", R.drawable.piccolo));
        listaPersonajes.add(new PersonajeVo("Krillin", "Humano", R.drawable.krillin));
        listaPersonajes.add(new PersonajeVo("Yamcha", "Humano", R.drawable.yamcha));
        listaPersonajes.add(new PersonajeVo("Tenshinhan", "Humano", R.drawable.tenshinhan));
        listaPersonajes.add(new PersonajeVo("Chaozu", "Humano", R.drawable.chaozu));
        listaPersonajes.add(new PersonajeVo("Bulma", "Humano", R.drawable.bulma));
        listaPersonajes.add(new PersonajeVo("Videl", "Humano", R.drawable.videl));
        listaPersonajes.add(new PersonajeVo("Trunks", "Saiyajin", R.drawable.trunks));
        listaPersonajes.add(new PersonajeVo("Goten", "Saiyajin", R.drawable.goten));
        listaPersonajes.add(new PersonajeVo("Majin Boo", "Majin", R.drawable.majinboo));
    }

}