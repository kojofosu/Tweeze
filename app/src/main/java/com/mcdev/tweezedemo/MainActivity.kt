package com.mcdev.tweezedemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mcdev.tweeze.TwitterUsernameView
import com.mcdev.tweezedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        binding.tuv.username = "kofi_Moley"
        binding.tuv.textView.setTextColor(Color.GREEN)
        Log.d(TAG, "onCreate: username is : ${binding.tuv.username}")
        Log.d(TAG, "onCreate: username without at symbol is : ${binding.tuv.usernameWithoutSymbol}")
    }
}