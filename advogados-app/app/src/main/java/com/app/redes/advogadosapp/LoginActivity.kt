package com.app.redes.advogadosapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast

import com.google.firebase.auth.AuthResult
import android.support.annotation.NonNull
import android.util.Log
import com.app.redes.advogadosapp.auxiliares.LibraryClass
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.firebase.client.Firebase
import com.app.redes.advogadosapp.R.drawable.user
import com.firebase.client.FirebaseError


class LoginActivity : AppCompatActivity() {
    private var firebase: Firebase? = null
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()
        firebase = LibraryClass.getFirebase()
        button3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(baseContext, OrderActivity::class.java)
                startActivity(intent)
//                Log.d("tag", "success")
//                firebase!!.createUser(
//                        "abogado-test@gmail.com",
//                        "test123",
//                        object : Firebase.ValueResultHandler<Map<String, Any>> {
//                            override fun onSuccess(stringObjectMap: Map<String, Any>) {
//                                Log.d("tag", "success create")
//                            }
//
//                            override fun onError(firebaseError: FirebaseError) {
//                                Log.d("tag", "failure create")
//                            }
//                        }
//                )
            }
        })
    }


}

private fun <TResult> Task<TResult>.addOnCompleteListener(onClickListener: View.OnClickListener, onCompleteListener: OnCompleteListener<TResult>) {}
