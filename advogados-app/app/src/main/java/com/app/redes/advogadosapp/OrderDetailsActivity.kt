package com.app.redes.advogadosapp

import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.app.redes.advogadosapp.domain.Tips

import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.content_order_details.*
class OrderDetailsActivity : AppCompatActivity() {
    private var tips: Tips? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)
        setSupportActionBar(toolbar)
        if (intent != null && intent.extras != null && intent.extras!!.getParcelable<Parcelable>("tips") != null) {
            tips = intent.extras!!.getParcelable<Tips>("tips")
        }

        txt_nome.setText(tips!!.getName())
        txt_email.setText(tips!!.getEmail())
        reason.setText(tips!!.getReasons())
        desc.setText(tips!!.getDescription())
    }

}
