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
        when (pilihan1 == pilihan2) {
            true -> statusMenang = false
            false -> if (pilihan1 == "batu" && pilihan2 == "gunting") {
                statusMenang = true
            } else if (pilihan1 == "gunting" && pilihan2 == "kertas") {
                statusMenang = true
            } else if (pilihan1 == "kertas" && pilihan2 == "batu") {
                statusMenang = true
            } else {
                statusMenang = false
            }
        }
        return statusMenang
    }

    fun getStatusMenang():Boolean {
        return statusMenang
    }
}