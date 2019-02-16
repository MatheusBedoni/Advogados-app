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
import com.app.redes.advogadosapp.R
import com.app.redes.advogadosapp.ReasonsActivity
import com.app.redes.advogadosapp.auxiliares.RecyclerViewOnClickListenerHack
import com.app.redes.advogadosapp.Adapter.TipsAdapter
import com.app.redes.advogadosapp.DataActivity
import com.app.redes.advogadosapp.domain.Tips
import java.util.ArrayList
import kotlinx.android.synthetic.main.fragment_tips.*
/**
 * Created by Matt on 06/02/2019.
 */
class TipsFragment : Fragment(), RecyclerViewOnClickListenerHack {

    private var recyclerView: RecyclerView? = null
    private var list: List<Tips>? = null
    private var tips: Tips? = null
    private var adapter: TipsAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_tips, container, false)
        //O app cria as listas usando o Recycler View
        tips = Tips()
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

        list = (activity as ReasonsActivity).pedidos()
        adapter = TipsAdapter(activity, list)
        val llm = LinearLayoutManager(activity)
        llm.orientation = LinearLayoutManager.VERTICAL

        recyclerView!!.layoutManager = llm
        recyclerView!!.setLayoutManager(GridLayoutManager(activity, 2))

        adapter!!.setRecyclerViewOnClickListenerHack(this)
        recyclerView!!.adapter = adapter
        return view
    }

    override fun onResume() {
        super.onResume()
        button2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(activity, DataActivity::class.java)
                intent.putExtra("tips", tips)
                startActivity(intent)
            }
        })
    }



    override fun onClickListener(view: View, position: Int) {
        //O app usa o Parcelable para passar os dados dos objetos de uma tela pra outra
        //Economizando a internet do usuario e deixando o app mais rapido e eficiente
//        val intent = Intent(activity, IntroductionActivity::class.java)
//      //  intent.putExtra("tips", list!!.get(position))
//        activity.startActivity(intent)
        if(list!!.get(position).getLook()!! > 0){
            list!!.get(position).setLook(0)
        }else{
            tips!!.setReasons(tips!!.getReasons()+", "+list!!.get(position).getName()!!)
            list!!.get(position).setLook(1)
        }

        adapter = TipsAdapter(activity, list)

        recyclerView!!.setLayoutManager(GridLayoutManager(activity, 2))

        adapter!!.setRecyclerViewOnClickListenerHack(this)
        recyclerView!!.adapter = adapter
    }
}
