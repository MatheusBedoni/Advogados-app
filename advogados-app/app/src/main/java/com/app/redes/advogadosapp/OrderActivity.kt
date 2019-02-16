package com.app.redes.advogadosapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.redes.advogadosapp.Fragment.OrderFragment
import com.app.redes.advogadosapp.Fragment.TipsFragment

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

    }
    override fun onResume() {
        super.onResume()
        var frag: OrderFragment? = supportFragmentManager.findFragmentByTag("mainFrag") as? OrderFragment
        if (frag == null) {
            frag = OrderFragment()
            Log.i("TAG", "fragment")
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag")
            ft.commit()
        }
    }
}
