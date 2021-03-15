package com.ijniclohot.stockbitmobilechallenge.features.watch_list.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ijniclohot.networking.model.CryptoData
import com.ijniclohot.networking.model.CryptoResponse
import com.ijniclohot.stockbitmobilechallenge.R
import kotlinx.android.synthetic.main.stock_item.view.*

class StockAdapter(
    private val context: Context,
    var stockList: List<CryptoData>
) : RecyclerView.Adapter<StockAdapter.StockViewHolder>() {
    inner class StockViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name_text_view)!!
        val price = view.findViewById<TextView>(R.id.price_text_view)!!
        val fullName = view.findViewById<TextView>(R.id.fullname_text_view)!!
        val changePc = view.findViewById<TextView>(R.id.change_pc_text_view)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        return StockViewHolder(
            LayoutInflater.from(context).inflate(R.layout.stock_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return stockList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        holder.price.text = stockList[position].display.IDR.price.replace("IDR ", "")
        holder.fullName.text = stockList[position].coinInfo.fullName
        holder.name.text = stockList[position].coinInfo.name
        when {
            stockList[position].raw.IDR.changeday < 0 -> {
                holder.changePc.setTextColor(
                    ContextCompat.getColor(
                        context,
                        android.R.color.holo_red_light
                    )
                )
            }
            stockList[position].raw.IDR.changeday == 0.0 -> {
                holder.changePc.setTextColor(
                    ContextCompat.getColor(
                        context,
                        android.R.color.holo_green_light
                    )
                )
            }
            else -> {
                holder.changePc.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
            }
        }
        var prefix = ""
        if (stockList[position].raw.IDR.changepctday > 0){
            prefix = "+"
        }
        holder.changePc.text = "$prefix " +  stockList[position].display.IDR.changeday.replace(
            "IDR ",
            ""
        ) + "(" + stockList[position].display.IDR.changepctday + "%)"
    }
}