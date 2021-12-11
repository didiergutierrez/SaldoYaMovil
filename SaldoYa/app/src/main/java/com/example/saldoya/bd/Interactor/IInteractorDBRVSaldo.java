package com.example.saldoya.bd.Interactor;

import android.content.ContentValues;

import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;

public interface IInteractorDBRVSaldo {
    ArrayList<Saldo> obtenerSaldo();

    void agregarSaldo(ContentValues contentValues);

    void borrarSaldo();

}
