package com.example.gamesuit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.gamesuit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pilihanPlayer: String
    private lateinit var hasilSuit: String
    private var simpanNama: String? = ""
    private val pilihanSuit = arrayOf("batu", "kertas", "gunting")
    private val suitHasil = arrayOf("Pemain Menang", "Computer Menang", "Draw")
    private var firstPlayer = true
    private val player = Player()
    private val computer = Computer()
    private val player2 = Player()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {

            simpanNama = intent.getStringExtra("simpanNama")
            Glide.with(this@MainActivity).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
                .into(imageGlideMain)
            tagpemain.text = simpanNama

            val gameMode = intent.getBooleanExtra("gameMode", false)
            if (!gameMode) {
                tagpemain2.text = "Computer"
                batuPlayer.setOnClickListener {
                    batuPlayer.setBackgroundResource(R.drawable.bg_click)
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    pilihanPlayer = pilihanSuit[0]
                    player.setPilihanPlayer(pilihanPlayer)
                    pilihanComputer(batuCom, guntingCom, kertasCom)
                    duelSuit(false)
                    hasilSuit =
                        hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                    Log.d("pemenang", hasilSuit)

                }

                kertasPlayer.setOnClickListener {
                    kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    pilihanPlayer = pilihanSuit[1]
                    player.setPilihanPlayer(pilihanPlayer)
                    pilihanComputer(batuCom, guntingCom, kertasCom)
                    duelSuit(false)
                    hasilSuit =
                        hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                    Log.d("pemenang", hasilSuit)
                }

                guntingPlayer.setOnClickListener {
                    guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    pilihanPlayer = pilihanSuit[2]
                    player.setPilihanPlayer(pilihanPlayer)
                    pilihanComputer(batuCom, guntingCom, kertasCom)
                    duelSuit(false)
                    hasilSuit =
                        hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                    Log.d("pemenang", hasilSuit)

                }

            } else {
                tagpemain2.text = "Pemain"
                setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                batuPlayer.setOnClickListener {
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    pilihanPlayer = pilihanSuit[0]
                    player.setPilihanPlayer(pilihanPlayer)
                    firstPlayer = false

                    if (!firstPlayer) {
                        setEnabledImageView(batuCom, kertasCom, guntingCom, true)

                        batuCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[0])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            batuPlayer.setBackgroundResource(R.drawable.bg_click)
                            batuCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                        kertasCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[1])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            batuPlayer.setBackgroundResource(R.drawable.bg_click)
                            kertasCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                        guntingCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[2])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            batuPlayer.setBackgroundResource(R.drawable.bg_click)
                            guntingCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                    }
                }

                kertasPlayer.setOnClickListener {
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    pilihanPlayer = pilihanSuit[1]
                    player.setPilihanPlayer(pilihanPlayer)
                    firstPlayer = false

                    if (!firstPlayer) {
                        setEnabledImageView(batuCom, kertasCom, guntingCom, true)

                        batuCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[0])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                            batuCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                        kertasCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[1])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                            kertasCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                        guntingCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[2])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                            guntingCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                    }

                }

                guntingPlayer.setOnClickListener {
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    pilihanPlayer = pilihanSuit[2]
                    player.setPilihanPlayer(pilihanPlayer)
                    firstPlayer = false

                    if (!firstPlayer) {
                        setEnabledImageView(batuCom, kertasCom, guntingCom, true)

                        batuCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[0])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                            batuCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                        kertasCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[1])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                            kertasCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                        guntingCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            player2.setPilihanPlayer(pilihanSuit[2])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(),
                                player2.getStatusMenang(),
                                suitHasil
                            )
                            guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                            guntingCom.setBackgroundResource(R.drawable.bg_click)
                            Log.d("pemenang", hasilSuit)
                        }

                    }

                }

            }


            btnRefresh.setOnClickListener {
                setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, true)
                setClearImageView(batuCom, guntingCom, kertasCom)
                firstPlayer = true
                Toast.makeText(this@MainActivity, "Main lagi Kuy", Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun duelSuit(gameMode1: Boolean) {
        if (!gameMode1) {
            player.suit(player.getPilihanPlayer(), computer.getPilihanPlayer())
            computer.suit(computer.getPilihanPlayer(), player.getPilihanPlayer())
        } else {
            player.suit(player.getPilihanPlayer(), player2.getPilihanPlayer())
            player2.suit(player.getPilihanPlayer(), player2.getPilihanPlayer())
        }
    }

    private fun pilihanComputer(
        imageView1: ImageView,
        imageView2: ImageView,
        imageView3: ImageView
    ) {
        computer.pilihanCom(pilihanSuit)
        computer.setPilihanPlayer(computer.getPilihanCom())
        computer.efekPilihanCom(imageView1, imageView2, imageView3)
    }

    private fun setClearImageView(
        imageView1: ImageView,
        imageView2: ImageView,
        imageView3: ImageView
    ) {
        imageView1.setBackgroundResource(R.drawable.bg_awal_click)
        imageView2.setBackgroundResource(R.drawable.bg_awal_click)
        imageView3.setBackgroundResource(R.drawable.bg_awal_click)
    }


    private fun hasilSuit(
        status1: Boolean,
        status2: Boolean,
        arrayhasilSuit: Array<String>
    ): String {

        val nilaiString: String = if (status1 && !status2) {
            arrayhasilSuit[0]
        } else if (!status1 && status2) {
            arrayhasilSuit[1]
        } else {
            arrayhasilSuit[2]
        }
        return nilaiString
    }

    private fun setEnabledImageView(
        imageView1: ImageView,
        imageView2: ImageView,
        imageView3: ImageView,
        setNilai: Boolean
    ) {
        imageView1.isEnabled = setNilai
        imageView2.isEnabled = setNilai
        imageView3.isEnabled = setNilai

        if (setNilai) {
            imageView1.setBackgroundResource(R.drawable.bg_awal_click)
            imageView2.setBackgroundResource(R.drawable.bg_awal_click)
            imageView3.setBackgroundResource(R.drawable.bg_awal_click)
        }

    }
}