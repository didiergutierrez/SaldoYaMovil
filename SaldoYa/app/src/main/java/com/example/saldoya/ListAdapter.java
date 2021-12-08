package com.example.saldoya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;


    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;
    }
    @Override
    public int getItemCount(){ return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement> items){mData= items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        //ImageView iconImage;
        TextView fecha,tienda,valor;

        ViewHolder(View itemView){
            super(itemView);
            //iconImage=itemView.findViewById(R.id.iconImageView);
            fecha=itemView.findViewById(R.id.fechaTextView);
            tienda= itemView.findViewById(R.id.tiendaTextView);
            valor=itemView.findViewById(R.id.valorTextView);
        }

        void bindData(final ListElement item){
            fecha.setText(item.getFecha());
            tienda.setText(item.getTienda());
            valor.setText(item.getValor());
        }
    }

}

