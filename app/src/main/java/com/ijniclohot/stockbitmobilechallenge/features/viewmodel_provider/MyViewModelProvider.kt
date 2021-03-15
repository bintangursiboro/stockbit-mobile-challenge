package com.ijniclohot.stockbitmobilechallenge.features.viewmodel_provider

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ijniclohot.stockbitmobilechallenge.features.watch_list.viewmodel.WatchListViewModel

class MyViewModelProvider() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WatchListViewModel::class.java)) {
            return WatchListViewModel() as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}