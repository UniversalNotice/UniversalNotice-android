package com.depromeet.universalnotice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.depromeet.universalnotice.databinding.FragmentMainlistBinding

class MainListFragment : Fragment(){
    private lateinit var binding: FragmentMainlistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainlistBinding.inflate(inflater,container,false)

        return binding.root
    }

}