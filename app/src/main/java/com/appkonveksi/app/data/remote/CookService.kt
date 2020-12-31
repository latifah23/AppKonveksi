package com.appkonveksi.app.data.remote

import com.appkonveksi.app.data.model.CookList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CookService {
    @GET("/api/recipes")
    fun listCook() : Call<CookList>

    @GET("/api/categorys/recipes/:key")
    fun detailCook(@Query("category")category: String) : Call<CookList>

    @GET("/api/search/?q=parameter")
    fun searchCook(@Query("q")query: String) : Call<CookList>
}