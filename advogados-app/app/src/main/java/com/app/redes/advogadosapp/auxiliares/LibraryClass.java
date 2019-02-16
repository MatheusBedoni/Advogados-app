package com.app.redes.advogadosapp.auxiliares;

import android.content.Context;
import android.content.SharedPreferences;

import com.firebase.client.Firebase;

/**
 * Created by Matt on 14/01/2019.
 */
//Classe que serve como auxiliar para poder guardar o token gerado no login
public class LibraryClass {
    public static String PREF = "com.app.redes.advogadosapp.PREF";
    private static Firebase firebase;

    public static Firebase getFirebase(){
        try{
            if( firebase == null ){
                firebase = new Firebase("https://nosso-chate-fb.firebaseio.com//");
            }
            return( firebase );
        }catch (Exception e){

        }
        return null;
    }
    static public void saveSP(Context context, String key, String value ){
        SharedPreferences sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    static public String getSP(Context context, String key ){
        SharedPreferences sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        String token = sp.getString(key, "");
        return( token );
    }
}
