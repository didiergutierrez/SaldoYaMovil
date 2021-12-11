package com.example.saldoya.bd.modelo;

public class Saldo {
    private String id;
    private String idTienda;
    private String cedula;
    private String saldo;

    public Saldo() {
    }

    public Saldo(String id, String idTienda, String cedula, String saldo) {
        this.id = id;
        this.idTienda = idTienda;
        this.cedula = cedula;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }


}
