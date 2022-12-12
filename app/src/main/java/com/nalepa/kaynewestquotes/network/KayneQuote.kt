package com.nalepa.kaynewestquotes.network

import com.squareup.moshi.Json

data class KayneQuote(
        @Json(name = "quote") val quote: String
)