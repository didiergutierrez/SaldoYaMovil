package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrarSaldo extends AppCompatActivity {

    private String idtienda="", documento="", saldo="";
    private TextInputEditText tie_idtienda, tie_documento, tie_saldo;
    private Button b_guardarSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_saldo);

        //Obtener la intensión de la otra vista
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            idtienda =bundle.getString("idtienda");
            documento =bundle.getString("documento");
            saldo =bundle.getString("saldo");
        }

        tie_idtienda= findViewById(R.id.tie_idtienda);
        tie_documento= findViewById(R.id.tie_documento);
        tie_saldo= findViewById(R.id.tie_saldo);
        b_guardarSaldo= findViewById(R.id.b_guardarSaldo);

        tie_idtienda.setText(idtienda);
        tie_documento.setText(documento);
        tie_saldo.setText(saldo);

        b_guardarSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(RegistrarSaldo.this, "Saldo Registrado.", Toast.LENGTH_LONG).show();

                //Obtener el texto que ingresaron
                idtienda= tie_idtienda.getText().toString();
                documento= tie_documento.getText().toString();
                saldo= tie_saldo.getText().toString();

                Intent intent=new Intent(RegistrarSaldo.this,Editar.class);
                //Se carga la intensión(dato)
                intent.putExtra("idtienda",idtienda);
                intent.putExtra("documento",documento);
                intent.putExtra("saldo",saldo);
                startActivity(intent);
            }
        });
    }
}