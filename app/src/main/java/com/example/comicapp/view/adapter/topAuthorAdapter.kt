package com.example.comicapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.comicapp.databinding.TopAuthorLayoutBinding
import com.example.comicapp.model.author
import com.example.comicapp.model.responseAuthor

class topAuthorAdapter(val data : List<author>): RecyclerView.Adapter<topAuthorAdapter.topAuthorViewHolder>()  {
    inner class topAuthorViewHolder(itemView: TopAuthorLayoutBinding): RecyclerView.ViewHolder(itemView.root){
        val authorImage:ImageView= itemView.topAuthorImage
        val authorTv:TextView = itemView.topAuthorTv

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): topAuthorViewHolder {
        return topAuthorViewHolder(TopAuthorLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: topAuthorViewHolder, position: Int) {

        val imgUrl = "https://mangadex.org/avatar.png"

        Glide.with(holder.itemView).load(imgUrl).apply(RequestOptions.fitCenterTransform()).into(holder.authorImage)
        holder.authorTv.text = data[position].attributes.name

    }

    override fun getItemCount(): Int {
        return data.size
    }
}