package com.depromeet.universalnotice.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.depromeet.universalnotice.ui.mainlist.MainListViewHolder

@BindingAdapter("setAdapter")
fun setAdapter(recyclerView: RecyclerView, adapter:RecyclerView.Adapter<MainListViewHolder>){
    val recyclerViewLayoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.setHasFixedSize(true)
    recyclerView.setLayoutManager(recyclerViewLayoutManager)
    recyclerView.setAdapter(adapter)
}