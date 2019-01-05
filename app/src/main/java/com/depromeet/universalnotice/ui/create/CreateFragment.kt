package com.depromeet.universalnotice.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.databinding.FragmentCreateAlarmBinding
import com.depromeet.universalnotice.databinding.FragmentMainlistBinding
import com.depromeet.universalnotice.ui.mainlist.MainListViewModel

class CreateFragment  : DialogFragment() {
    private lateinit var viewModel : CreateAlarmViewModel
    private lateinit var binding: FragmentCreateAlarmBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentCreateAlarmBinding.inflate(inflater, container, false)
        setupBinding(savedInstanceState)

        return binding.root
    }

    fun setupBinding(savedInstanceState: Bundle?){
//        binding = FragmentMainlistBinding.inflate(inflater, container, false)
        //
        viewModel = ViewModelProviders.of(this).get(CreateAlarmViewModel::class.java)
        if (savedInstanceState == null) {
            viewModel.init()
        }
        binding.viewmodel = viewModel
        setupButtons()
    }

    fun setupButtons(){
        viewModel.dismiss.observe(this, Observer{dismiss()})

    }

}