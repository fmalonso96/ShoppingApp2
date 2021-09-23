package com.example.shoppingappmvvm.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingappmvvm.data.model.Product
import com.example.shoppingappmvvm.data.repository.MainRepository
import com.example.shoppingappmvvm.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val products = MutableLiveData<Resource<List<Product>>>()
    val currentProducts: LiveData<Resource<List<Product>>>
        get() = products

    init {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                getProductsFromRepository()
            }
        }
    }

    private suspend fun getProductsFromRepository() {
        products.postValue(Resource.loading())
        val productList = mainRepository.getProducts()
        if (productList.isEmpty()) {
            products.postValue(Resource.error(null, "Products Unreachable"))
        } else {
            products.postValue(Resource.success(productList))
        }
    }
}