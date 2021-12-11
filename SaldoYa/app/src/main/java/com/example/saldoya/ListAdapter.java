package com.example.saldoya;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListAdapterViewHolder> {

    private Activity contexto;
    private ArrayList<Saldo> saldoArrayList;

    public ListAdapter(Activity contexto, ArrayList<Saldo> saldoArrayList) {
        this.contexto = contexto;
        this.saldoArrayList = saldoArrayList;
    }


    public class ListAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_icono;
        private TextView tv_valor, tv_fecha,tv_tienda;
        public ListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_icono=itemView.findViewById(R.id.iv_icono);
            tv_valor=itemView.findViewById(R.id.tv_valor);
            tv_fecha=itemView.findViewById(R.id.tv_fecha);
            tv_tienda=itemView.findViewById(R.id.tv_tienda);
        }
    }

    @NonNull
    @Override
    public ListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false);

        ListAdapterViewHolder listAdapterViewHolder= new ListAdapterViewHolder(itemView);

        return listAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterViewHolder holder, int position) {

        final Saldo saldo=  saldoArrayList.get(position);

        holder.iv_icono.setImageResource(R.drawable.ic_request_quote_black_24dp);

        holder.iv_icono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contexto, "enviar nombre", Toast.LENGTH_LONG).show();

            }
        });

        holder.tv_fecha.setText(saldo.getFecha());
        holder.tv_valor.setText(saldo.getSaldo());
        holder.tv_tienda.setText(saldo.getIdTienda());

    }

    @Override
    public int getItemCount() {
        return saldoArrayList.size();
    }

}

