package com.xgt.entrega_app_fragments_contra_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xgt.entrega_app_fragments_contra_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}