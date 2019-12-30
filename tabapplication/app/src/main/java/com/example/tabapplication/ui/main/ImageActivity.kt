package com.example.tabapplication.ui.main

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tabapplication.R
import kotlinx.android.synthetic.main.large_image.*

class ImageActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.large_image)
        var image: ImageView = findViewById(R.id.largeImage)
        var text: TextView = findViewById(R.id.largeName)
        val intent: Intent = intent
        text.text = intent.getStringExtra("name")
        image.setImageResource(intent.getIntExtra("image",0))


    }
}