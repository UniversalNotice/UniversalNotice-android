package com.depromeet.universalnotice.ui.create

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*


@SuppressLint("ValidFragment")
class TimePickerFragment(viewModel: CreateAlarmViewModel, type: Int) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        return TimePickerDialog(
            activity, android.R.style.Theme_Holo_Light_Dialog, timeListener, hour, minute,
            DateFormat.is24HourFormat(activity)
        )
    }

    private val timeListener = TimePickerDialog.OnTimeSetListener { timePicker, hourofday, minute ->
        lateinit var mHour: String
        lateinit var mMinute: String
        lateinit var ampm: String
        if (hourofday < 12) {//am
            mHour = timePicker.hour.toString()
            mMinute =
                    if (timePicker.minute.toString().length < 2) "0" + timePicker.minute.toString() else timePicker.minute.toString()
            ampm = "am"
        } else {//pm
            mHour = if (timePicker.hour != 12) (timePicker.hour - 12).toString() else timePicker.hour.toString()
            mMinute =
                    if (timePicker.minute.toString().length < 2) "0" + timePicker.minute.toString() else timePicker.minute.toString()
            ampm = "pm"
        }

        when (type) {
            1 -> {
                viewModel.setTargetTime(mHour + ":" + mMinute)
                viewModel.setTargetTimeAmPm(ampm)
            }
            2 -> {
                viewModel.setIntervalStartTime(mHour + ":" + mMinute)
                viewModel.setIntervalStartTimeAmPm(ampm)
            }
            3 -> {
                viewModel.setIntervalEndTime(mHour + ":" + mMinute)
                viewModel.setIntervalEndTimeAmPm(ampm)
            }
        }

        Toast.makeText(activity, "selected time is " + mHour + ":" + mMinute, Toast.LENGTH_SHORT).show()
    }
}