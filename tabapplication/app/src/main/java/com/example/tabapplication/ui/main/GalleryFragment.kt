package com.example.tabapplication.ui.main


import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Context
import android.content.res.Configuration
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.GridView

import com.example.tabapplication.R
import com.example.tabapplication.R.layout.fragment_gallery
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.photo_entry.view.*



class GalleryFragment : Fragment() {
    var adapter: PhotoAdapter? = null
    var photosList = ArrayList<Photo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photosList.add(Photo("Christmas",R.drawable.christmas))
        photosList.add(Photo("Gift",R.drawable.gift))
        photosList.add(Photo("Branch",R.drawable.branch))
        photosList.add(Photo("City",R.drawable.city))
        photosList.add(Photo("Road",R.drawable.road))
        photosList.add(Photo("Snowman",R.drawable.snowman))
        photosList.add(Photo("Autoradio",R.drawable.autoradio))
        photosList.add(Photo("Autumn",R.drawable.autumn))
        photosList.add(Photo("Card",R.drawable.christmas_card))
        photosList.add(Photo("Crocus",R.drawable.crocus))
        photosList.add(Photo("Fantasy",R.drawable.fantasy))
        photosList.add(Photo("Fox",R.drawable.fox))
        photosList.add(Photo("Landscape",R.drawable.landscape))
        photosList.add(Photo("Locomotive",R.drawable.locomotive))
        photosList.add(Photo("Parrot",R.drawable.parrot))
        photosList.add(Photo("Switzerland",R.drawable.switzerland))
        photosList.add(Photo("Occasion",R.drawable.the_occasion_of_christmas))
        photosList.add(Photo("Town",R.drawable.town_alley))
        photosList.add(Photo("Cat",R.drawable.cat))
        photosList.add(Photo("Winter",R.drawable.winter))

        adapter = PhotoAdapter(context,this, this.photosList)


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(
            fragment_gallery,
            container,
            false
        )
        var gridview: GridView =  view.findViewById(R.id.myGridView)
        gridview.adapter = adapter
        //가로모드인 경우 col수 3개로 바꿈
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridview.numColumns = 3
        }
        return view
    }
}

class PhotoAdapter: BaseAdapter {

    var photosList = ArrayList<Photo>()
    var context: Context? = null
    var fragment: GalleryFragment? = null
    constructor(context: Context?, fragment: GalleryFragment?, photosList: ArrayList<Photo>) : super() {
        this.context = context
        this.fragment = fragment
        this.photosList = photosList
    }

    override fun getCount(): Int {
        return photosList.size
    }

    override fun getItem(position: Int): Any {
        return photosList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val photo = this.photosList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var photoView = inflator.inflate(R.layout.photo_entry, null)
        photoView.img.setImageResource(photo.image!!)
        photoView.textName.text = photo.name!!

        return photoView
    }
}








