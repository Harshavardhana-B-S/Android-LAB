package com.example.wallpaper

//important imports
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.Toast
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.wpBtn

class MainActivity : AppCompatActivity() {

    private var myWallpaperList = arrayOf(R.drawable.wallpaper1,R.drawable.wallpaper2,
        R.drawable.wallpaper3,R.drawable.wallpaper4,R.drawable.wallpaper5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wpBtn.setOnClickListener { setWallpaper() }
    }

    private fun setWallpaper() {
        Toast.makeText(this,"setting wallpaper please wait.",Toast.LENGTH_SHORT).show()
        Handler().postDelayed
        ({
            for(i in myWallpaperList) {
                val pic: Bitmap = BitmapFactory.decodeResource(resources,i)
                val wM = WallpaperManager.getInstance(baseContext)
                wM.setBitmap(pic)
            }
        },2000)
    }
}