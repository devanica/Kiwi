package kiwi.app.ui.smoothies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kiwi.app.R
import kiwi.app.data.service.SmoothiesService
import kiwi.app.model.Base
import kiwi.app.model.Ingredient
import kiwi.app.model.Smoothie
import kotlinx.coroutines.*

class SmoothiesViewModel: ViewModel() {
    val smoothiesService = SmoothiesService.getSmoothiesService()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler{coroutineContext, throwable ->
        onError("Exception: ${throwable.localizedMessage}")
    }

    val smoothies = MutableLiveData<List<Smoothie>>()
    val smoothieLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    init {
        loadSmoothies()
    }

    fun refresh(){
        loadSmoothies()
    }

    fun fetchSmoothies(): LiveData<List<Smoothie>> {
        return smoothies
    }

    private fun loadSmoothies() {
        // postValue is an asynchronous function and it must be used instead of setValue
        loading.postValue(true)
        // Do an asynchronous operation to fetch users.
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = smoothiesService.getSmoothies()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    smoothies.postValue(response.body())
                    smoothieLoadError.postValue(null)
                    loading.postValue(false)
                }else{
                    onError("Error: ${response.message()}")
                }
            }
        }
    }

    private fun onError(message: String) {
        smoothieLoadError.postValue(message)
        loading.postValue(false)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}