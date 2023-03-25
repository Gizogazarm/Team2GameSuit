package com.example.gamesuit

import android.annotation.SuppressLint
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
        val computer = Computer()


        with(binding) {

            batuPlayer.setOnClickListener {
                batuPlayer.setBackgroundResource(R.drawable.bg_click)
                setEnabledImageView(batuPlayer,kertasPlayer,guntingPlayer,setNilai = false)
                pilihanPlayer = pilihanSuit[0]
                player.setPilihanPlayer(pilihanPlayer)
                Log.d("coba hasil pilihan player", player.getPilihanPlayer())
                computer.pilihanCom(pilihanSuit)
                computer.setPilihanPlayer(computer.getPilihanCom())
                Log.d("coba hasil komputer", computer.getPilihanPlayer())
                player.suit(player.getPilihanPlayer(),computer.getPilihanPlayer())
                computer.suit(computer.getPilihanPlayer(),player.getPilihanPlayer())
                Log.d("coba hasil status menang player", "${player.getStatusMenang()}")
                Log.d("coba hasil status menang computer ", "${computer.getStatusMenang()}")


            }

            kertasPlayer.setOnClickListener {
                kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                setEnabledImageView(batuPlayer,kertasPlayer,guntingPlayer,setNilai = false)
                pilihanPlayer = pilihanSuit[1]
                player.setPilihanPlayer(pilihanPlayer)
                Log.d("coba hasil pilihan player", player.getPilihanPlayer())
                computer.pilihanCom(pilihanSuit)
                computer.setPilihanPlayer(computer.getPilihanCom())
                Log.d("coba hasil komputer", computer.getPilihanPlayer())
                player.suit(player.getPilihanPlayer(),computer.getPilihanPlayer())
                computer.suit(computer.getPilihanPlayer(),player.getPilihanPlayer())
                Log.d("coba hasil status menang player", "${player.getStatusMenang()}")
                Log.d("coba hasil status menang computer", "${computer.getStatusMenang()}")


            }

            guntingPlayer.setOnClickListener {
                guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                setEnabledImageView(batuPlayer,kertasPlayer,guntingPlayer,setNilai = false)
                pilihanPlayer = pilihanSuit[2]
                player.setPilihanPlayer(pilihanPlayer)
                Log.d("coba hasil pilihan player", player.getPilihanPlayer())
                computer.pilihanCom(pilihanSuit)
                computer.setPilihanPlayer(computer.getPilihanCom())
                Log.d("coba hasil komputer", computer.getPilihanPlayer())
                player.suit(player.getPilihanPlayer(),computer.getPilihanPlayer())
                computer.suit(computer.getPilihanPlayer(),player.getPilihanPlayer())
                Log.d("coba hasil status menang player", "${player.getStatusMenang()}")
                Log.d("coba hasil status menang computer", "${computer.getStatusMenang()}")

            }


        }

    }

    private fun setEnabledImageView(imageView1: ImageView,imageView2: ImageView,imageView3: ImageView,setNilai: Boolean) {
        imageView1.isEnabled = setNilai
        imageView2.isEnabled = setNilai
        imageView3.isEnabled = setNilai
    }
}