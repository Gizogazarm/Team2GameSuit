package com.example.gamesuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.gamesuit.databinding.ActivityLandingPageBinding


class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding
    private val fragments = arrayListOf(
        FirstFragmentLandingPage(),
        SecondFragmentLandingPage(),
        ThirdFragmentLandingPage()
    )
    private val thirdFragment = ThirdFragmentLandingPage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val adapter = ViewPagerAdapter(fragments, supportFragmentManager, lifecycle)
            viewPager.adapter = adapter

            btnLandingpage.setOnClickListener {
                val currentItem = viewPager.currentItem
                if (currentItem == fragments.size - 1) {
                    val intent = Intent(this@LandingPageActivity, MainActivity::class.java)
                    val hasilSimpan = thirdFragment.setSimpanEditText()
                    intent.putExtra("simpanNama",hasilSimpan)
                    Toast.makeText(this@LandingPageActivity, "Selamat Datang $hasilSimpan", Toast.LENGTH_LONG).show()
                    Log.i("nilaihasilsimpan", "$hasilSimpan")
                    startActivity(intent)
                    finish()
                } else {
                    viewPager.currentItem = viewPager.currentItem + 1
                }
            }

            viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    dotSelected(position)
                }
            })
        }
    }

    private fun dotSelected(position: Int) {

        with(binding) {
            when (position) {
                0 -> {
                    dot1.setImageResource(R.drawable.ic_landingpage_selected)
                    dot2.setImageResource(R.drawable.ic_landingpage_viewpager)
                    dot3.setImageResource(R.drawable.ic_landingpage_viewpager)
                }
                1 -> {
                    dot1.setImageResource(R.drawable.ic_landingpage_viewpager)
                    dot2.setImageResource(R.drawable.ic_landingpage_selected)
                    dot3.setImageResource(R.drawable.ic_landingpage_viewpager)
                }
                else -> {
                    dot1.setImageResource(R.drawable.ic_landingpage_viewpager)
                    dot2.setImageResource(R.drawable.ic_landingpage_viewpager)
                    dot3.setImageResource(R.drawable.ic_landingpage_selected)
                }
            }
        }


    }


}
