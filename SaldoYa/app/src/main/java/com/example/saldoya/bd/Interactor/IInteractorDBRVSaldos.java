package com.example.saldoya.bd.Interactor;

import android.content.ContentValues;

import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;

public interface IInteractorDBRVSaldos {

    ArrayList<Saldo> obtenerSaldos();

    void agregarContacto(ContentValues contentValues);

    void borrarContacto();
}
