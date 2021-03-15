package com.ijniclohot.stockbitmobilechallenge.features.watch_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ijniclohot.networking.ApiService
import com.ijniclohot.networking.model.CryptoData
import com.ijniclohot.networking.model.CryptoResponse
import com.ijniclohot.stockbitmobilechallenge.util.Resource
import com.ijniclohot.stockbitmobilechallenge.util.ResponseStatus
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.java.KoinJavaComponent.inject

class WatchListViewModel : ViewModel() {
    private val stockLiveData: MutableLiveData<Resource<List<CryptoData>>> = MutableLiveData()

    private val isLoadMore: MutableLiveData<Boolean> = MutableLiveData()

    private val disposable = CompositeDisposable()

    private val apiService: ApiService by inject(ApiService::class.java)

    var page = 1

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    fun getStockLiveData(): LiveData<Resource<List<CryptoData>>> {
        return stockLiveData
    }

    fun getIsLoadMore(): LiveData<Boolean> {
        return isLoadMore
    }

    fun retrieveStockData() {
        isLoadMore.postValue(false)
        stockLiveData.postValue(Resource(ResponseStatus.LOADING, null, null))
        disposable.add(
            apiService.getWatchList(null, page, "IDR", null, null, null)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    stockLiveData.postValue(Resource(ResponseStatus.SUCCESS, it.data, "Success"))

                    isLoadMore.postValue(false)

                    page++
                }, {
                    stockLiveData.postValue(Resource(ResponseStatus.ERROR, null, it.message))

                    page = 1
                })
        )

    }

    fun loadMore() {
        isLoadMore.postValue(true)
        disposable.clear()
        disposable.add(apiService.getWatchList(null, page, "IDR", null, null, null)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val temp=  stockLiveData.value!!.data as ArrayList

                temp.addAll(it.data)

                stockLiveData.postValue(Resource(ResponseStatus.SUCCESS, temp, "Success"))

                isLoadMore.postValue(false)

                page++
            }, {
                stockLiveData.postValue(Resource(ResponseStatus.ERROR, null, it.message))

                page = 1
            })
        )

    }


}