package com.example.tabapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tabapplication.R
import com.example.tabapplication.ui.main.fragment.DictionaryFragment
import com.example.tabapplication.ui.main.fragment.User
import kotlinx.android.synthetic.main.item_dictionary.view.*

class ListAdapter(val context:  ArrayList<User>): RecyclerView.Adapter<ListAdapter.UserViewHolder>() {

    override fun getItemCount(): Int {return context.size}
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userNameText.text =
            context[position].eng_word
        holder.userPhoneText.text =
            context[position].kor_word
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val holder = UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_dictionary,
                parent,
                false
            )
        )

        return holder
    }

    class UserViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        val userNameText = root.eng_word
        val userPhoneText = root.kor_word
    }
}