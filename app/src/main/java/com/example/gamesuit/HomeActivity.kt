package com.example.gamesuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamesuit.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var namaPemain: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        namaPemain = intent.getStringExtra("simpanNama")
        binding.textPemainvspemain.text = "$namaPemain vs Pemain"
        binding.textPemainvscomputer.text = "$namaPemain vs Computer"

        val snackbar = Snackbar.make(binding.root,"Selamat Datang $namaPemain", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Tutup") {
            snackbar.dismiss()
        }
        snackbar.show()

    }
}