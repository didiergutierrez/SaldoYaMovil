package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class R_Cliente extends AppCompatActivity {
    private Button b_Registrar;
    private TextInputEditText til_nombre,til_tdocumento,til_telefono,til_email,til_direccion;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcliente);

        view= findViewById(R.id.cl_rcliente);

        til_nombre=findViewById(R.id.til_direccion);
        til_tdocumento=findViewById(R.id.til_tdocumento);
        til_telefono=findViewById(R.id.til_telefono);
        til_email=findViewById(R.id.til_email);
        til_direccion=findViewById(R.id.til_direccion);

         b_Registrar=findViewById(R.id.b_Registrar);
         b_Registrar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent= new Intent(R_Cliente.this,MainActivity.class);
                 startActivity(intent);
             }
         });
    }
}