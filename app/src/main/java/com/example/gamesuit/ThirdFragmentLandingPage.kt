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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragmentLandingPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragmentLandingPage : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var simpanEditText: String
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
                Log.i("simpanNama", simpanEditText)
                val bundle = Bundle()
                bundle.putString("simpanNama",simpanEditText)
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}