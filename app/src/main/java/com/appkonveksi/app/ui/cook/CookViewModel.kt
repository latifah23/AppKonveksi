package com.appkonveksi.app.ui.cook

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appkonveksi.app.data.model.ActionState
import com.appkonveksi.app.data.model.Cook
import com.appkonveksi.app.data.repository.CookRepository
import kotlinx.coroutines.launch

class CookViewModel : ViewModel() {
    private val repo: CookRepository by lazy { CookRepository()}

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Cook>>()
    val categoryResp = MutableLiveData<Cook>()
    val searchResp = MutableLiveData<List<Cook>>()

    val category = MutableLiveData("")
    val query = MutableLiveData("")

    fun listCook(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listCook()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun categoryCook(category: String? = this.category.value){
        category?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.categoryCook(it)
                actionState.value = resp
                categoryResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchCook(query: String? = this.query.value){
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchCook(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}