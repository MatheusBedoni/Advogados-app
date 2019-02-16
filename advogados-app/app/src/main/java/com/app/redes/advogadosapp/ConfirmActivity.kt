package com.app.redes.advogadosapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_confirm.*


class ConfirmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        button3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(baseContext, IntroductionActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
