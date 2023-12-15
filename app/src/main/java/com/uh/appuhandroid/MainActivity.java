package com.uh.appuhandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    TextView lblTitulo;
    EditText txtUsuario;
    EditText txtContrasena;
    Button btnIngresar;
    Button btnAcerca;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hacer match de la variables con su respectivo elemento de interfaz
        lblTitulo = findViewById(R.id.lblTitulo);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnAcerca = findViewById(R.id.btnAcerca);

        //animaciones iniciales
        YoYo.with(Techniques.FadeIn).duration(1000).repeat(3).playOn(lblTitulo);
        YoYo.with(Techniques.FadeIn).duration(1000).repeat(3).playOn(txtUsuario);
        YoYo.with(Techniques.FadeIn).duration(1000).repeat(3).playOn(txtContrasena);
        YoYo.with(Techniques.FadeIn).duration(1000).repeat(1).playOn(btnIngresar);
        YoYo.with(Techniques.FadeIn).duration(1000).repeat(1).playOn(btnAcerca);

        //Evento de click sobre botón ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"El botón funciona", Toast.LENGTH_LONG).show();

                //simular 2 variables de base de datos
                String usuarioDB= "Joharie";
                String contraDB="12345";

                //obtener valores de variables
                String usuario = txtUsuario.getText().toString();
                String contrasena = txtContrasena.getText().toString();

                if (usuario.equals(usuarioDB) && contrasena.equals(contraDB)){
                    //llevarlo a otra pantalla
                    Intent pasarPantalla = new Intent(MainActivity.this, PantallaSegundaActivity.class);
                    pasarPantalla.putExtra("DATA",usuario);

                    //declarar serializable
                    Persona persona1 = new Persona();
                    persona1.nombre = "Joel";
                    persona1.edad = 20;
                    persona1.identificacion = "4844545464";
                    persona1.residencia = "Puntarenas";

                    //enviar objeto a otro activity
                    pasarPantalla.putExtra("Persona", persona1);

                    startActivity(pasarPantalla);
                }else{
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Creado por Joharie Enriquez", Toast.LENGTH_LONG).show();
            }
        });
    }
}