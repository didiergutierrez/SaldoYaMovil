package com.example.saldoya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saldoya.controladores.LoginControlador;
import com.example.saldoya.utiles.ValidarCorreo;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String nombre="";
    private TextView et_usuario, et_clave;
    private Button b_login;
    private TextView lbl_Crear_Cuenta;
    private Spinner sp_login;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view= findViewById(R.id.cl_login);

        //Buscamos el botón y se guarda en la variable
        et_usuario= findViewById(R.id.et_usuario);
        et_clave= findViewById(R.id.et_clave);
        b_login=findViewById(R.id.b_login);
        lbl_Crear_Cuenta= findViewById(R.id.lbl_Crear_Cuenta);
        sp_login= findViewById(R.id.sp_login);

        et_usuario.addTextChangedListener(textWatcher);
        et_clave.addTextChangedListener(textWatcher);

        String [] respuesta = {"Cliente", "Tienda"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, respuesta);
        sp_login.setAdapter(adapter);


        //Proceso o método al darle click al boton
        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginControlador.login(MainActivity.this, getUsiario(), getClave(),getTipo());
            }
        });

        lbl_Crear_Cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, OpcionesReg.class);
                startActivity(intent);
            }
        });


    }
    private TextWatcher textWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            habilitar();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private boolean habilitar(){

        String correo= getUsiario().trim();
        String contraseña= getClave().trim();

        if(ValidarCorreo.validar(correo) && contraseña.length()>5){
            b_login.setEnabled(true);
            return true;
        }else {
            b_login.setEnabled(false);
            return false;
        }
    }
    private String getUsiario() {
        return et_usuario.getText().toString();
    }

    private String getClave() {
        return et_clave.getText().toString();
    }

    private String getTipo(){return sp_login.getSelectedItem().toString();}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this, view);

        et_usuario.clearFocus();
        et_clave.clearFocus();
        sp_login.clearFocus();

        return true;
    }

    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager= (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

}