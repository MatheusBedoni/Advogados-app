package com.app.redes.advogadosapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.app.redes.advogadosapp.Adapter.TipsAdapter
import com.app.redes.advogadosapp.domain.Tips

import kotlinx.android.synthetic.main.content_data.*
import kotlinx.android.synthetic.main.activity_data.*
class DataActivity : AppCompatActivity() {
    private var nameS: String? = null
    private var apelidosS: String? = null
    private var movilS: String? = null
    private var emailS: String? = null
    private var tips: Tips? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        setSupportActionBar(toolbar)

        if (intent != null && intent.extras != null && intent.extras!!.getParcelable<Parcelable>("tips") != null) {
            tips = intent.extras!!.getParcelable<Tips>("tips")
        }
        button3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                emailS = email.text.toString()
                nameS = nome.text.toString()
                apelidosS = apelidos.text.toString()
                movilS = movil.text.toString()
                if (emailS!!.trim { it <= ' ' }.isEmpty() || nameS!!.trim().isEmpty() || apelidosS!!.trim().isEmpty() || movilS!!.trim().isEmpty() ) run {
                    val dlg = AlertDialog.Builder(baseContext)
                    dlg.setMessage("Há dados em brancos")
                    dlg.setNeutralButton("Ok", null)
                    dlg.show()
                }else{
                    tips!!.setName(nameS!!)
                    tips!!.setEmail(emailS!!)
                    tips!!.setTelephone(movilS!!)
                    tips!!.setNicknames(apelidosS!!)
                    val intent = Intent(baseContext, DataActivity2::class.java)
                    intent.putExtra("tips", tips)
                    startActivity(intent)
                }

            }
        })


    }

}
