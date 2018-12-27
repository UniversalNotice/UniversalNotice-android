package com.depromeet.universalnotice.ui.mainlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.depromeet.universalnotice.databinding.ItemMainlistBinding
import com.depromeet.universalnotice.model.Alarm

class MainListAdapter(
    private val lifecycleOwner: LifecycleOwner)
    : RecyclerView.Adapter<MainListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val binding = ItemMainlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainListViewHolder(binding,lifecycleOwner)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
//        holder.bind()
    }


}

class MainListViewHolder(
    private val binding: ItemMainlistBinding,
    private val lifecycleOwner: LifecycleOwner
):RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Alarm?) {
        binding.alarm = item
        binding.setLifecycleOwner(lifecycleOwner)
        binding.executePendingBindings()
    }
}