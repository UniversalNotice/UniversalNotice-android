package com.depromeet.universalnotice.ui.mainlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.depromeet.universalnotice.databinding.FragmentMainlistBinding
import com.depromeet.universalnotice.model.Alarm

class MainListFragment : Fragment() {
    private lateinit var viewModel : MainListViewModel
    private lateinit var binding: FragmentMainlistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainlistBinding.inflate(inflater, container, false)
        setupBinding(savedInstanceState)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val rvLayoutManager = LinearLayoutManager(requireContext())
//
//        binding.mainlistRecyclerview.apply {
//            //            layoutManager = rvLayoutManager
////            adapter =
//        }
    }

    fun setupBinding(savedInstanceState: Bundle?){
//        binding = FragmentMainlistBinding.inflate(inflater, container, false)
        //
        viewModel = ViewModelProviders.of(this).get(MainListViewModel::class.java)
        if (savedInstanceState == null) {
            viewModel.init()
        }
        binding.vm = viewModel

        setupList()
    }

    fun setupList(){
        viewModel.fetchList()
        viewModel.getlist().observe(this, Observer<List<Alarm>> {
            if(it.isNotEmpty())
                viewModel.setListInAdapter(it)
        })
    }

}
