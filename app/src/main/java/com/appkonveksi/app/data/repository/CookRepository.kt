package com.appkonveksi.app.data.repository


import com.appkonveksi.app.data.model.ActionState
import com.appkonveksi.app.data.model.Cook
import com.appkonveksi.app.data.remote.CookService
import com.appkonveksi.app.data.remote.RetrofitApi
import retrofit2.await

class CookRepository {
    private val cookService: CookService by lazy{
        RetrofitApi.cookService()
    }

    suspend fun listCook() : ActionState<List<Cook>>{
        return try {
            val list = cookService.listCook().await()
            ActionState(list.results)
        }catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun categoryCook(category: String) : ActionState<Cook>{
        return try {
            val list = cookService.detailCook(category ).await()
            ActionState(list.results.first())
        }catch (e:Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchCook(query: String) : ActionState<List<Cook>> {
        return try{
            val list = cookService.searchCook(query).await()
            ActionState(list.results)
        }catch (e:Exception){
            ActionState(message = e.message,isSuccess = false)
        }
    }
}