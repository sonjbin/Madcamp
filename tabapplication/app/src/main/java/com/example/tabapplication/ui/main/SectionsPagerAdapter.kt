package com.example.tabapplication.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tabapplication.R


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                NumberFragment()
            }
            1->{
                GalleryFragment()
            }
            else -> {
                return MapFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Address Book"
            1 -> "Gallery"
            else -> {
                return "Map"
            }
        }
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}