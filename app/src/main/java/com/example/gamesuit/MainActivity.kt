package com.example.gamesuit


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.gamesuit.databinding.ActivityMainBinding





class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pilihanPlayer: String
    private lateinit var hasilSuit: String
    private lateinit var originalText: String
    private lateinit var simpanNama: String
    private var originalColor: Int = 0
    private val pilihanSuit = arrayOf("batu", "kertas", "gunting")
    private val suitHasil = arrayOf("Pemain Menang", "Computer Menang", "Draw")


    val player = Player()
    val computer = Computer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {

            Glide.with(this@MainActivity).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(imageGlideMain)

            originalText = textCenter.text.toString()
            originalColor = textCenter.currentTextColor

            batuPlayer.setOnClickListener {
                batuPlayer.setBackgroundResource(R.drawable.bg_click)
                setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                pilihanPlayer = pilihanSuit[0]
                player.setPilihanPlayer(pilihanPlayer)
                pilihanComputer(batuCom, guntingCom, kertasCom)
                duelSuit()
                hasilSuit = hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                efekHasilSuit(textCenter, hasilSuit, suitHasil)
            }

            kertasPlayer.setOnClickListener {
                kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                pilihanPlayer = pilihanSuit[1]
                player.setPilihanPlayer(pilihanPlayer)
                pilihanComputer(batuCom, guntingCom, kertasCom)
                duelSuit()
                hasilSuit = hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                efekHasilSuit(textCenter, hasilSuit, suitHasil)
            }

            guntingPlayer.setOnClickListener {
                guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                pilihanPlayer = pilihanSuit[2]
                player.setPilihanPlayer(pilihanPlayer)
                pilihanComputer(batuCom, guntingCom, kertasCom)
                duelSuit()
                hasilSuit = hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                efekHasilSuit(textCenter, hasilSuit, suitHasil)
            }

            btnRefresh.setOnClickListener {
                setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, true)
                setClearImageView(batuCom, guntingCom, kertasCom)
                textCenter.text = originalText
                textCenter.setTextColor(originalColor)
                textCenter.setTextSize(TypedValue.COMPLEX_UNIT_SP,64f)
                textCenter.setBackgroundResource(R.drawable.bg_awal_click)
                Toast.makeText(this@MainActivity,"Main lagi Kuy",Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun duelSuit() {
        player.suit(player.getPilihanPlayer(), computer.getPilihanPlayer())
        computer.suit(computer.getPilihanPlayer(), player.getPilihanPlayer())
    }

    private fun pilihanComputer(imageView1: ImageView,imageView2: ImageView,imageView3: ImageView) {
        computer.pilihanCom(pilihanSuit)
        computer.setPilihanPlayer(computer.getPilihanCom())
        computer.efekPilihanCom(imageView1, imageView2, imageView3)
    }

    private fun setClearImageView(imageView1: ImageView, imageView2: ImageView, imageView3: ImageView) {
        imageView1.setBackgroundResource(R.drawable.bg_awal_click)
        imageView2.setBackgroundResource(R.drawable.bg_awal_click)
        imageView3.setBackgroundResource(R.drawable.bg_awal_click)
    }


    private fun efekHasilSuit(textView: TextView, hasilSuit: String, arrayhasilSuit: Array<String>) {

        when (hasilSuit) {
            arrayhasilSuit[0] ->
                textView.apply {
                    setBackgroundResource(R.drawable.bg_text_center)
                    text = hasilSuit
                    setTextColor(Color.WHITE)
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
                    Gravity.CENTER
                }


            arrayhasilSuit[1] ->
                textView.apply {
                    setBackgroundResource(R.drawable.bg_text_center)
                    text = hasilSuit
                    setTextColor(Color.WHITE)
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
                    Gravity.CENTER
                }


            arrayhasilSuit[2] ->
                textView.apply {
                    setBackgroundResource(R.drawable.bg_text_center_draw)
                    text = hasilSuit
                    setTextColor(Color.WHITE)
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
                    Gravity.CENTER
                }
        }
    }

    private fun hasilSuit(status1: Boolean, status2: Boolean, arrayhasilSuit: Array<String>): String {

        val nilaiString: String = if (status1 && !status2) {
            arrayhasilSuit[0]
        } else if (!status1 && status2) {
            arrayhasilSuit[1]
        } else {
            arrayhasilSuit[2]
        }
        return nilaiString
    }

    private fun setEnabledImageView(imageView1: ImageView, imageView2: ImageView, imageView3: ImageView, setNilai: Boolean) {
        imageView1.isEnabled = setNilai
        imageView2.isEnabled = setNilai
        imageView3.isEnabled = setNilai

        if (setNilai) {
            imageView1.isEnabled = setNilai
            imageView1.setBackgroundResource(R.drawable.bg_awal_click)
            imageView2.isEnabled = setNilai
            imageView2.setBackgroundResource(R.drawable.bg_awal_click)
            imageView3.isEnabled = setNilai
            imageView3.setBackgroundResource(R.drawable.bg_awal_click)

        }

    }
}