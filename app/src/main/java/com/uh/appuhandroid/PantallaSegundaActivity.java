package com.uh.appuhandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaSegundaActivity extends AppCompatActivity {

    TextView lblTituloSegundo;
    ImageView imgLogo;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_segunda);

        //match
        lblTituloSegundo = findViewById(R.id.lblTituloSegundo);
        imgLogo = findViewById(R.id.imgLogo);
        btnSalir = findViewById(R.id.btnSalir);

        Intent obtenerInformacion = getIntent();
        String nomUsuario = obtenerInformacion.getStringExtra("DATA");
        //lblTituloSegundo.setText("Hola " + nomUsuario);

        //obtener objeto serializable
        Persona personaObtenida = new Persona();
        //cast o casteo
        personaObtenida = (Persona) obtenerInformacion.getSerializableExtra("Persona");
        lblTituloSegundo.setText("Hola " + personaObtenida.nombre);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasarPantalla = new Intent(PantallaSegundaActivity.this, MainActivity.class);
                startActivity(pasarPantalla);
            }
        });
    }
}