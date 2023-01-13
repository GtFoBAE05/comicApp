package com.example.comicapp.model

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName


data class manga(
    @SerializedName("id"            ) var id            : String?                  = null,
    @SerializedName("type"          ) var type          : String?                  = null,
    @SerializedName("attributes"    ) var attributes    : Attributes?              = Attributes(),
    @SerializedName("relationships" ) var relationships : ArrayList<Relationships> = arrayListOf()
)

data class Title (
    @SerializedName("en" ) var en : String? = null
)

data class AltTitles (
    @SerializedName("ja" ) var ja : String? = null,
)

data class Description (
    @SerializedName("en"    ) var en    : String? = null,
)

data class Links (
    @SerializedName("al"  ) var al  : String? = null,
    @SerializedName("ap"  ) var ap  : String? = null,
    @SerializedName("bw"  ) var bw  : String? = null,
    @SerializedName("kt"  ) var kt  : String? = null,
    @SerializedName("mu"  ) var mu  : String? = null,
    @SerializedName("amz" ) var amz : String? = null,
    @SerializedName("cdj" ) var cdj : String? = null,
    @SerializedName("ebj" ) var ebj : String? = null,
    @SerializedName("mal" ) var mal : String? = null,
    @SerializedName("raw" ) var raw : String? = null
)

data class Name (
    @SerializedName("en" ) var en : String? = null
)

data class AttributesOfTags (
    @SerializedName("name"        ) var name        : Name?        = Name(),
    @SerializedName("group"       ) var group       : String?      = null,
    @SerializedName("version"     ) var version     : Int?         = null
)

data class Tags (
    @SerializedName("id"            ) var id            : String?           = null,
    @SerializedName("type"          ) var type          : String?           = null,
    @SerializedName("attributes"    ) var attributes    : AttributesOfTags? = AttributesOfTags(),
    @SerializedName("relationships" ) var relationships : ArrayList<String> = arrayListOf()
)

data class Attributes (
    @SerializedName("title"                          ) var title                          : Title?               = Title(),
    @SerializedName("altTitles"                      ) var altTitles                      : ArrayList<AltTitles> = arrayListOf(),
    @SerializedName("description"                    ) var description                    : Description?         = Description(),
    @SerializedName("isLocked"                       ) var isLocked                       : Boolean?             = null,
    @SerializedName("links"                          ) var links                          : Links?               = Links(),
    @SerializedName("originalLanguage"               ) var originalLanguage               : String?              = null,
    @SerializedName("lastVolume"                     ) var lastVolume                     : String?              = null,
    @SerializedName("lastChapter"                    ) var lastChapter                    : String?              = null,
    @SerializedName("publicationDemographic"         ) var publicationDemographic         : String?              = null,
    @SerializedName("status"                         ) var status                         : String?              = null,
    @SerializedName("year"                           ) var year                           : Int?                 = null,
    @SerializedName("contentRating"                  ) var contentRating                  : String?              = null,
    @SerializedName("tags"                           ) var tags                           : ArrayList<Tags>      = arrayListOf(),
    @SerializedName("state"                          ) var state                          : String?              = null,
    @SerializedName("chapterNumbersResetOnNewVolume" ) var chapterNumbersResetOnNewVolume : Boolean?             = null,
    @SerializedName("createdAt"                      ) var createdAt                      : String?              = null,
    @SerializedName("updatedAt"                      ) var updatedAt                      : String?              = null,
    @SerializedName("version"                        ) var version                        : Int?                 = null,
    @SerializedName("availableTranslatedLanguages"   ) var availableTranslatedLanguages   : ArrayList<String>    = arrayListOf(),
    @SerializedName("latestUploadedChapter"          ) var latestUploadedChapter          : String?              = null
)

data class AttributesOfCoverArt(
    @SerializedName("name"      ) var name      : String?    = null,
    @SerializedName("description") var description : String? = null,
    @SerializedName("volume") var volume : Int? = null,
    @SerializedName("fileName") var fileName : String? = null,
    @SerializedName("locale") var locale : String? = null,
    @SerializedName("createdAt") var createdAt : String? = null,
    @SerializedName("updatedAt") var updatedAt : String? = null,
    @SerializedName("version") var version : Int? = null,
    )

data class Relationships (
    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("type" ) var type : String? = null,
    @SerializedName("attributes") var attributes: AttributesOfCoverArt? = null
)

