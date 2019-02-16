package com.app.redes.advogadosapp.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.redes.advogadosapp.Adapter.OrderAdapter
import com.app.redes.advogadosapp.auxiliares.RecyclerViewOnClickListenerHack
import com.app.redes.advogadosapp.Adapter.TipsAdapter
import com.app.redes.advogadosapp.domain.Tips
import java.util.ArrayList
import kotlinx.android.synthetic.main.fragment_tips.*
import com.app.redes.advogadosapp.auxiliares.LibraryClass
import com.firebase.client.Firebase
import android.R.attr.thumbnail
import com.app.redes.advogadosapp.*
import com.app.redes.advogadosapp.Adapter.OrderViewHolder


/**
 * Created by Matt on 06/02/2019.
 */
class OrderFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var list: List<Tips>? = null
    private var tips: Tips? = null
    private var adapter: OrderAdapter? = null
    private var firebase: Firebase? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_order, container, false)
        //O app cria as listas usando o Recycler View
        tips = Tips()
        firebase = LibraryClass.getFirebase()
        recyclerView = view.findViewById(R.id.rv_list)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        return view
    }

    override fun onResume() {
        super.onResume()
        firebase = LibraryClass.getFirebase()!!.child("pedidos")

        try {
            recyclerView!!.setVisibility(View.VISIBLE)
            val llm = LinearLayoutManager(activity)
            llm.orientation = LinearLayoutManager.VERTICAL
            try {
                recyclerView!!.setLayoutManager(llm)
                init()
                recyclerView!!.setAdapter(adapter)
            } catch (e: Exception) {
            }

        } catch (e: Exception) {
        }

    }

    fun init() {
        adapter = object : OrderAdapter(
                Tips::class.java,
                R.layout.item_order,
                OrderViewHolder::class.java,
                firebase) {
            protected override fun populateViewHolder(produtoresViewHolder: OrderViewHolder, produtor: Tips, i: Int) {
                super.populateViewHolder(produtoresViewHolder, produtor, i)
                produtoresViewHolder.tvNome.setText(produtor.getName())
                produtoresViewHolder.tvEmail.setText(produtor.getEmail())

                produtoresViewHolder.itemView.setOnClickListener(View.OnClickListener {
                    val intent = Intent(activity, OrderDetailsActivity::class.java)
                    intent.putExtra("tips", produtor)
                    activity.startActivity(intent)
                })
            }
        }

    }


}
