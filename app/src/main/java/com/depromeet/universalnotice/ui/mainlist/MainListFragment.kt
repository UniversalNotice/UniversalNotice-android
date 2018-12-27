package com.depromeet.universalnotice.ui.mainlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.depromeet.universalnotice.databinding.FragmentMainlistBinding
import org.koin.android.ext.android.inject

class MainListFragment : Fragment() {
    private val viewModel by inject<MainListViewModel>()
    private lateinit var binding: FragmentMainlistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainlistBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvLayoutManager =  LinearLayoutManager(requireContext())

        binding.mainlistRecyclerview.apply {
//            layoutManager = rvLayoutManager
//            adapter =
        }

    }



}