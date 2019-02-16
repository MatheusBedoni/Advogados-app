package com.app.redes.advogadosapp
import android.content.Intent
import kotlinx.android.synthetic.main.activity_introduction.*

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class IntroductionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)


        button2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(baseContext, ReasonsActivity::class.java)
               startActivity(intent)
            }
        })
        button3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(baseContext, LoginActivity::class.java)
                startActivity(intent)
            }
        })
    }

}
