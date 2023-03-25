package com.example.gamesuit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.gamesuit.databinding.ActivityMainBinding



@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var pilihanPlayer: String
    private lateinit var hasilSuit: String
    private val pilihanSuit = arrayOf("batu","kertas","gunting")
    private val suitHasil = arrayOf("Pemain Menang", "Computer Menang", "Draw")



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
                computer.efekPilihanCom(batuCom,guntingCom,kertasCom)
                Log.d("coba hasil komputer", computer.getPilihanPlayer())
                player.suit(player.getPilihanPlayer(),computer.getPilihanPlayer())
                computer.suit(computer.getPilihanPlayer(),player.getPilihanPlayer())
                Log.d("coba hasil status menang player", "${player.getStatusMenang()}")
                Log.d("coba hasil status menang computer ", "${computer.getStatusMenang()}")
                hasilSuit = hasilSuit(player.getStatusMenang(),computer.getStatusMenang(),suitHasil)
                Log.d("coba hasil status Hasil Suit ", hasilSuit)



//
            }

            kertasPlayer.setOnClickListener {
                kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                setEnabledImageView(batuPlayer,kertasPlayer,guntingPlayer,setNilai = false)
                pilihanPlayer = pilihanSuit[1]
                player.setPilihanPlayer(pilihanPlayer)
                Log.d("coba hasil pilihan player", player.getPilihanPlayer())
                computer.pilihanCom(pilihanSuit)
                computer.setPilihanPlayer(computer.getPilihanCom())
                computer.efekPilihanCom(batuCom,guntingCom,kertasCom)
                Log.d("coba hasil komputer", computer.getPilihanPlayer())
                player.suit(player.getPilihanPlayer(),computer.getPilihanPlayer())
                computer.suit(computer.getPilihanPlayer(),player.getPilihanPlayer())
                Log.d("coba hasil status menang player", "${player.getStatusMenang()}")
                Log.d("coba hasil status menang computer", "${computer.getStatusMenang()}")
                hasilSuit = hasilSuit(player.getStatusMenang(),computer.getStatusMenang(),suitHasil)
                Log.d("coba hasil status Hasil Suit ", hasilSuit)


            }

            guntingPlayer.setOnClickListener {
                guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                setEnabledImageView(batuPlayer,kertasPlayer,guntingPlayer,setNilai = false)
                pilihanPlayer = pilihanSuit[2]
                player.setPilihanPlayer(pilihanPlayer)
                Log.d("coba hasil pilihan player", player.getPilihanPlayer())
                computer.pilihanCom(pilihanSuit)
                computer.setPilihanPlayer(computer.getPilihanCom())
                computer.efekPilihanCom(batuCom,guntingCom,kertasCom)
                Log.d("coba hasil komputer", computer.getPilihanPlayer())
                player.suit(player.getPilihanPlayer(),computer.getPilihanPlayer())
                computer.suit(computer.getPilihanPlayer(),player.getPilihanPlayer())
                Log.d("coba hasil status menang player", "${player.getStatusMenang()}")
                Log.d("coba hasil status menang computer", "${computer.getStatusMenang()}")
                hasilSuit = hasilSuit(player.getStatusMenang(),computer.getStatusMenang(),suitHasil)
                Log.d("coba hasil status Hasil Suit ", hasilSuit)


            }


        }

    }

    private fun efekHasilSuit(textView: TextView) {

    }

    private fun hasilSuit(status1: Boolean,status2: Boolean,arrayhasilSuit: Array<String>): String {
      lateinit var nilaiString: String

        if(status1 && !status2) {
            nilaiString = arrayhasilSuit[0]
        } else if (!status1 && status2) {
            nilaiString = arrayhasilSuit[1]
        } else {
            nilaiString = arrayhasilSuit[2]
        }
        return nilaiString
    }

    private fun setEnabledImageView(imageView1: ImageView,imageView2: ImageView,imageView3: ImageView,setNilai: Boolean) {
        imageView1.isEnabled = setNilai
        imageView2.isEnabled = setNilai
        imageView3.isEnabled = setNilai
    }
}