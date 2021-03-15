package com.ijniclohot.stockbitmobilechallenge.features.watch_list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijniclohot.networking.model.CryptoData
import com.ijniclohot.stockbitmobilechallenge.R
import com.ijniclohot.stockbitmobilechallenge.features.viewmodel_provider.MyViewModelProvider
import com.ijniclohot.stockbitmobilechallenge.features.watch_list.view.adapter.StockAdapter
import com.ijniclohot.stockbitmobilechallenge.features.watch_list.viewmodel.WatchListViewModel
import com.ijniclohot.stockbitmobilechallenge.util.ResponseStatus
import kotlinx.android.synthetic.main.error_layout.*
import kotlinx.android.synthetic.main.fragment_watch_list.*
import kotlinx.android.synthetic.main.shimmer_container.*

class WatchListFragment : Fragment() {
    lateinit var stockList: RecyclerView

    lateinit var stockAdapter: StockAdapter

    lateinit var watchListViewModel: WatchListViewModel

    val layoutManager = LinearLayoutManager(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setupViewModel() {
        watchListViewModel =
            ViewModelProvider(this, MyViewModelProvider())[WatchListViewModel::class.java]
    }

    private fun setupRecyclerView(view: View) {
        stockList = view.findViewById(R.id.watchListRecyclerView)

        stockList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    val visibleItemCount = layoutManager.childCount

                    val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()

                    val total = stockAdapter.itemCount

                    if (!watchListViewModel.getIsLoadMore().value!!) {

                        if ((visibleItemCount + pastVisibleItem) >= total) {

                            watchListViewModel.loadMore()

                        }

                    }

                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        stockList.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.HORIZONTAL
            )
        )

        stockList.layoutManager = layoutManager

        stockAdapter = StockAdapter(requireContext(), ArrayList())

        stockList.adapter = stockAdapter
    }

    private fun setupObserver() {
        watchListViewModel.getStockLiveData().observe(requireActivity(), Observer {
            when (it.status) {
                ResponseStatus.SUCCESS -> onSuccessView(it.data!!)

                ResponseStatus.LOADING -> onLoadingView()

                else -> onErrorView(it.message)
            }

        })

        watchListViewModel.getIsLoadMore().observe(requireActivity(), Observer {
            if (it) {
                recyclerViewProgressBar.visibility = View.VISIBLE
            } else {
                recyclerViewProgressBar.visibility = View.GONE
            }
        })
    }

    private fun onSuccessView(successData: List<CryptoData>) {
        stockAdapter.stockList = successData
        stockAdapter.notifyDataSetChanged()
        swipeContainer.isRefreshing = false
        stockList.adapter = stockAdapter
        shimmer_container.visibility = View.GONE
        swipeContainer.visibility = View.VISIBLE
        errorLayout.visibility = View.GONE
    }

    private fun onLoadingView() {
        shimmer_container.visibility = View.VISIBLE
        swipeContainer.visibility = View.GONE
        errorLayout.visibility = View.GONE
        swipeContainer.isRefreshing = false
    }

    private fun onErrorView(errorMessage: String?) {
        stockAdapter.stockList = ArrayList()
        stockAdapter.notifyDataSetChanged()
        stockList.adapter = stockAdapter
        shimmer_container.visibility = View.GONE
        swipeContainer.visibility = View.GONE
        errorTextView.text = errorMessage
        errorLayout.visibility = View.VISIBLE
        swipeContainer.isRefreshing = false
    }

    private fun initView(view: View) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(watchListToolbar)

        retryButton.setOnClickListener {
            watchListViewModel.retrieveStockData()
        }

        setupRecyclerView(view)

        setupViewModel()

        setupObserver()

        swipeContainer.setOnRefreshListener {
            watchListViewModel.retrieveStockData()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        watchListViewModel.retrieveStockData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_watch_list, container, false)
    }

}