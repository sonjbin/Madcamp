package com.example.tabapplication.ui.main.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tabapplication.R
import com.example.tabapplication.ui.main.adapter.ListAdapter

/**
 * A simple [Fragment] subclass.
 */
class DictionaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view:View? = inflater.inflate(R.layout.fragment_dictionary_card, container, false)

        var userList = arrayListOf<User>(
            User("apple","사과"),
            User("박채연","할말이 없다"),
            User("박서연","ㄷ"),
            User("박태욱","ㅁㄴㅇㄹ"),
            User("김민식","ㅇㅁㄴㄹ!"),
            User("이소명","아령dsafsdf!"),
            User("한규언","afsdf!"),
            User("정빈","ㅁㄴㅇㄹ"),
            User("김태양","아ㅇ잇!")
        )

//        private lateinit var viewAdapter: RecyclerView.Adapter<*>
//        adapter = viewAdapter


        val recyclerView: RecyclerView = view!!.findViewById(R.id.my_recycler_view)
        val adapter = ListAdapter(userList)

        var viewManager : RecyclerView.LayoutManager = LinearLayoutManager(context)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = viewManager
        return view
    }
//
//    data class Contact(val eng_word: String, val kor_word: String)


//    private var UserList = arrayListOf<User>()
//    var UserList = arrayListOf<User>()






}
