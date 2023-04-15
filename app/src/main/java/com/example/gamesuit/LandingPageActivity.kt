package com.example.gamesuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.gamesuit.databinding.ActivityLandingPageBinding

class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding
    private val fragments = arrayListOf(
        FirstFragmentLandingPage(),
        SecondFragmentLandingPage(),
        ThirdFragmentLandingPage()
    )

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
                    startActivity(intent)
                    finish()
                } else {
                    viewPager.currentItem = viewPager.currentItem + 1
                }
            }
            dotSelected(dot1,dot2,dot3)

        }
    }

    private fun dotSelected(
        imageDot1: ImageView,
        imageDot2: ImageView,
        imageDot3: ImageView
    ) {

        with(binding) {
            when (viewPager.currentItem) {
                0 -> {
                    imageDot1.setBackgroundResource(R.drawable.ic_landingpage_selected)
                }
                1 -> {
                    imageDot2.setBackgroundResource(R.drawable.ic_landingpage_selected)
                }
                else -> {
                    imageDot3.setBackgroundResource(R.drawable.ic_landingpage_selected)
                }
            }
        }

    }


}
