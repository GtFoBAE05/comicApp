package com.example.comicapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicapp.R
import com.example.comicapp.databinding.FragmentHomeBinding
import com.example.comicapp.model.author
import com.example.comicapp.model.manga
import com.example.comicapp.model.responseAuthor
import com.example.comicapp.model.responseManga
import com.example.comicapp.service.instance
import com.example.comicapp.view.adapter.topAuthorAdapter
import com.example.comicapp.view.adapter.highestRatingAdapter
import com.example.comicapp.view.adapter.mostFollowedAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class homeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding

    lateinit var trendingRv : RecyclerView
    lateinit var trendingAdapter: highestRatingAdapter

    lateinit var mostFollowedRv : RecyclerView
    lateinit var mostFollowedAdapter : mostFollowedAdapter

    lateinit var topAuthorRv: RecyclerView
    lateinit var topAuthorAdapter: topAuthorAdapter

    lateinit var trendingMangaData: List<manga>
    lateinit var mostFollowedMangaData: List<manga>
    lateinit var topAuthorData: List<author>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getTrendingManga()
        getMostFollowedManga()
        getTopAuthor()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    fun getTrendingManga(){
        instance.instance.getTopRatingManga().enqueue(object : Callback<responseManga>{
            override fun onResponse(call: Call<responseManga>, response: Response<responseManga>) {
                trendingMangaData = response.body()!!.data
                trendingRv = binding.highestRatingRv
                trendingAdapter = highestRatingAdapter(trendingMangaData)
                trendingRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                trendingRv.adapter = trendingAdapter
            }

            override fun onFailure(call: Call<responseManga>, t: Throwable) {
                print(t.message)
            }

        })
    }

    fun getMostFollowedManga(){
        instance.instance.getMostFollowedManga().enqueue(object : Callback<responseManga>{
            override fun onResponse(call: Call<responseManga>, response: Response<responseManga>) {
                mostFollowedMangaData = response.body()!!.data
                mostFollowedRv = binding.mostFollowedRv
                mostFollowedAdapter = mostFollowedAdapter(mostFollowedMangaData)
                mostFollowedRv.adapter = mostFollowedAdapter
                mostFollowedRv.layoutManager = LinearLayoutManager(context)
            }

            override fun onFailure(call: Call<responseManga>, t: Throwable) {
                print(t)
            }

        })
    }


    fun getTopAuthor(){
        instance.instance.getTopAuthor().enqueue(object : Callback<responseAuthor>{
            override fun onResponse(
                call: Call<responseAuthor>,
                response: Response<responseAuthor>
            ) {
                topAuthorData = response.body()!!.data

                topAuthorRv = binding.topAuthorRv
                topAuthorAdapter = topAuthorAdapter(topAuthorData)
                topAuthorRv.adapter = topAuthorAdapter
                topAuthorRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

            }

            override fun onFailure(call: Call<responseAuthor>, t: Throwable) {
                print(t)
            }
        })
    }





}