package com.example.tabapplication.ui.main.adapter

import android.os.Parcel

data class Word  (
    var vocabulary: String,
    var meaning: String
){
    fun Word(par: Parcel){
        this.vocabulary = par.readString().toString()
        this.meaning = par.readString().toString()
    }


}