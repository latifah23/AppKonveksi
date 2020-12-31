package com.appkonveksi.app.data.model

data class CookList (

    val method : String = "",
    val status: Boolean = true,
    val results: List<Cook> = arrayListOf()

)