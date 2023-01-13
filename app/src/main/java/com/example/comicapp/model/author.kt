package com.example.comicapp.model

import com.google.gson.annotations.SerializedName

data class author(
    @SerializedName("id"            ) var id            : String?                  = null,
    @SerializedName("type"          ) var type          : String?                  = null,
    @SerializedName("attributes"    ) var attributes    : AttributesOfAuthor       = AttributesOfAuthor(),
    @SerializedName("relationships" ) var relationships : ArrayList<Relationships> = arrayListOf()
)

data class Biography (
    @SerializedName("en") var en : String?=null

)

data class AttributesOfAuthor (
    @SerializedName("name"      ) var name      : String?    = null,
    @SerializedName("imageUrl"  ) var imageUrl  : String?    = null,
    @SerializedName("biography" ) var biography : Biography? = Biography(),
    @SerializedName("twitter"   ) var twitter   : String?    = null,
    @SerializedName("pixiv"     ) var pixiv     : String?    = null,
    @SerializedName("melonBook" ) var melonBook : String?    = null,
    @SerializedName("fanBox"    ) var fanBox    : String?    = null,
    @SerializedName("booth"     ) var booth     : String?    = null,
    @SerializedName("nicoVideo" ) var nicoVideo : String?    = null,
    @SerializedName("skeb"      ) var skeb      : String?    = null,
    @SerializedName("fantia"    ) var fantia    : String?    = null,
    @SerializedName("tumblr"    ) var tumblr    : String?    = null,
    @SerializedName("youtube"   ) var youtube   : String?    = null,
    @SerializedName("weibo"     ) var weibo     : String?    = null,
    @SerializedName("naver"     ) var naver     : String?    = null,
    @SerializedName("website"   ) var website   : String?    = null,
    @SerializedName("createdAt" ) var createdAt : String?    = null,
    @SerializedName("updatedAt" ) var updatedAt : String?    = null,
    @SerializedName("version"   ) var version   : Int?       = null
)


