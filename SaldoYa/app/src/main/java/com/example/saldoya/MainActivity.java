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
                LoginControlador.login(MainActivity.this, getUsiario(), getClave());
                String seleccionado = sp_login.getSelectedItem().toString();
                if (seleccionado.equals("Cliente")){
                    LoginControlador.login(MainActivity.this, getUsiario(), getClave());
                    nombre= et_usuario.getText().toString();
                    Intent intent1=new Intent(MainActivity.this, Inicio.class);
                    intent1.putExtra("nombre",nombre);
                    startActivity(intent1);
                }else {
                    Intent intent2= new Intent(MainActivity.this, RegistrarSaldo.class);
                    startActivity(intent2);
                }
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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;
        switch (item.getItemId()){
            case R.id.informacion:
                Toast.makeText(this, "Información", Toast.LENGTH_LONG).show();
                return true;
            case R.id.contacto:
                intent= new Intent(this, Contactenos.class);
                startActivity(intent);
                return true;
            case R.id.configuracion:
                Toast.makeText(this, "Configuración", Toast.LENGTH_LONG).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this, view);

        et_usuario.clearFocus();
        et_clave.clearFocus();

        return true;
    }

    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager= (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

}