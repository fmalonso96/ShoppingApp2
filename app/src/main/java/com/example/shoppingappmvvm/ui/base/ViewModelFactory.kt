package com.example.shoppingappmvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingappmvvm.data.repository.MainRepository
import com.example.shoppingappmvvm.ui.main.viewmodel.MainActivityViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(MainRepository()) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}