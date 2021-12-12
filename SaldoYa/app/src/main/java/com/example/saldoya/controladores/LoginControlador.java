package com.example.saldoya.controladores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.saldoya.Inicio;
import com.example.saldoya.RegistrarSaldo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginControlador {



    public static void login(Activity activity, String correo, String contraseña, String tipo) {



        FirebaseAuth.getInstance().signInWithEmailAndPassword(correo, contraseña)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()&& tipo.equals("Cliente")){
                            activity.startActivity(new Intent(activity, Inicio.class));
                            activity.finish();
                        }else if (task.isSuccessful()&& tipo.equals("Tienda")){
                            activity.startActivity(new Intent(activity, RegistrarSaldo.class));
                            activity.finish();
                        }else {
                            Toast.makeText(activity, "Error al intentar iniciar sesion", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
