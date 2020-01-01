package com.example.tabapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tabapplication.ui.main.adapter.NumberAdapter
import com.example.tabapplication.ui.main.adapter.SectionsPagerAdapter
import com.example.tabapplication.ui.main.adapter.SwipeToDeleteCallback
import com.example.tabapplication.ui.main.fragment.NumberFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_gallery.*


class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)?.setIcon(R.drawable.ic_perm_identity_24px)
        tabs.getTabAt(1)?.setIcon(R.drawable.ic_photo_library_24px)
        tabs.getTabAt(2)?.setIcon(R.drawable.ic_map_24px)
    }

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
