package com.depromeet.universalnotice.ui.create

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*

@SuppressLint("ValidFragment")
class DatePickerFragment(viewModel: CreateAlarmViewModel) : DialogFragment() {

    private val minDate = Calendar.getInstance()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(activity, dateListener, year, month, day)
        minDate.set(year,month,day)
        datePickerDialog.datePicker.minDate = minDate.time.time

        return datePickerDialog
    }


    private val dateListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
        viewModel.setSpecificDate(""+year+" 년   "+(month+1)+" 월   "+day+" 일")
        Toast.makeText(activity,"y:"+year+" m:"+(month+1)+" d:"+day,Toast.LENGTH_SHORT).show()
    }
}