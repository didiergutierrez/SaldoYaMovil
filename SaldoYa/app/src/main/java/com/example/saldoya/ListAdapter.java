package com.example.saldoya;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListAdapterViewHolder> {
    @NonNull
    @Override
    public ListAdapter.ListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListAdapterViewHolder extends RecyclerView.ViewHolder {
        public ListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

//
//    private Activity contexto;
//    private ArrayList<Saldo> saldoArrayList;
//
//    public ListAdapter(Activity contexto, ArrayList<Saldo> saldoArrayList) {
//        this.contexto = contexto;
//        this.saldoArrayList = saldoArrayList;
//    }
//
//
//
//    @NonNull
//    @Override
//    public ListAdapter.ListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false);
//
//        ListAdapterViewHolder listaAdapterRvViewHolder= new ListAdapterViewHolder(itemView);
//
//        return listaAdapterRvViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ListAdapter.ListAdapterViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    private class ListAdapterViewHolder {
//    }
}

