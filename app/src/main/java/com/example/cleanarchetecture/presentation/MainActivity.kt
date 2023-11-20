package com.example.cleanarchetecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchetecture.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm : MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.e("AAA", "Activity created")

        vm.resultLive.observe(this) { text ->
            binding.tvNoData.text = text
        }

        binding.btnSaveData.setOnClickListener {
            val text = binding.edPutData.text.toString()
            vm.save(text)
            vm.resultLive
        }
        binding.btnGetData.setOnClickListener {
            vm.load()
        }

    }
} 