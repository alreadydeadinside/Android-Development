package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class FragmentOne : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById(R.id.ok_button)
        val inputText: EditText = view.findViewById(R.id.editText)
        val bundle = Bundle()
        val rg: RadioGroup = view.findViewById(R.id.radioGroupButton)


        button.setOnClickListener {
            val question = inputText.text
            val getQuestion = "Your Question is: $question"
            val selectedId = rg.checkedRadioButtonId
            if (question.isEmpty() || selectedId == -1) {
                Toast.makeText(context,"You should enter all information", Toast.LENGTH_SHORT).show()
            }else{
                val answer: RadioButton = view.findViewById(selectedId)
                val getAnswer = answer.text
                val parseAnswer = "Your answer is: $getAnswer"
                bundle.putString("answer", parseAnswer)
                bundle.putString("getInfo", getQuestion)
                findNavController().navigate(R.id.fragmentTwo, bundle)
            }
        }
    }
}