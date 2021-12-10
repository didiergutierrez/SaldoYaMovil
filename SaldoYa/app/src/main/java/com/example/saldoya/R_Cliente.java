package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class R_Cliente extends AppCompatActivity {
    private Button b_Registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcliente);

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