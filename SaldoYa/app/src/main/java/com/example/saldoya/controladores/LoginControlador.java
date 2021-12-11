package com.example.saldoya.controladores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.saldoya.Inicio;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginControlador {

    public static void login(Activity activity, String correo, String contraseña) {

        FirebaseAuth.getInstance().signInWithEmailAndPassword(correo, contraseña)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            activity.startActivity(new Intent(activity, Inicio.class));
                            activity.finish();
                        }else {
                            Toast.makeText(activity, "Error al intentar iniciar sesion", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
