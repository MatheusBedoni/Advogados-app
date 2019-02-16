package com.app.redes.advogadosapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.redes.advogadosapp.R;
import com.app.redes.advogadosapp.auxiliares.RecyclerViewOnClickListenerHack;
import com.app.redes.advogadosapp.domain.Tips;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerAdapter;


import java.util.List;

/**
 * Created by Matt on 12/01/2019.
 */

public class OrderAdapter  extends FirebaseRecyclerAdapter<Tips,OrderViewHolder> {

    public OrderAdapter(Class<Tips> modelClass, int modelLayout, Class<OrderViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(OrderViewHolder orderViewHolder, Tips tips, int i) {

    }
}

