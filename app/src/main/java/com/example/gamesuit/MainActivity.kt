package com.example.gamesuit


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.gamesuit.databinding.ActivityMainBinding
import com.example.gamesuit.databinding.CustomLayoutBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pilihanPlayer: String
    private lateinit var hasilSuit: String
    private var simpanNama: String? = ""
    private val pilihanSuit = arrayOf("batu", "kertas", "gunting")
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
            val suitHasil = arrayOf("$simpanNama Menang", "Computer Menang", "Draw")
            val suitHasil1 = arrayOf("$simpanNama Menang", "Pemain Menang", "Draw")
            val gameMode = intent.getBooleanExtra("gameMode", false)

            if (!gameMode) {
                tagpemain2.text = "Computer"
                batuPlayer.setOnClickListener {
                    batuPlayer.setBackgroundResource(R.drawable.bg_click)
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    setPilihanPlayer(0)
                    pilihanComputer(batuCom, guntingCom, kertasCom)
                    duelSuit(false)
                    hasilSuit =
                        hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                    alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)

                }

                kertasPlayer.setOnClickListener {
                    kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    setPilihanPlayer(1)
                    pilihanComputer(batuCom, guntingCom, kertasCom)
                    duelSuit(false)
                    hasilSuit =
                        hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                    alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)

                }

                guntingPlayer.setOnClickListener {
                    guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    setPilihanPlayer(2)
                    pilihanComputer(batuCom, guntingCom, kertasCom)
                    duelSuit(false)
                    hasilSuit =
                        hasilSuit(player.getStatusMenang(), computer.getStatusMenang(), suitHasil)
                    alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)

                }

            } else {
                tagpemain2.text = "Pemain"
                setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                batuPlayer.setOnClickListener {
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    firstPlayer = false

                    if (!firstPlayer) {
                        setEnabledImageView(batuCom, kertasCom, guntingCom, true)

                        batuCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(0)
                            player2.setPilihanPlayer(pilihanSuit[0])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            batuPlayer.setBackgroundResource(R.drawable.bg_click)
                            batuCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)
                        }

                        kertasCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(0)
                            player2.setPilihanPlayer(pilihanSuit[1])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            batuPlayer.setBackgroundResource(R.drawable.bg_click)
                            kertasCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)

                        }

                        guntingCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(0)
                            player2.setPilihanPlayer(pilihanSuit[2])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            batuPlayer.setBackgroundResource(R.drawable.bg_click)
                            guntingCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)

                        }

                    }
                }

                kertasPlayer.setOnClickListener {
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    firstPlayer = false

                    if (!firstPlayer) {
                        setEnabledImageView(batuCom, kertasCom, guntingCom, true)

                        batuCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(1)
                            player2.setPilihanPlayer(pilihanSuit[0])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                            batuCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)
                        }

                        kertasCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(1)
                            player2.setPilihanPlayer(pilihanSuit[1])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                            kertasCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)
                        }

                        guntingCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(1)
                            player2.setPilihanPlayer(pilihanSuit[2])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            kertasPlayer.setBackgroundResource(R.drawable.bg_click)
                            guntingCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)
                        }

                    }

                }

                guntingPlayer.setOnClickListener {
                    setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, false)
                    firstPlayer = false

                    if (!firstPlayer) {
                        setEnabledImageView(batuCom, kertasCom, guntingCom, true)

                        batuCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(2)
                            player2.setPilihanPlayer(pilihanSuit[0])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                            batuCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)
                        }

                        kertasCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(2)
                            player2.setPilihanPlayer(pilihanSuit[1])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                            kertasCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)
                        }

                        guntingCom.setOnClickListener {
                            setEnabledImageView(batuCom, kertasCom, guntingCom, false)
                            setPilihanPlayer(2)
                            player2.setPilihanPlayer(pilihanSuit[2])
                            duelSuit(true)
                            hasilSuit = hasilSuit(
                                player.getStatusMenang(), player2.getStatusMenang(), suitHasil1
                            )
                            guntingPlayer.setBackgroundResource(R.drawable.bg_click)
                            guntingCom.setBackgroundResource(R.drawable.bg_click)
                            alertDialog(hasilSuit,batuPlayer, kertasPlayer, guntingPlayer,batuCom, guntingCom, kertasCom)
                        }

                    }

                }

            }

            btnClose.setOnClickListener {
                val intent = Intent(this@MainActivity,HomeActivity::class.java)
                intent.putExtra("simpanNama",simpanNama)
                startActivity(intent)
                finish()
            }

            btnRefresh.setOnClickListener {
                setEnabledImageView(batuPlayer, kertasPlayer, guntingPlayer, true)
                setClearImageView(batuCom, guntingCom, kertasCom)
                firstPlayer = true
            }


        }

    }

    private fun setPilihanPlayer(position: Int) {
        pilihanPlayer = pilihanSuit[position]
        player.setPilihanPlayer(pilihanPlayer)
    }

    private fun duelSuit(gameMode1: Boolean) {
        if (!gameMode1) {
            player.suit(player.getPilihanPlayer(), computer.getPilihanPlayer())
            computer.suit(computer.getPilihanPlayer(), player.getPilihanPlayer())
        } else {
            player.suit(player.getPilihanPlayer(), player2.getPilihanPlayer())
            player2.suit(player2.getPilihanPlayer(), player.getPilihanPlayer())
        }
    }

    private fun pilihanComputer(
        imageView1: ImageView, imageView2: ImageView, imageView3: ImageView
    ) {
        computer.pilihanCom(pilihanSuit)
        computer.setPilihanPlayer(computer.getPilihanCom())
        computer.efekPilihanCom(imageView1, imageView2, imageView3)
    }

    private fun setClearImageView(
        imageView1: ImageView, imageView2: ImageView, imageView3: ImageView
    ) {
        imageView1.setBackgroundResource(R.drawable.bg_awal_click)
        imageView2.setBackgroundResource(R.drawable.bg_awal_click)
        imageView3.setBackgroundResource(R.drawable.bg_awal_click)
    }


    private fun hasilSuit(
        status1: Boolean, status2: Boolean, arrayhasilSuit: Array<String>
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
        imageView1: ImageView, imageView2: ImageView, imageView3: ImageView, setNilai: Boolean
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

    private fun alertDialog(statusMenang: String, btn1: ImageView, btn2: ImageView, btn3: ImageView, btn4: ImageView, btn5: ImageView, btn6: ImageView) {
        val builder = AlertDialog.Builder(this)
        val binding: CustomLayoutBinding = CustomLayoutBinding.inflate(layoutInflater)
        builder.setView(binding.root)

        val dialog = builder.create()

        with(binding) {
            textCenter.text = statusMenang
            btnMainLagi.setOnClickListener {
                setEnabledImageView(btn1,btn2,btn3,true)
                setClearImageView(btn4, btn5, btn6)
                firstPlayer = true
                dialog.dismiss()
            }

            btnKembaliMainLagi.setOnClickListener {
                val intent = Intent(this@MainActivity,HomeActivity::class.java)
                intent.putExtra("simpanNama",simpanNama)
                startActivity(intent)
                finish()
            }
        }

        dialog.show()
    }
}