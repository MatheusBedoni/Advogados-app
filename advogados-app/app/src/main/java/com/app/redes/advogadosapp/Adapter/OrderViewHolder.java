package com.app.redes.advogadosapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.redes.advogadosapp.R;

/**
 * Created by Matt on 15/02/2019.
 */

public class OrderViewHolder  extends RecyclerView.ViewHolder{
    public TextView tvNome;
    public TextView tvEmail;
    public TextView tvData;
    public OrderViewHolder(View itemView) {
        super(itemView);
        tvNome = (TextView)itemView.findViewById(R.id.nome);
        tvEmail = (TextView)itemView.findViewById(R.id.email);
        tvData = (TextView) itemView.findViewById(R.id.data);
    }
}