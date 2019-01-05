package com.depromeet.universalnotice.ui.mainlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.depromeet.universalnotice.BR
import com.depromeet.universalnotice.databinding.ItemMainlistBinding
import com.depromeet.universalnotice.model.Alarm

class MainListAdapter(
    private val viewmodel: MainListViewModel)
//        private val lifecycleOwner: LifecycleOwner)
    : RecyclerView.Adapter<MainListViewHolder>() {

    private lateinit var list: List<Alarm>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val binding = ItemMainlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.bind(viewmodel,position)
    }

    fun setList(list: List<Alarm>){
        this.list = list
    }



}

class MainListViewHolder(
    private val binding: ItemMainlistBinding
//    private val lifecycleOwner: LifecycleOwner
):RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: MainListViewModel, position:Int) {
        binding.setVariable(BR.viewmodel,viewModel)
        binding.setVariable(BR.position,position)
//        binding.setVariable(BR.,position)
        binding.executePendingBindings()
    }
//
  /*  void bind(DogBreedsViewModel viewModel, Integer position) {
        viewModel.fetchDogBreedImagesAt(position);
        binding.setVariable(BR.viewModel, viewModel);
        binding.setVariable(BR.position, position);
        binding.executePendingBindings();
    }*/
//    private ViewDataBinding binding;
//
//    public BindingHolder(ItemCommentBinding binding) {
//        super(binding.containerItem);
//        this.binding = binding;
//    }
//
//    public BindingHolder(ItemCommentsHeaderBinding binding) {
//        super(binding.containerItem);
//        this.binding = binding;
//    }
}