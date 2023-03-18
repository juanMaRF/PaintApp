package com.juanrivera.paintapp.ui

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.juanrivera.paintapp.ui.PainView.Companion.colorList
import com.juanrivera.paintapp.ui.PainView.Companion.currentBrush
import com.juanrivera.paintapp.ui.PainView.Companion.pathList
import com.juanrivera.paintapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        var path = Path()
        var paintBrush = Paint()
    }

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()

        val redBtn = findViewById<ImageButton>(mainBinding.redColor.id)
        val blueBtn = findViewById<ImageButton>(mainBinding.blueColor.id)
        val blackBtn = findViewById<ImageButton>(mainBinding.blackColor.id)
        val eraser = findViewById<ImageButton>(mainBinding.whiteColor.id)

        redBtn.setOnClickListener{
            Toast.makeText(this,"Rojo",Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.RED)
            currentColor(paintBrush.color)
        }
        blueBtn.setOnClickListener {
            Toast.makeText(this,"Azul",Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.BLUE)
            currentColor(paintBrush.color)
        }
        blackBtn.setOnClickListener {
            Toast.makeText(this,"Negro",Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.BLACK)
            currentColor(paintBrush.color)
        }
        eraser.setOnClickListener {
            Toast.makeText(this,"Borrado",Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }
}