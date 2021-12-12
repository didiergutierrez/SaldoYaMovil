package com.example.saldoya.controladores;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.saldoya.Inicio;
import com.example.saldoya.R_Empresa;
import com.example.saldoya.RegistrarSaldo;
import com.example.saldoya.bd.modelo.firebase.ConstantesFirebase;
import com.example.saldoya.bd.modelo.firebase.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

public class RegistroControladorEmp {
    public static void registroEmp(Context contexto, String nombreTienda, String nit, String correo, String telefono, String direccion, String contraseña, String tipo) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo, contraseña)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            tiendaFirestore(contexto, nombreTienda,nit, correo,telefono,direccion,tipo);
                        }else {
                            Toast.makeText(contexto, "Error al intentar registrar el usuario", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private static void tiendaFirestore(Context contexto, String nombreTienda, String nit, String correo, String telefono, String direccion, String tipo) {

        try{

            FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

            String id= firebaseUser.getUid();

            long tiempoCreado= firebaseUser.getMetadata().getCreationTimestamp();

            Usuario usuario= new Usuario(id, nombreTienda, nit,correo,telefono,direccion, tiempoCreado);

            FirebaseFirestore.getInstance()
                    .collection(ConstantesFirebase.USUARIOS)
                    .document(id)
                    .set(usuario, SetOptions.merge())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                Intent intent= new Intent(contexto, RegistrarSaldo.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                contexto.startActivity(intent);
                            }else {
                                Toast.makeText(contexto, "Error al intentar guardar datos del usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }catch (NullPointerException e){
            e.getCause();
        }
    }
}
