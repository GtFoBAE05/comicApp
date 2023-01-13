package com.example.comicapp.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comicapp.databinding.HighestRatingLayoutBinding
import com.example.comicapp.model.manga

class highestRatingAdapter(val data:List<manga>):RecyclerView.Adapter<highestRatingAdapter.trendingViewHolder>() {
    inner class trendingViewHolder(itemView: HighestRatingLayoutBinding):RecyclerView.ViewHolder(itemView.root){

        val imageCover:ImageView = itemView.imageView
        val title:TextView = itemView.title
        val author:TextView = itemView.author

        init {
            itemView.root.setOnClickListener {
                Toast.makeText(itemView.root.context,title.text, Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): trendingViewHolder {
        return trendingViewHolder(HighestRatingLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: trendingViewHolder, position: Int) {

        var imageId = ""
        var author =""
        for(cover in data[position].relationships){
            if(cover.type == "author"){
                author = cover.attributes!!.name.toString()
            }

            if(cover.type == "cover_art"){
                imageId = cover.attributes!!.fileName.toString()
            }
        }

        var mangaId = data[position].id.toString()

        var imgUrl = "https://uploads.mangadex.org/covers/${mangaId}/${imageId}"

        print(imgUrl)
        Glide.with(holder.itemView).load(imgUrl).into(holder.imageCover)

        holder.title.text = data[position].attributes!!.title!!.en
        holder.author.text = author
    }

    override fun getItemCount(): Int {
        return data.size
    }
}