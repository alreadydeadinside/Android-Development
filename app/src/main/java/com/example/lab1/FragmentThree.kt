package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.io.File
import java.io.IOException


class FragmentThree : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataTextView: TextView = view.findViewById(R.id.dataTextView)

        try {
            val fileName = "Example.txt"
            val fileToRead = File(context?.filesDir, fileName)
            val contents = fileToRead.readText()
            if (contents.length != 0) {
                dataTextView.text = contents
            } else {
                val emptyFileMessage = "File is empty!\nPlease, fill the form and try again!"
                dataTextView.text = emptyFileMessage
            }

        } catch (e: IOException) {
            // Exception
            e.printStackTrace()
        }
    }
}
