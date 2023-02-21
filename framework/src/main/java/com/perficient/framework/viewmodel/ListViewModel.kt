package com.perficient.framework.viewmodel

import androidx.lifecycle.*
import com.perficient.framework.network.CountryService
import com.perficient.framework.network.InshortNewService
import com.perficient.model.MainRecyclerViewItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val countryService: CountryService, private val inshortNewService: InshortNewService): ViewModel() {

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception: ${throwable.localizedMessage}")
    }

    val countries = MutableLiveData<List<MainRecyclerViewItem.CountryItem>>()
    val shortnews = MutableLiveData<List<MainRecyclerViewItem.InshortNewsItem>>()
    val loadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountriesAndNews()
    }

    private fun fetchCountriesAndNews() {
        loading.value = true

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            try {
                // coroutineScope is needed, else in case of any network error, it will crash
                coroutineScope {
                    //val countryDeferredResponse  = async { CountryService.getCountriesService().getCountries() }
                    val countryDeferredResponse  = async {countryService.getCountries()}
                    val shortDeferredNewResponse = async {inshortNewService.getNews()}

                    val countryResponse = countryDeferredResponse.await()
                    val shortNewResponse = shortDeferredNewResponse.await()

                    withContext(Dispatchers.Main) {
                        if (countryResponse.isSuccessful && shortNewResponse.isSuccessful) {
                            // Por estar en el main thread se usa value para actualizar el LD.
                            // En background se deberia usar postDelayed()
                            countries.value = countryResponse.body()
                            shortnews.value = shortNewResponse.body()
                            loadError.value = null
                            loading.value = false
                        } else {
                            onError("Error: ${countryResponse.message()}")
                        }
                    }
                }
            }
            catch (e: Exception) {
                onError("Error: Something Went Wrong ${e.message}")
            }
        }
    }

    private fun onError(message: String) {
        loadError.value = message
        loading.value = false
    }

}