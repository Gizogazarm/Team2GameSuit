package com.example.gamesuit

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
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

        val player = Player()

        with(binding) {

            batuPlayer.setOnClickListener {
                batuPlayer.setBackgroundResource(R.drawable.bg_click)
                batuPlayer.isEnabled = false
                kertasPlayer.isEnabled = false
                guntingPlayer.isEnabled = false
                pilihanPlayer = pilihanSuit[0]
                player.setPilihanPlayer(pilihanPlayer)
                Log.d("coba hasil pilihan player", player.getPilihanPlayer())

            }

            kertasPlayer.setOnClickListener {
                kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                batuPlayer.isEnabled = false
                kertasPlayer.isEnabled = false
                guntingPlayer.isEnabled = false
                pilihanPlayer = pilihanSuit[1]
                player.setPilihanPlayer(pilihanPlayer)
                Log.d("coba hasil pilihan player", player.getPilihanPlayer())

            }

            guntingPlayer.setOnClickListener {
                guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                batuPlayer.isEnabled = false
                kertasPlayer.isEnabled = false
                guntingPlayer.isEnabled = false
                pilihanPlayer = pilihanSuit[2]
                player.setPilihanPlayer(pilihanPlayer)
                Log.d("coba hasil pilihan player", player.getPilihanPlayer())

            }


        }

    }
}