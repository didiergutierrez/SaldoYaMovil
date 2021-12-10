package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpcionesReg extends AppCompatActivity {
    private Button b_RCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_reg);

        b_RCliente=findViewById(R.id.b_RCliente);
        b_RCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OpcionesReg.this,R_Cliente.class);
                startActivity(intent);
            }
        });

    }
}