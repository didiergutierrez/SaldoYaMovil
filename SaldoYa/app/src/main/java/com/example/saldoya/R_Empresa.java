package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.saldoya.controladores.RegistroControlador;
import com.example.saldoya.controladores.RegistroControladorEmp;
import com.example.saldoya.utiles.ValidarCorreo;
import com.google.android.material.textfield.TextInputEditText;

public class R_Empresa extends AppCompatActivity {

    private Button b_Registrar;
    private TextInputEditText tie_nombreTienda,tie_nit,tie_telefono,tie_email,tie_direccion,tie_contraseña;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rempresa);

        view= findViewById(R.id.cl_registrar_tienda);

        tie_nombreTienda=findViewById(R.id.tie_nombre_tienda);
        tie_nit=findViewById(R.id.tie_nit);
        tie_telefono=findViewById(R.id.tie_telefono);
        tie_email=findViewById(R.id.tie_email);
        tie_direccion=findViewById(R.id.tie_direccion);
        tie_contraseña=findViewById(R.id.tie_contraseña);

        tie_nombreTienda.addTextChangedListener(textWatcher);
        tie_nit.addTextChangedListener(textWatcher);
        tie_telefono.addTextChangedListener(textWatcher);
        tie_email.addTextChangedListener(textWatcher);
        tie_direccion.addTextChangedListener(textWatcher);
        tie_contraseña.addTextChangedListener(textWatcher);

        b_Registrar=findViewById(R.id.b_Registrar);
        b_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistroControladorEmp.registroEmp(R_Empresa.this, getNombreTienda(),getNit(), getCorreo(), getTelefono(),getDireccion(), getContraseña(),getTipo());
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

        String nombreTienda= getNombreTienda().trim();
        String nit= getNit().trim();
        String telefono= getTelefono().trim();
        String correo= getCorreo().trim();
        String direccion= getDireccion().trim();
        String contraseña= getContraseña().trim();

        if(nombreTienda.length()>2 && nit.length()>8 &&telefono.length()>9 && direccion.length()>10 && ValidarCorreo.validar(correo) && contraseña.length()>5){
            b_Registrar.setEnabled(true);
            return true;
        }else {
            b_Registrar.setEnabled(false);
            return false;
        }
    }

    private String getNombreTienda() {
        return tie_nombreTienda.getText().toString();
    }
    private String getNit() {
        return tie_nit.getText().toString();
    }
    private String getTelefono() {
        return tie_telefono.getText().toString();
    }
    private String getCorreo() {
        return tie_email.getText().toString();
    }
    private String getDireccion() {
        return tie_direccion.getText().toString();
    }
    private String getContraseña() {
        return tie_contraseña.getText().toString();
    }
    private String getTipo() {
        return "Tienda";
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this, view);

        tie_nombreTienda.clearFocus();
        tie_nit.clearFocus();
        tie_telefono.clearFocus();
        tie_email.clearFocus();
        tie_direccion.clearFocus();
        tie_contraseña.clearFocus();

        return true;
    }

    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager= (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}