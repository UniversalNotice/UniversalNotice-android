package com.depromeet.universalnotice.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.databinding.FragmentCreateAlarmBinding

class CreateFragment  : DialogFragment() {
    private lateinit var viewModel : CreateAlarmViewModel
    private lateinit var binding: FragmentCreateAlarmBinding

    override fun onStart() {
        super.onStart()
        if(dialog == null)
            return

        dialog!!.window.setWindowAnimations(
            R.style.dialog_animation_move_to_up)
    }

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
        binding.setLifecycleOwner(this@CreateFragment)

        setupButtons()
    }

    fun setupButtons(){
        viewModel.dismiss.observe(this, Observer{dismiss()})

    }

}