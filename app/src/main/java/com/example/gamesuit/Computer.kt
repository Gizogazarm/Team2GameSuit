package com.example.gamesuit

import android.widget.ImageView
import kotlin.random.Random


class Computer:Player() {

    private lateinit var pilihanCom: String

    fun pilihanCom(pilihanArray: Array<String>) {
        val randomIndeks = (pilihanArray.indices).random(Random(System.currentTimeMillis()))
        pilihanCom = pilihanArray[randomIndeks]
    }

    fun getPilihanCom():String {
        return pilihanCom
    }

    fun efekPilihanCom(imageView1: ImageView,imageView2: ImageView,imageView3: ImageView) {

        when(pilihanCom) {
            "batu" -> imageView1.setBackgroundResource(R.drawable.bg_click)
            "gunting" -> imageView2.setBackgroundResource(R.drawable.bg_click)
            "kertas" -> imageView3.setBackgroundResource(R.drawable.bg_click)
        }

    }

}