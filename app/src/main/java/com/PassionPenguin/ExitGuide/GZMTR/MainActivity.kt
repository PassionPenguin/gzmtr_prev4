package com.PassionPenguin.ExitGuide.GZMTR

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tBtnSS = findViewById<Button>(R.id.tSS)
        tBtnSS.setOnClickListener{
            startActivity(Intent(this@MainActivity,StationSelector::class.java))
        }
    }
}
