package com.example.gamesuit

import kotlin.random.Random


class Computer:Player() {

    private lateinit var pilihanCom: String

    fun pilihanCom(pilihanArray: Array<String>) {
        val randomIndeks = (0 until pilihanArray.size).random(Random(System.currentTimeMillis()))
        pilihanCom = pilihanArray[randomIndeks]
    }

    fun getPilihanCom():String {
        return pilihanCom
    }

}