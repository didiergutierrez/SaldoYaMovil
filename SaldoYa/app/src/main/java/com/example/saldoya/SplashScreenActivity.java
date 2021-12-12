package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        FirebaseUser usuario= FirebaseAuth.getInstance().getCurrentUser();

        if(usuario==null){
            iniciarNuevaActividad(MainActivity.class);
        }else {
            iniciarNuevaActividad(Inicio.class);
        }
    }

    private void iniciarNuevaActividad(Class clase) {
        startActivity(new Intent(this, clase));
        finish();
    }
}