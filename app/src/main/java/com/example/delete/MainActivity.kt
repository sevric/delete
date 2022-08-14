package com.example.delete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.delete.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.button.setOnClickListener {
//            startActivity(
//                Intent(
//                    this@MainActivity,
//                    ViewPagerActivity::class.java
//                )
//            )
//        }

        binding.button.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, ViewPagerFragment())
                .commit()
        }
    }
}