package com.example.gamesuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.persistableBundleOf
import androidx.core.view.get
import androidx.core.view.indices
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.gamesuit.databinding.ActivityLandingPageBinding
import com.example.gamesuit.IntroSlide
import com.example.gamesuit.IntroSliderAdapter
import com.example.gamesuit.databinding.ActivityMainBinding

@Suppress("CAST_NEVER_SUCCEDS")
class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                R.drawable.ic_landing_page1,
                "Bermain suit melawan sesama pemain.",
            ),
            IntroSlide(
                R.drawable.ic_landing_page2,
                "Bermain suit melawan komputer.",
            ),
            IntroSlide(
                R.drawable.ic_landing_page3,
                "Tuliskan namamu di bawah",
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.introSliderViewPager.adapter = introSliderAdapter
        setUpIndicator()
        setCurrentIndicator(0)

        binding.introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        binding.ivNext.setOnClickListener {
            val editText = findViewById<EditText>(R.id.editText)
            val inputNama = editText.text.toString().trim()
            if (binding.introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount) {
                binding.introSliderViewPager.currentItem += 1
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                if (inputNama.isEmpty()) {
                    Toast.makeText(this, "Harap isi nama terlebih dahulu", Toast.LENGTH_SHORT).show()
                } else {
                    intent.putExtra("inputData", inputNama)
                    startActivity(intent)
                    finish()
                }
            }

        }
    }

    private fun setUpIndicator() {
        val indicator = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicator.indices) {
            indicator[i] = ImageView(applicationContext)
            indicator[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.indicatorContainer.addView(indicator[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

}

