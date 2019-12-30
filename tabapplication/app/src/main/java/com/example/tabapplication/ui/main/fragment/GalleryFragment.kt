package com.example.tabapplication.ui.main.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tabapplication.R
import com.example.tabapplication.R.layout.fragment_gallery
import com.example.tabapplication.ui.main.adapter.GalleryImageAdapter
import com.example.tabapplication.ui.main.adapter.GalleryImageClickListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thesimplycoder.imagegallery.adapter.Image
import kotlinx.android.synthetic.main.fragment_gallery.*


class GalleryFragment : Fragment(), GalleryImageClickListener {

    private var SPAN_COUNT = 3
    private val imageList = java.util.ArrayList<Image>()
    lateinit var galleryAdapter: GalleryImageAdapter


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
        galleryAdapter = GalleryImageAdapter(imageList)
        galleryAdapter.listener = this

        loadImages()
        var recyclerview: RecyclerView =  view.findViewById(R.id.recyclerView)
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            SPAN_COUNT = 4
        }
        recyclerview.layoutManager = GridLayoutManager(context, SPAN_COUNT)
        recyclerview.adapter = galleryAdapter
        //가로모드인 경우 col수 4개로 바꿈

        val mFab: FloatingActionButton = view.findViewById(R.id.addButton)
        mFab.setOnClickListener{
            Toast.makeText(context,"AAAA",Toast.LENGTH_LONG).show()
        }

        return view
    }

    override fun onClick(position: Int) {

        val bundle = Bundle()
        bundle.putSerializable("images",imageList)
        bundle.putInt("position",position)

        val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        val galleryFullFragment = GalleryFullscreenFragment()
        galleryFullFragment.setArguments(bundle)
        galleryFullFragment.show(fragmentTransaction,"gallery")
    }




    private fun loadImages(){
        imageList.add(Image("Christmas", R.drawable.christmas))
        imageList.add(Image("Gift",R.drawable.gift))
        imageList.add(Image("Branch",R.drawable.branch))
        imageList.add(Image("City",R.drawable.city))
        imageList.add(Image("Road",R.drawable.road))
        imageList.add(Image("Snowman",R.drawable.snowman))
        imageList.add(Image("Autoradio",R.drawable.autoradio))
        imageList.add(Image("Autumn",R.drawable.autumn))
        imageList.add(Image("Card",R.drawable.christmas_card))
        imageList.add(Image("Crocus",R.drawable.crocus))
        imageList.add(Image("Fantasy",R.drawable.fantasy))
        imageList.add(Image("Fox",R.drawable.fox))
        imageList.add(Image("Landscape",R.drawable.landscape))
        imageList.add(Image("Locomotive",R.drawable.locomotive))
        imageList.add(Image("Parrot",R.drawable.parrot))
        imageList.add(Image("Switzerland",R.drawable.switzerland))
        imageList.add(Image("Occasion",R.drawable.the_occasion_of_christmas))
        imageList.add(Image("Town",R.drawable.town_alley))
        imageList.add(Image("Cat",R.drawable.cat))
        imageList.add(Image("Winter",R.drawable.winter))

        galleryAdapter.notifyDataSetChanged()
    }

}









