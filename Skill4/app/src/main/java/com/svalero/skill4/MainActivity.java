package com.svalero.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView etiqueta;
    EditText campo1, campo2, campo3;
    CheckBox c1, c2;
    RadioButton r1, r2;
    ToggleButton tgbtn;
    EditText txteti;

    Switch switche;

    private static final String TAG = "seguimiento";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etiqueta = findViewById(R.id.eti1);
        campo1 = findViewById(R.id.txt1);
        campo2 = findViewById(R.id.txt2);
        campo3 = findViewById(R.id.txt3);

        c1 = findViewById(R.id.idChec1);
        c2 = findViewById(R.id.idChec2);

        r1 = findViewById(R.id.idRadio1);
        r2 = findViewById(R.id.idRadio2);

        tgbtn = findViewById(R.id.tgBtn1);
        txteti = findViewById(R.id.etiSeleccion);

        switche = findViewById(R.id.idSwitch);

        Log.i("info", "Valor informacion");
        Log.d("debug", "Valor debug");
        Log.w("warning", "Valor warning");
        Log.e("error", "Valor error");
        Log.v("verbose", "Valor verbose");

        Log.i(TAG, "Mensaje de seguimiento 1");
        Log.i(TAG, "Mensaje de seguimiento 2");
        Log.i(TAG, "Mensaje de seguimiento 3");
        Log.i(TAG, "Mensaje de seguimiento 4");
        Log.i(TAG, "Mensaje de seguimiento 5");
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                obtenerInfo();
                validar();
                validarRadio();
                break;
        }

        if (view.getId() == R.id.tgBtn1){
            if (tgbtn.isChecked()){
                txteti.setText("ON");
            }else{
                txteti.setText("OFF");
            }
        }

        if (view.getId() == R.id.idSwitch){
            if (switche.isChecked()){
                Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void validarRadio() {
        String cad = "Se ha seleccionado: ";
        if (r1.isChecked()){
            cad += " " + r1.getText().toString();
        }
        if (r2.isChecked()){
            cad += " " + r2.getText().toString();
        }
        Toast.makeText(this, cad, Toast.LENGTH_SHORT).show();
    }

    private void validar() {
        String cad = "Se ha seleccionado: ";
        if (c1.isChecked()){
            cad += " " + c1.getText().toString();
        }
        if (c2.isChecked()){
            cad += " " + c2.getText().toString();
        }
        Toast.makeText(this, cad, Toast.LENGTH_SHORT).show();
    }

    private void obtenerInfo() {
        int numero= Integer.parseInt(campo1.getText().toString());
        String password= campo2.getText().toString();
        String parrafo= campo3.getText().toString();
        etiqueta.setText("Numero: " + numero + " Password: " + password + " Parrafo: " + parrafo);
        Toast.makeText(this, "Numero: " + numero + " Password: " + password + " Parrafo: " + parrafo, Toast.LENGTH_SHORT).show();
    }
}