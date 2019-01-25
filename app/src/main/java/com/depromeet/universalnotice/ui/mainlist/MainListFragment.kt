package com.depromeet.universalnotice.ui.mainlist

import android.annotation.TargetApi
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.databinding.FragmentMainlistBinding
import com.depromeet.universalnotice.model.Alarm
import com.depromeet.universalnotice.ui.create.CreateFragment
import com.depromeet.universalnotice.ui.targetAlarm.TargetAlarmActivity
import org.koin.android.ext.android.inject
import java.time.LocalTime
import java.util.*

class MainListFragment : Fragment() {
    private val viewModel by inject<MainListViewModel>()
    private lateinit var binding: FragmentMainlistBinding
    private lateinit var mAlarmManager : AlarmManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainlistBinding.inflate(inflater, container, false)

        binding.apply { vm = this@MainListFragment.viewModel
            setLifecycleOwner(this@MainListFragment) }

        setupList()
        setupButtons()

        return binding.root
    }



    fun setupBinding(savedInstanceState: Bundle?) {

    }

    fun setupList() {
        viewModel.fetchList()
        viewModel.getlist().observe(this, Observer<List<Alarm>> {
            if (it.isNotEmpty())
                viewModel.setListInAdapter(it)
            binding.mainlistListText.setText(viewModel.alarmList.value!!.size.toString() + "개의 알림 리스트가 있습니다")
        })
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun setupButtons() {
        viewModel.createAlarm.observe(this, Observer {
            var dialog = CreateFragment()
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme)
            dialog.show(this!!.fragmentManager!!, "CreateFragment")
        })

        viewModel.removeAlarm.observe(this, Observer {
            // 알람 매니저 등록 및 해당 시간에 알람 실행 코드
//            mAlarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            val intent = Intent(context,TargetAlarmActivity::class.java)
//            val pendingIntent = PendingIntent.getActivity(context,0,intent,0)
//
//            val calendar = Calendar.getInstance()
//            calendar.set(Calendar.HOUR_OF_DAY, LocalTime.now().hour)
//            calendar.set(Calendar.MINUTE,LocalTime.now().minute+1)
//            mAlarmManager.set(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,pendingIntent)
//            Toast.makeText(context,"click",Toast.LENGTH_SHORT).show()
        })
    }

}
