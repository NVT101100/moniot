package com.example.moniot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var manhinhdieukhien= Intent(this,dieukhien::class.java)
        var manhinhthongtin= Intent(this,thongtin::class.java)
        val iconifomationnhe = findViewById<ImageView>(R.id.iconifomationnhe)
        val iconsettingnhe = findViewById<ImageView>(R.id.iconsettingnhe)
        iconifomationnhe.setOnClickListener(){
            startActivity(manhinhthongtin)
        }
        iconsettingnhe.setOnClickListener(){
            startActivity(manhinhdieukhien)
        }

    }

}