package com.depromeet.universalnotice.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.depromeet.universalnotice.databinding.FragmentCreateAlarmBinding
import com.depromeet.universalnotice.databinding.FragmentMainlistBinding

class CreateFragment  : Fragment() {
    private lateinit var viewModel : CreateAlarmViewModel
    private lateinit var binding: FragmentCreateAlarmBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentCreateAlarmBinding.inflate(inflater, container, false)

        return binding.root
    }

}