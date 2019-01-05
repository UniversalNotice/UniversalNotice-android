package com.depromeet.universalnotice.ui.mainlist

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.databinding.FragmentMainlistBinding
import com.depromeet.universalnotice.model.Alarm
import com.depromeet.universalnotice.ui.create.CreateFragment

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
        setupButtons()
    }

    fun setupList(){
        viewModel.fetchList()
        viewModel.getlist().observe(this, Observer<List<Alarm>> {
            if(it.isNotEmpty())
                viewModel.setListInAdapter(it)
//                binding.mainlistListText.setText(viewModel.getItemCount()+"개의 알림 리스트가 있습니다")
        })
    }

    fun setupButtons(){
        viewModel.createAlarm.observe(this, Observer {
            var dialog:CreateFragment = CreateFragment()
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme)
            dialog.show(this!!.fragmentManager!!,"CreateFragment")
        })
    }

}
