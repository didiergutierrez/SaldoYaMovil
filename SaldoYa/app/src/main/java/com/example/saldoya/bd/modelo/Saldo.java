package com.example.saldoya.bd.modelo;

public class Saldo {
    private String id;
    private String cedula;
    private String saldo;
    private String fecha;

    public Saldo() {
    }

    public Saldo(String id, String cedula, String saldo, String fecha) {
        this.id = id;
        this.cedula = cedula;
        this.saldo = saldo;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
