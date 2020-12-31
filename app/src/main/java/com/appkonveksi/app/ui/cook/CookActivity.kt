package com.appkonveksi.app.ui.cook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appkonveksi.app.R

class CookActivity : AppCompatActivity() {

    companion object {
        const val OPEN_COOK = "open_cook"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cook)
    }
}