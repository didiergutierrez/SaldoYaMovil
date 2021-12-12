package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrarEmpleado extends AppCompatActivity {

    private String nombre="", documento="", correo="", telefono="", contraseña="", ccontraseña="";
    private TextInputEditText tie_nombre, tie_documento, tie_correo, tie_telefono, tie_contraseña, tie_ccontraseña;
    private Button b_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empleado);

        //Obtener la intensión de la otra vista
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            nombre =bundle.getString("nombre");
            documento =bundle.getString("documento");
            telefono =bundle.getString("telefono");
            correo =bundle.getString("correo");
            contraseña = bundle.getString("contraseña");
            ccontraseña = bundle.getString("ccontraseña");
        }

        //Tomamos los datos
        tie_nombre= findViewById(R.id.tie_nombre);
        tie_documento= findViewById(R.id.tie_documento);
        tie_correo= findViewById(R.id.tie_correo);
        tie_telefono= findViewById(R.id.tie_telefono);
        tie_contraseña= findViewById(R.id.tie_contraseña);
        tie_ccontraseña= findViewById(R.id.tie_ccontraseña);
        b_registrar= findViewById(R.id.b_registrar);

        //Visualizar los textos(modificar)
        tie_nombre.setText(nombre);
        tie_documento.setText(documento);
        tie_telefono.setText(telefono);
        tie_correo.setText(correo);
        tie_contraseña.setText(contraseña);
        tie_ccontraseña.setText(ccontraseña);

        b_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtener el texto que ingresaron
                nombre= tie_nombre.getText().toString();
                documento= tie_documento.getText().toString();
                telefono= tie_telefono.getText().toString();
                correo= tie_correo.getText().toString();
                contraseña= tie_contraseña.getText().toString();
                ccontraseña= tie_ccontraseña.getText().toString();

                if (!contraseña.equals("") && !ccontraseña.equals("")){

                    Toast.makeText(RegistrarEmpleado.this, "Empleado registrado.", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(RegistrarEmpleado.this, "La contraseña no puede estar vacía.", Toast.LENGTH_LONG).show();
                }

                Intent intent=new Intent(RegistrarEmpleado.this,Editar.class);
                //Se carga la intensión(dato)
                intent.putExtra("nombre",nombre);
                intent.putExtra("documento",documento);
                intent.putExtra("telefono",telefono);
                intent.putExtra("correo",correo);
                intent.putExtra("contraseña", contraseña);
                intent.putExtra("ccontraseña", ccontraseña);
                startActivity(intent);

            }
        });


    }
}