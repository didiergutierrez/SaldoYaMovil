package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Inicio extends AppCompatActivity {

    String nombre="", tdocumento="", telefono="", email="";
    TextInputEditText tie_nombre, tie_tdocumento, tie_telefono, tie_email;
    Button b_editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Obtener la intensión de la otra vista
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            nombre =bundle.getString("nombre");
            tdocumento =bundle.getString("tdocumento");
            telefono =bundle.getString("telefono");
            email =bundle.getString("email");
        }

        //Toma los datos
        tie_nombre = findViewById(R.id.tie_nombre);
        tie_tdocumento = findViewById(R.id.tie_tdocumento);
        tie_telefono=findViewById(R.id.tie_telefono);
        tie_email=findViewById(R.id.tie_email);
        b_editar=findViewById(R.id.b_editar);

        //Visualizar los textos(modificar)
        tie_nombre.setText(nombre);
        tie_tdocumento.setText(tdocumento);
        tie_telefono.setText(telefono);
        tie_email.setText(email);

        b_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtener el texto que ingresaron
                nombre= tie_nombre.getText().toString();
                tdocumento= tie_tdocumento.getText().toString();
                telefono= tie_telefono.getText().toString();
                email= tie_email.getText().toString();

                Intent intent=new Intent(Inicio.this,Editar.class);
                //Se carga la intensión(dato)
                intent.putExtra("nombre",nombre);
                intent.putExtra("tdocumento",tdocumento);
                intent.putExtra("telefono",telefono);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
    }
}