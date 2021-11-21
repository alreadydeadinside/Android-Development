package com.example.lab1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.io.FileNotFoundException
import java.io.FileOutputStream


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

        val bundle = Bundle()
        val button: Button = view.findViewById(R.id.ok_button)
        val inputText: EditText = view.findViewById(R.id.editText)
        val rg: RadioGroup = view.findViewById(R.id.radioGroupButton)

        button.setOnClickListener {
            val question = inputText.text
            val displayQuestion = "Your Question is: $question"
            val selectedId = rg.checkedRadioButtonId
            if (question.isEmpty() || selectedId == -1) {
                Toast.makeText(context,"You should enter all information", Toast.LENGTH_SHORT).show()
            }else{
                val answer: RadioButton = view.findViewById(selectedId)
                val getAnswer = answer.text
                val displayAnswer = "Your answer is: $getAnswer"
                val fileName = "Example.txt"
                val mainText:String = question.toString()
                val secondaryText:String = getAnswer.toString()
                val fileOutputStream: FileOutputStream
                try {
                    fileOutputStream = context?.openFileOutput(fileName, Context.MODE_PRIVATE)!!
                    fileOutputStream.write(mainText.toByteArray())
                    fileOutputStream.write(secondaryText.toByteArray())
                    Toast.makeText(context, "Saved to ${fileName}", Toast.LENGTH_SHORT).show()
                }catch (e: Exception){
                    e.printStackTrace()
                }catch (e: FileNotFoundException){
                    e.printStackTrace()
                }
                bundle.putString("answer", displayAnswer)
                bundle.putString("getInfo", displayQuestion)
                findNavController().navigate(R.id.fragmentTwo, bundle)
            }
        }
    }
}