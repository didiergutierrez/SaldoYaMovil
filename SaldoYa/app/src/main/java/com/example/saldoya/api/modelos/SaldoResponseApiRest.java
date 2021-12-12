package com.example.saldoya.api.modelos;

import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;

public class SaldoResponseApiRest {
    private ArrayList<Saldo> saldoArrayList;

    public ArrayList<Saldo> getSaldoArrayList() {
        return saldoArrayList;
    }

    public void setSaldoArrayList(ArrayList<Saldo> saldoArrayList) {
        this.saldoArrayList = saldoArrayList;
    }
}
