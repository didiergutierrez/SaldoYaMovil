package com.example.saldoya.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;

public class DVRVSaldo extends SQLiteOpenHelper {

    private Context contexto;

    public DVRVSaldo(@Nullable Context context) {
        super(context, ConstantesDBRVSaldo.NOMBRE_DB, null, ConstantesDBRVSaldo.VERSION_DB);
        this.contexto=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCrearTablaSaldo= "CREATE TABLE "+ConstantesDBRVSaldo.T_SALDOS +"(" +
                ConstantesDBRVSaldo.T_SALDOS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDBRVSaldo.T_SALDOS_IDTIENDA +" TEXT," +
                ConstantesDBRVSaldo.T_SALDOS_CEDULA +" TEXT, " +
                ConstantesDBRVSaldo.T_SALDOS_SALDO +" TEXT " +
//
                ")";

        db.execSQL(sqlCrearTablaSaldo);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesDBRVSaldo.T_SALDOS);
        onCreate(db);
    }

    public ArrayList<Saldo> leerSaldo() {

        ArrayList<Saldo> SaldoArrayList = new ArrayList<>();

        String sqlLeerSaldo= "SELECT * FROM "+ConstantesDBRVSaldo.T_SALDOS;
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor recorridoSaldo= db.rawQuery(sqlLeerSaldo, null);

        try{

            while (recorridoSaldo.moveToNext()){

                Saldo saldo= new Saldo();
                saldo.setId(String.valueOf(recorridoSaldo.getInt(0)));
                saldo.setIdTienda(recorridoSaldo.getString(1));
                saldo.setCedula(recorridoSaldo.getString(2));
                saldo.setSaldo(recorridoSaldo.getString(3));
//                saldo.setCorreo(recorridoSaldo.getString(4));

                SaldoArrayList.add(saldo);

            }

        }catch (SQLException e){
            recorridoSaldo.close();
            db.close();
        }

        return SaldoArrayList;
    }

    public void crearSaldo(ContentValues contentValues){
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(ConstantesDBRVSaldo.T_SALDOS, null, contentValues);
        db.close();
    }

    public void eliminarSaldos(){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        sqLiteDatabase.delete(ConstantesDBRVSaldo.T_SALDOS, null, null);
        sqLiteDatabase.close();
    }
}
