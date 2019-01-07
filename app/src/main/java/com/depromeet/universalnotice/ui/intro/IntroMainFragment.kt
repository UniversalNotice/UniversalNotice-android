package com.depromeet.universalnotice.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.depromeet.universalnotice.databinding.FragmentIntroBinding
import kotlinx.android.synthetic.main.fragment_intro.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class IntroMainFragment : Fragment() {
    private val viewModel by sharedViewModel<IntroViewModel>()
    private lateinit var binding: FragmentIntroBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIntroBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.position = arguments?.getInt("position")

        //viewModel.pageChange.observe(this, Observer {
        //})

        //if (arguments?.getInt("position") == 4)
        //    allow_alert.visibility = View.VISIBLE

    }
}