package com.example.registro_ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.registro_vehicular.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtId, txtNombre, txtLatitud, txtLongitud, txtPoblacion;
    private TextView txtResultado;
    private Button btnAdd;
    private Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);
        txtPoblacion= findViewById(R.id.txtPoblacion);
        txtResultado = findViewById(R.id.txtResultado);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                MyDbHelper db = new MyDbHelper(this);
                ArrayList<Ciudades>ciu = db.selectCiudad(db.getWritableDatabase());
                int editarId = Integer.parseInt(txtId.getText().toString());
                String editarNombre = txtNombre.getText().toString();
                int editarLatitud = Integer.parseInt(txtLatitud.getText().toString());
                int editarLongitud = Integer.parseInt(txtLongitud.getText().toString());
                int editarPoblacion = Integer.parseInt(txtPoblacion.getText().toString());
                Ciudades ciudades = new Ciudades(editarId,editarNombre,editarLatitud,editarLongitud,editarPoblacion);
                ciu.add(ciudades);
                db.InsertCiudad(db.getWritableDatabase(),ciudades);
                limpiarCampos();
                txtResultado.setText(ciu.toString());

                break;
                case R.id.btnMostrar:
        }
    }
    private void agregarCiudades(){
        int editarId = Integer.parseInt(txtId.getText().toString());
        String editarNombre = txtNombre.getText().toString();
        int editarLatitud = Integer.parseInt(txtLatitud.getText().toString());
        int editarLongitud = Integer.parseInt(txtLongitud.getText().toString());
        int editarPoblacion = Integer.parseInt(txtPoblacion.getText().toString());
        Ciudades ciudades = new Ciudades(editarId,editarNombre,editarLatitud,editarLongitud,editarPoblacion);
    }
    private void limpiarCampos(){
        txtId.getText().clear();
        txtNombre.getText().clear();
        txtLatitud.getText().clear();
        txtLongitud.getText().clear();
        txtPoblacion.getText().clear();
    }
}