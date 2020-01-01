package com.example.tabapplication.ui.main.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tabapplication.R
import com.example.tabapplication.ui.main.activity.WordQuizActivity
import com.example.tabapplication.ui.main.adapter.ListAdapter
import com.example.tabapplication.ui.main.adapter.Word

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

        var wordArrayList=
            arrayListOf<Word> (

            Word("secretary", "비서"),
            Word("identification", "신분증"),
               Word("clerk", "점원"),
                Word("cliff", "절벽"),
                Word("flexable", "유연한"),
                Word("retailer", "소매상인"),
                Word("hedge", "울타리"),
                Word("apple", "사과"),
                Word("orange", "오렌지"),
                Word("grape", "포도"),
                Word("ideal", "이상적인"),
                Word("impartial", "공평한"),
                Word("accomodation", "수용"),
                Word("refrigerator", "냉장고"),
                Word("replica", "복제품")


        )

        val recyclerView: RecyclerView = view!!.findViewById(R.id.my_recycler_view)
        val adapter = ListAdapter(wordArrayList)

        var viewManager : RecyclerView.LayoutManager = LinearLayoutManager(context)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = viewManager


        val button: Button = view!!.findViewById(R.id.quizButton)
        button.setOnClickListener{
            val intent = Intent(activity, WordQuizActivity::class.java)
            intent.putParcelableArrayListExtra("wordArray", wordArrayList)
            startActivity(intent)
        }
        return view
    }


}


