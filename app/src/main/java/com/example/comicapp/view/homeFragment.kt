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
import com.example.comicapp.model.manga
import com.example.comicapp.model.response
import com.example.comicapp.service.instance
import com.example.comicapp.view.adapter.trendingComicAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class homeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding

    lateinit var trendingRv : RecyclerView
    lateinit var trendingAdapter: trendingComicAdapter

    lateinit var data: List<manga>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getTrendingComic()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    fun getTrendingComic(){
        instance.instance.getTopManga().enqueue(object : Callback<response>{
            override fun onResponse(call: Call<response>, response: Response<response>) {
                data = response.body()!!.data
                trendingRv = binding.trendingRv
                trendingAdapter = trendingComicAdapter(data)
                trendingRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                trendingRv.adapter = trendingAdapter
            }

            override fun onFailure(call: Call<response>, t: Throwable) {
                print(t.message)
            }

        })
    }




}