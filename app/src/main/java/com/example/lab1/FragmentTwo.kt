package com.example.lab1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.io.FileOutputStream

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
        //Second Fragment
        val tv: TextView = view.findViewById(R.id.tvFragmentTwo)
        val tvAnswer: TextView = view.findViewById(R.id.tvAnswer)
        val openButton: Button = view.findViewById(R.id.openButton)
        val clearTextButton: Button = view.findViewById(R.id.clearTextFileButton)
        val answerText = arguments?.getString("answer")
        val text = arguments?.getString("getInfo")
        tv.text = text
        tvAnswer.text = answerText
        clearTextButton.setOnClickListener {
            val fileName = "Example.txt"
            val fileOutputStream: FileOutputStream
            fileOutputStream = context?.openFileOutput(fileName, Context.MODE_PRIVATE)!!
            fileOutputStream.close()
            Toast.makeText(context, "File successfully cleared!", Toast.LENGTH_SHORT).show()

        }
        openButton.setOnClickListener {
           findNavController().navigate(R.id.fragmentThree)
        }
    }
}
