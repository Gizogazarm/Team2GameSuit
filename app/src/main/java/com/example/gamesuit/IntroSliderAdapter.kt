package com.example.gamesuit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView

class IntroSliderAdapter(private val introSlides: List<IntroSlide>) :
    RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>() {

    private var visiblePosition = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlides[position])

    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageIcon = view.findViewById<ImageView>(R.id.imageSlideIcon)
        private val textDescription = view.findViewById<TextView>(R.id.text_description)
        private var edittext = view.findViewById<EditText>(R.id.editText)

        fun bind(introSlide: IntroSlide) {
            imageIcon.setImageResource(introSlide.icon)
            textDescription.text = introSlide.description
            if (visiblePosition == adapterPosition) {
                edittext.visibility = View.VISIBLE
            } else {
                edittext.visibility = View.GONE
            }
        }
    }
}
