package com.example.gamesuit

open class Player {
    private var statusMenang = false
    private lateinit var pilihanPlayer: String

    fun setPilihanPlayer(pilihanPlayer: String) {
        this.pilihanPlayer = pilihanPlayer
    }

    fun getPilihanPlayer():String {
        return this.pilihanPlayer
    }

}