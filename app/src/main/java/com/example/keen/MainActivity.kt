package com.example.keen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToHomeActivity()
    }

    private fun goToHomeActivity (){
        startActivity(Intent(this@MainActivity , HomeActivity::class.java))
        finish()
    }

}