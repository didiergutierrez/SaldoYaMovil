package com.example.saldoya;

public class ListElement {
    public String fecha;
    public String tienda;
    public String valor;

    public ListElement(String fecha, String tienda, String valor) {
        this.fecha = fecha;
        this.tienda = tienda;
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
