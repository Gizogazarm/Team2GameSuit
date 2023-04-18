package com.example.gamesuit

import android.content.Intent
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

        with(binding) {
            namaPemain = intent.getStringExtra("simpanNama")
            textPemainvspemain.text = "$namaPemain vs Pemain"
            textPemainvscomputer.text = "$namaPemain vs Computer"

            val snackbar = Snackbar.make(binding.root,"Selamat Datang $namaPemain", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Tutup") {
                snackbar.dismiss()
            }
            snackbar.show()

            icPemainvspemain.setOnClickListener {
                val intent = Intent(this@HomeActivity,MainActivity::class.java)
                intent.putExtra("gameMode",true)
                intent.putExtra("simpanNama",namaPemain)
                startActivity(intent)
                finish()
            }

            icPemainvscomputer.setOnClickListener {
                val intent = Intent(this@HomeActivity,MainActivity::class.java)
                intent.putExtra("gameMode",false)
                intent.putExtra("simpanNama",namaPemain)
                startActivity(intent)
                finish()
            }

        }


    }
}