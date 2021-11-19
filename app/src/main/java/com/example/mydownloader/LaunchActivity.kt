package com.example.mydownloader

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LaunchActivity : AppCompatActivity() {

    private lateinit var imgAdvertisement : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        imgAdvertisement = findViewById(R.id.image_advertisement)
        GlideApp.with(this)
            .asGif()
            .load(R.drawable.launch)
            .into(imgAdvertisement)
    }
}