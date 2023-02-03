package com.svalero.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText camoNombre;
    TextView etiNombre;

    TextView estado;
    Spinner comboDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camoNombre = findViewById(R.id.txtNombre);
        etiNombre = findViewById(R.id.etiNombre);

        estado = findViewById(R.id.etiSeleccion);
        comboDias = findViewById(R.id.idSpinnerDias);

        ArrayList<String> comboDiasList = new ArrayList<>();
        comboDiasList.add("Seleccione un día");
        for (int i = 0; i < 10; i++) {
            comboDiasList.add("Dia " + i);
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, comboDiasList);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_dias, android.R.layout.simple_spinner_item);
        comboDias.setAdapter(adapter);
        comboDias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Seleccionado: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                estado.setText("Seleccionado: " + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "No se ha seleccionado nada", Toast.LENGTH_SHORT).show();
                estado.setText("No se ha seleccionado nada");
            }
        });
    }

    public void evento(View view){
        switch (view.getId()){
            case R.id.btnIngresar:
                String nombre = camoNombre.getText().toString();
                etiNombre.setText(nombre);
                Toast.makeText(this, "Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEnviar:
                Intent intent = new Intent(this, MensajeActivity.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("nombre", camoNombre.getText().toString());
                intent.putExtras(miBundle);
                startActivity(intent);
                break;
        }
    }
}