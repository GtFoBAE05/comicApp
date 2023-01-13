package com.example.comicapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comicapp.databinding.MostFollowedMangaLayoutBinding
import com.example.comicapp.model.manga

class mostFollowedAdapter(val data: List<manga>): RecyclerView.Adapter<mostFollowedAdapter.mostFollowedViewHolder>() {
    inner class mostFollowedViewHolder(itemView: MostFollowedMangaLayoutBinding) : RecyclerView.ViewHolder(itemView.root){
        val number:TextView = itemView.numberTv
        val image:ImageView = itemView.mostFollowedMangaImageView
        val title: TextView = itemView.mostFollowedTitleTv
        val genre: TextView = itemView.mostFollowedGenreTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mostFollowedViewHolder {
        return mostFollowedViewHolder(MostFollowedMangaLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: mostFollowedViewHolder, position: Int) {
        var imageId = ""
        val mangaId = data[position].id


        for(cover in data[position].relationships){
            if(cover.type == "cover_art"){
                imageId = cover.attributes!!.fileName.toString()
            }
        }

        for (genre in data[position].attributes!!.tags){
            if(genre.attributes!!.group.toString() == "genre"){
                holder.genre.text = genre.attributes!!.name!!.en
                break
            }
        }

        holder.number.text = position.plus(1).toString()
        holder.title.text = data[position].attributes!!.title!!.en.toString()

        val imgUrl = "https://uploads.mangadex.org/covers/${mangaId}/${imageId}"
        Glide.with(holder.itemView).load(imgUrl).fitCenter().into(holder.image)




    }

    override fun getItemCount(): Int {
        return data.size
    }
}