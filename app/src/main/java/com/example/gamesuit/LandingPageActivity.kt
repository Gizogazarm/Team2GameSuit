package com.example.gamesuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamesuit.databinding.ActivityLandingPageBinding

class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val fragments = arrayListOf(FirstFragmentLandingPage(),SecondFragmentLandingPage(),ThirdFragmentLandingPage())
            val adapter = ViewPagerAdapter(fragments,supportFragmentManager,lifecycle)
            viewPager.adapter= adapter
        }

    }
}