package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class R_Empresa extends AppCompatActivity {

    private Button b_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rempresa);

        b_registrar=findViewById(R.id.b_Registrar);
        b_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(R_Empresa.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}