package com.example.comicapp.model

import com.google.gson.annotations.SerializedName

data class responseManga(
    @SerializedName("result"   ) var result   : String?         = null,
    @SerializedName("response" ) var response : String?         = null,
    @SerializedName("data"     ) var data     : ArrayList<manga> = arrayListOf(),
    @SerializedName("limit"    ) var limit    : Int?            = null,
    @SerializedName("offset"   ) var offset   : Int?            = null,
    @SerializedName("total"    ) var total    : Int?            = null
)

data class responseAuthor(
    @SerializedName("result"   ) var result   : String?         = null,
    @SerializedName("response" ) var response : String?         = null,
    @SerializedName("data"     ) var data     : ArrayList<author> = arrayListOf(),
    @SerializedName("limit"    ) var limit    : Int?            = null,
    @SerializedName("offset"   ) var offset   : Int?            = null,
    @SerializedName("total"    ) var total    : Int?            = null
)

