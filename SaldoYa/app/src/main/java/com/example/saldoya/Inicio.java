package com.example.saldoya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Inicio extends AppCompatActivity {

    private String nombre="", tdocumento="", telefono="", email="", saldo="";
    private TextInputEditText tie_nombre, tie_tdocumento, tie_telefono, tie_email, tie_saldo;
    Button b_historial;

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
            saldo =bundle.getString("saldo");
        }

        //Toma los datos
        tie_nombre = findViewById(R.id.tie_nombre);
        tie_tdocumento = findViewById(R.id.tie_tdocumento);
        tie_telefono=findViewById(R.id.tie_telefono);
        tie_email=findViewById(R.id.tie_email);
        tie_saldo=findViewById(R.id.tie_saldo);
        b_historial=findViewById(R.id.b_historial);

        //Visualizar los textos(modificar)
        tie_nombre.setText(nombre);
        tie_tdocumento.setText(tdocumento);
        tie_telefono.setText(telefono);
        tie_email.setText(email);
        tie_saldo.setText(saldo);

        //b_editar.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {

        //        //Obtener el texto que ingresaron
        //        nombre= tie_nombre.getText().toString();
        //        tdocumento= tie_tdocumento.getText().toString();
        //        telefono= tie_telefono.getText().toString();
        //        email= tie_email.getText().toString();

        //        Intent intent=new Intent(Inicio.this,Editar.class);
        //        //Se carga la intensión(dato)
        //        intent.putExtra("nombre",nombre);
        //        intent.putExtra("tdocumento",tdocumento);
        //        intent.putExtra("telefono",telefono);
        //        intent.putExtra("email",email);
        //        startActivity(intent);
        //    }
        //});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;
        switch (item.getItemId()){
            case R.id.informacion:
                Toast.makeText(this, "Información", Toast.LENGTH_LONG).show();
                return true;
            case R.id.contacto:
                intent= new Intent(this, Contactenos.class);
                startActivity(intent);
                return true;
            case R.id.configuracion:
                Toast.makeText(this, "Configuración", Toast.LENGTH_LONG).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}