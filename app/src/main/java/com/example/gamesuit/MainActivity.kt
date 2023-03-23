package com.example.gamesuit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gamesuit.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var pilihanPlayer: String
    private val pilihanSuit = arrayOf("batu","kertas","gunting")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            batuPlayer.setOnClickListener {
                batuPlayer.setBackgroundResource(R.drawable.bg_click)
                batuPlayer.isEnabled = false
                kertasPlayer.isEnabled = false
                guntingPlayer.isEnabled = false
                pilihanPlayer = pilihanSuit[0]
                Log.d("pilihan Suit", pilihanPlayer)

            }

            kertasPlayer.setOnClickListener {
                kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                batuPlayer.isEnabled = false
                kertasPlayer.isEnabled = false
                guntingPlayer.isEnabled = false
                pilihanPlayer = pilihanSuit[1]
                Log.d("pilihan Suit", pilihanPlayer)
            }

            guntingPlayer.setOnClickListener {
                guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                batuPlayer.isEnabled = false
                kertasPlayer.isEnabled = false
                guntingPlayer.isEnabled = false
                pilihanPlayer = pilihanSuit[2]
                Log.d("pilihan Suit", pilihanPlayer)
            }

        }

    }
}