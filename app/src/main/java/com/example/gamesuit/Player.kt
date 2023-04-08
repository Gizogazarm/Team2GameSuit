package com.example.gamesuit

open class Player : Suit() {
    private var statusMenang = false
    private lateinit var pilihanPlayer: String

    fun setPilihanPlayer(pilihanPlayer: String) {
        this.pilihanPlayer = pilihanPlayer
    }

    fun getPilihanPlayer(): String {
        return this.pilihanPlayer
    }

    override fun suit(pilihan1: String, pilihan2: String): Boolean {
        statusMenang = when (pilihan1 == pilihan2) {
            true -> false
            false -> if (pilihan1 == "batu" && pilihan2 == "gunting") {
                true
            } else if (pilihan1 == "gunting" && pilihan2 == "kertas") {
                true
            } else pilihan1 == "kertas" && pilihan2 == "batu"
        }
        return statusMenang
    }

    fun getStatusMenang():Boolean {
        return statusMenang
    }
}