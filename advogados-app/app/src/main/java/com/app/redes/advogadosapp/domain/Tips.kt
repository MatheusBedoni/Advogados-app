package com.app.redes.advogadosapp.domain

import android.os.Parcel
import android.os.Parcelable
import com.app.redes.advogadosapp.auxiliares.LibraryClass
import com.firebase.client.Firebase



/**
 * Created by Matt on 04/02/2019.
 */
class Tips  constructor( ):Parcelable{
    private var name: String? = null
    private var email: String? = null
    private var description: String? = null
    private var reasons: String? = null
    private var nicknames: String? = null
    private var telephone: String? = null
    private var locality: String? = null
    private var province:String? = null

    private var look: Int = 0
    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        email = parcel.readString()
        description = parcel.readString()
        look = parcel.readInt()
        reasons = parcel.readString()
        nicknames = parcel.readString()
        telephone = parcel.readString()
        locality = parcel.readString()
        province = parcel.readString()
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(description)
        parcel.writeInt(look)
        parcel.writeString(reasons)
        parcel.writeString(nicknames)
        parcel.writeString(telephone)
        parcel.writeString(locality)
        parcel.writeString(province)
    }

    fun saveDB() {
        var firebase = LibraryClass.getFirebase()
        firebase = firebase!!.child("pedidos").child(email)
        firebase!!.setValue(this)

    }
    fun getName(): String? {
        return name
    }
    fun getEmail(): String? {
        return email
    }

    fun getDescription(): String? {
        return description
    }
    fun getReasons(): String? {
        return reasons
    }
    fun getNicknames(): String? {
        return nicknames
    }
    fun getTelephone(): String? {
        return telephone
    }
    fun getLocality(): String? {
        return locality
    }
    fun getProvince(): String? {
        return province
    }
    fun getLook(): Int? {
        return look
    }

    fun setName(name: String) {
        this.name = name
    }
    fun setEmail(email: String) {
        this.email = email
    }
    fun setDescription(description: String) {
        this.description = description
    }
    fun setReasons(reasons: String) {
        this.reasons = reasons
    }
    fun setNicknames(nicknames: String) {
        this.nicknames = nicknames
    }
    fun setTelephone(telephone: String) {
        this.telephone = telephone
    }
    fun setLocality(locality: String) {
        this.locality = locality
    }
    fun setProvince(province: String) {
        this.province = province
    }
    fun setLook(look: Int) {
        this.look = look
    }


    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tips> {
        override fun createFromParcel(parcel: Parcel): Tips {
            return Tips(parcel)
        }

        override fun newArray(size: Int): Array<Tips?> {
            return arrayOfNulls(size)
        }
    }


}