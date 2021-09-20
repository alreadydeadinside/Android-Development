package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentTwo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tv : TextView = view.findViewById(R.id.tvFragmentTwo)
        val tvAnswer: TextView = view.findViewById(R.id.tvAnswer)
        val answerText = arguments?.getString("answer")
        val text = arguments?.getString("getInfo")
        tv.text = text
        tvAnswer.text = answerText
    }
}