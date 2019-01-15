package com.depromeet.universalnotice.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.databinding.FragmentCreateAlarmBinding
import org.koin.android.ext.android.inject

class CreateFragment : DialogFragment() {
    private val viewModel by inject<CreateAlarmViewModel>()
    private lateinit var binding: FragmentCreateAlarmBinding

    override fun onStart() {
        super.onStart()
        if (dialog == null)
            return

        dialog!!.window.setWindowAnimations(
            R.style.dialog_animation_move_to_up
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentCreateAlarmBinding.inflate(inflater, container, false)
        binding.apply {
            viewmodel = viewModel
            setLifecycleOwner(this@CreateFragment)
        }

        setupButtons()
        setTargetTimeClicked()
        setIntervalAlarmClicked()

        return binding.root
    }



    fun setupButtons() {
        viewModel.dismiss.observe(this, Observer { dismiss() })
    }

    fun setTargetTimeClicked(){
        viewModel.targetTimeClick.observe(this, Observer {
            var dialog = TimePickerFragment(viewModel,1)
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE,R.style.AppTheme)
            dialog.show(this!!.fragmentManager!!, "TimePickerFragment")
        })
    }

    fun setIntervalAlarmClicked(){
        viewModel.intervalStartClick.observe(this, Observer {
            var dialog = TimePickerFragment(viewModel,2)
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE,R.style.AppTheme)
            dialog.show(this!!.fragmentManager!!, "TimePickerFragment")
        })
        viewModel.intervalEndClick.observe(this, Observer {
            var dialog = TimePickerFragment(viewModel,3)
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE,R.style.AppTheme)
            dialog.show(this!!.fragmentManager!!, "TimePickerFragment")
        })

    }


}