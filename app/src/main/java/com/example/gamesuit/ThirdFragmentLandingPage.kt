package com.example.gamesuit

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gamesuit.databinding.FragmentThirdLandingPageBinding



class ThirdFragmentLandingPage : Fragment() {
    // TODO: Rename and change types of parameters
    private var simpanEditText: String? = null
    private var _binding:FragmentThirdLandingPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdLandingPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.inputEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                simpanEditText=p0.toString()
                Log.i("simpanNama", simpanEditText!!)
                getSimpanEditText(simpanEditText!!)
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun getSimpanEditText(coba:String) {
       simpanEditText = coba

    }

    fun setSimpanEditText(): String? {
        return simpanEditText
    }


}