package com.depromeet.universalnotice.ui.mainlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.databinding.FragmentMainlistBinding
import com.depromeet.universalnotice.model.Alarm
import com.depromeet.universalnotice.ui.create.CreateFragment
import org.koin.android.ext.android.inject

class MainListFragment : Fragment() {
    private val viewModel by inject<MainListViewModel>()
    private lateinit var binding: FragmentMainlistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainlistBinding.inflate(inflater, container, false)
        setupBinding(savedInstanceState)

        return binding.root
    }

    fun setupBinding(savedInstanceState: Bundle?) {
        binding.vm = this@MainListFragment.viewModel
        binding.setLifecycleOwner(this@MainListFragment)

        if (savedInstanceState == null)
            viewModel.init()

        setupList()
        setupButtons()
    }

    fun setupList() {
        viewModel.fetchList()
        viewModel.getlist().observe(this, Observer<List<Alarm>> {
            if (it.isNotEmpty())
                viewModel.setListInAdapter(it)
            binding.mainlistListText.setText(viewModel.alarmList.value!!.size.toString() + "개의 알림 리스트가 있습니다")
        })
    }

    fun setupButtons() {
        viewModel.createAlarm.observe(this, Observer {
            var dialog = CreateFragment()
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme)
            dialog.show(this!!.fragmentManager!!, "CreateFragment")
        })
    }

}
