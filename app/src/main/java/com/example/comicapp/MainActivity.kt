package com.example.comicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.comicapp.databinding.ActivityMainBinding
import com.example.comicapp.model.manga
import com.example.comicapp.model.response
import com.example.comicapp.service.instance
import com.example.comicapp.view.homeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    lateinit var fl:FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fl = binding.framelayout
        val homeFragment = homeFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout, homeFragment)
            commit()
        }

    }









}