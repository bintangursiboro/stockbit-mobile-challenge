package com.ijniclohot.stockbitmobilechallenge.features.watch_list.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ijniclohot.networking.model.CryptoData
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WatchListViewModelTest : TestCase() {
    private lateinit var viewModel: WatchListViewModel

    @Before
    public override fun setUp() {
        super.setUp()
        viewModel = WatchListViewModel()
    }

    @Test
    fun testWatchListViewModel() {
        val cryptoData = mockk<CryptoData>(relaxed = true)

        viewModel.retrieveStockData()
        val result = viewModel.getStockLiveData().getOrAwaitValue().data!!.find {
            it.coinInfo.fullName == "BTX"
        }

        verify {
            result != null
        }
    }

}