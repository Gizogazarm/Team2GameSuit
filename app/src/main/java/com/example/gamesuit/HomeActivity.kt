package com.example.gamesuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gamesuit.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var namaPemain: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            namaPemain = intent.getStringExtra("simpanNama")
            textPemainVsPemain.text = "${namaPemain?.uppercase()} vs Pemain"
            textPemainVsComputer.text = "${namaPemain?.uppercase()} vs Computer"

            val selectedText = intent.getStringExtra("selectedText")
            if (selectedText != null) {
                val greetingMessage = getGreetingMessage(selectedText)
                showSnackbar(greetingMessage)
            }

            ivPemainVsPemain.setOnClickListener {
                val intent = Intent(this@HomeActivity,MainActivity::class.java)
                intent.putExtra("gameMode",true)
                intent.putExtra("simpanNama", namaPemain)
                startActivity(intent)
                finish()
            }

            ivPemainVsComputer.setOnClickListener {
                val intent = Intent(this@HomeActivity,MainActivity::class.java)
                intent.putExtra("gameMode",false)
                intent.putExtra("simpanNama", namaPemain)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun getGreetingMessage(selectedText: String): String {
        return when (selectedText) {
            "Male" -> "Selamat datang Bro ${namaPemain?.uppercase()}"
            "Female" -> "Selamat datang Sis ${namaPemain?.uppercase()}"
            else -> "Selamat datang"
        }
    }

    private fun showSnackbar(message: String) {
        val rootView: View = findViewById(android.R.id.content)
        val snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Tutup") {
            snackbar.dismiss()
        }
        snackbar.show()
    }
}