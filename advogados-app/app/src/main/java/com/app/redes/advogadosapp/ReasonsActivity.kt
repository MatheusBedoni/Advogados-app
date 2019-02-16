package com.app.redes.advogadosapp
import android.content.Intent
import kotlinx.android.synthetic.main.activity_reasons.*

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.app.redes.advogadosapp.Fragment.TipsFragment
import com.app.redes.advogadosapp.domain.Tips
import java.util.ArrayList

class ReasonsActivity : AppCompatActivity() {
    private var list: List<Tips>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reasons)
    }
    override fun onResume() {
        super.onResume()
        var frag: TipsFragment? = supportFragmentManager.findFragmentByTag("mainFrag") as? TipsFragment
        if (frag == null) {
            frag = TipsFragment()
            Log.i("TAG", "fragment")
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag")
            ft.commit()
        }

    }
    fun pedidos(): List<Tips> {
        val listAux = ArrayList<Tips>()
        val tips = Tips()
        tips.setName("Motivo 1")
        listAux.add(tips)
        val tips2 = Tips()
        tips2.setName("Motivo2")
        listAux.add(tips2)
        val tips3 = Tips()
        tips3.setName("Motivo3")
        listAux.add(tips3)
        val tips4 = Tips()
        tips4.setName("Motivo4")
        listAux.add(tips4)
        val tips5 = Tips()
        tips5.setName("Motivo3")
        listAux.add(tips5)
        val tips6 = Tips()
        tips6.setName("Motivo4")
        listAux.add(tips6)
        return listAux
    }

}
