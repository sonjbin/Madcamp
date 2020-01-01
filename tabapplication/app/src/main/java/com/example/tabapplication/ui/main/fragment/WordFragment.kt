package com.example.tabapplication.ui.main.fragment


import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.tabapplication.MainActivity

import com.example.tabapplication.R
import com.example.tabapplication.ui.main.activity.WordQuizActivity
import com.example.tabapplication.ui.main.adapter.Word
import kotlinx.android.parcel.Parceler
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class WordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view:View? = inflater.inflate(R.layout.fragment_word, container, false)

//        var wordArrayList=
//            arrayListOf<Word> (
//            Word("apple", "사과"),
//            Word("orange", "오렌지"),
//            Word("grape", "포도")
//
//        )



        val button: Button = view!!.findViewById(R.id.quizButton)
        button.setOnClickListener{
            val intent = Intent(activity, WordQuizActivity::class.java)
            //intent.putParcelableArrayListExtra("wordArray", wordArrayList)
            startActivity(intent)
        }
        return view
    }


}


