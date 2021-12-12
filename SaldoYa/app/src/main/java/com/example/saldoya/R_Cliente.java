package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.saldoya.controladores.RegistroControlador;
import com.example.saldoya.utiles.ValidarCorreo;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class R_Cliente extends AppCompatActivity {
    private Button b_Registrar;
    private TextInputEditText tie_nombre,tie_tdocumento,tie_telefono,tie_email,tie_direccion,tie_contraseña;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcliente);

        view= findViewById(R.id.cl_rcliente);

        tie_nombre=findViewById(R.id.tie_nombre);
        tie_tdocumento=findViewById(R.id.tie_tdocumento);
        tie_telefono=findViewById(R.id.tie_telefono);
        tie_email=findViewById(R.id.tie_email);
        tie_direccion=findViewById(R.id.tie_direccion);
        tie_contraseña=findViewById(R.id.tie_contraseña);

        tie_nombre.addTextChangedListener(textWatcher);
        tie_tdocumento.addTextChangedListener(textWatcher);
        tie_telefono.addTextChangedListener(textWatcher);
        tie_email.addTextChangedListener(textWatcher);
        tie_direccion.addTextChangedListener(textWatcher);
        tie_contraseña.addTextChangedListener(textWatcher);

         b_Registrar=findViewById(R.id.b_Registrar);
         b_Registrar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 RegistroControlador.registro(R_Cliente.this, getNombre(),getDocumento(), getCorreo(), getTelefono(),getDireccion(), getContraseña(),getTipo());
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

        String nombre= getNombre().trim();
        String documento= getDocumento().trim();
        String telefono= getTelefono().trim();
        String correo= getCorreo().trim();
        String direccion= getDireccion().trim();
        String contraseña= getContraseña().trim();

        if(nombre.length()>2 && documento.length()>8 &&telefono.length()>9 && direccion.length()>10 && ValidarCorreo.validar(correo) && contraseña.length()>5){
            b_Registrar.setEnabled(true);
            return true;
        }else {
            b_Registrar.setEnabled(false);
            return false;
        }
    }

    private String getNombre() {
        return tie_nombre.getText().toString();
    }
    private String getDocumento() {
        return tie_tdocumento.getText().toString();
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
        return "Cliente";
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this, view);

        tie_nombre.clearFocus();
        tie_tdocumento.clearFocus();
        tie_telefono.clearFocus();
        tie_email.clearFocus();
        tie_direccion.clearFocus();
        //tie_contraseña.clearFocus();

        return true;
    }

    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager= (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

}