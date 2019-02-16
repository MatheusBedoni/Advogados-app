package com.app.redes.advogadosapp

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import com.app.redes.advogadosapp.domain.Tips

import kotlinx.android.synthetic.main.activity_data2.*


class DataActivity2 : AppCompatActivity() {
    private var localidadS: String? = null
    private var provinciaS: String? = null
    private var apelidosS: String? = null
    private var tips: Tips? = null
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_data2)
            if (intent != null && intent.extras != null && intent.extras!!.getParcelable<Parcelable>("tips") != null) {
               tips = intent.extras!!.getParcelable<Tips>("tips")
            }
            button3.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    localidadS = localidad.text.toString()
                    provinciaS = provincia.text.toString()
                    apelidosS = apelidos.text.toString()
                    if (localidadS!!.trim { it <= ' ' }.isEmpty() || provinciaS!!.trim().isEmpty() || apelidosS!!.trim().isEmpty() || apelidosS!!.trim().isEmpty() ) run {
                        val dlg = AlertDialog.Builder(baseContext)
                        dlg.setMessage("Há dados em brancos")
                        dlg.setNeutralButton("Ok", null)
                        dlg.show()
                    }else{
                        tips!!.setLocality(localidadS!!)
                        tips!!.setProvince(provinciaS!!)
                        tips!!.setDescription(apelidosS!!)
                        tips!!.saveDB()
                        val intent = Intent(baseContext, ConfirmActivity::class.java)
                        startActivity(intent)
                    }
                }
        })
    }
}
