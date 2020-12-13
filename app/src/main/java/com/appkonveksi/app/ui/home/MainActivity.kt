package com.appkonveksi.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appkonveksi.app.R
import com.appkonveksi.app.databinding.ActivityMainBinding
import com.appkonveksi.app.ui.auth.AppKonveksiAuth
import com.appkonveksi.app.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            AppKonveksiAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java
                ))
                finish()
            }
        }
    }
}