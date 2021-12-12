package com.example.saldoya.bd.Interactor;

import android.content.ContentValues;
import android.content.Context;


import com.example.saldoya.bd.modelo.Saldo;
import com.example.saldoya.bd.DBRVSaldo;

import java.util.ArrayList;

public class InteractorDBRVSaldos implements IInteractorDBRVSaldos {

    private Context contexto;

    public InteractorDBRVSaldos(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public ArrayList<Saldo> obtenerSaldos() {
        DBRVSaldo dbrvSaldos= new DBRVSaldo(contexto);
        return dbrvSaldos.leerSaldos();
    }

    @Override
    public void agregarContacto(ContentValues contentValues) {
        DBRVSaldo dbrvSaldos= new DBRVSaldo(contexto);
        dbrvSaldos.crearSaldo(contentValues);
    }

    @Override
    public void borrarContacto() {
        DBRVSaldo dbrvSaldos= new DBRVSaldo(contexto);
        dbrvSaldos.eliminarSaldos();
    }
}
