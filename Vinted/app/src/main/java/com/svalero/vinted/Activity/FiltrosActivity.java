package com.svalero.vinted.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.vinted.Adapter.CategoriasAdapter;
import com.svalero.vinted.Controller;
import com.svalero.vinted.Model.Categoria;
import com.svalero.vinted.R;

import java.util.ArrayList;

import retrofit2.Response;

public class FiltrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_categorias);
        Controller api = new Controller();
        try {
            String response = api.callAPI("/categorias/");
            if (!response.equals("[]")) {
                ArrayList<Categoria> listaCategorias = Categoria.toArrayList(response);
                CategoriasAdapter adapter = new CategoriasAdapter(listaCategorias);
                //adapter.setOnClickListener(FiltrosActivity.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void onCategoriaClicked(Categoria categoria) {
        Intent intent = new Intent(this, ResultadoFiltroActivity.class);
        ArrayList<Categoria> categoriaArrayList = new ArrayList<>();
        categoriaArrayList.add(categoria);
        intent.putParcelableArrayListExtra("categoria", categoriaArrayList);
        startActivity(intent);
    }

}