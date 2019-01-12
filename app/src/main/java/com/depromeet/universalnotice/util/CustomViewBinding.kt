package com.depromeet.universalnotice.util

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.SeekBarBindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.ui.mainlist.MainListAdapter

@BindingAdapter("setAdapter")
fun setAdapter(recyclerView: RecyclerView, adapter: MainListAdapter) {
    val recyclerViewLayoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.setHasFixedSize(true)
    recyclerView.setLayoutManager(recyclerViewLayoutManager)
    recyclerView.setAdapter(adapter)
}


@BindingAdapter("setCategory")
fun setCategory(imageview: ImageView, category: Int) {
    if (category == 1) {
        when (imageview.id) {
            R.id.create_category_image1 -> imageview.setImageResource(R.drawable.ic_alarm_category_sleep)
            R.id.create_category_image2 -> imageview.setImageResource(R.drawable.ic_alarm_category_todo_off)
            R.id.create_category_image3 -> imageview.setImageResource(R.drawable.ic_alarm_category_schedule_off)
        }
    } else if (category == 2) {
        when (imageview.id) {
            R.id.create_category_image1 -> imageview.setImageResource(R.drawable.ic_alarm_category_sleep_off)
            R.id.create_category_image2 -> imageview.setImageResource(R.drawable.ic_alarm_category_todo)
            R.id.create_category_image3 -> imageview.setImageResource(R.drawable.ic_alarm_category_schedule_off)
        }
    } else {
        when (imageview.id) {
            R.id.create_category_image1 -> imageview.setImageResource(R.drawable.ic_alarm_category_sleep_off)
            R.id.create_category_image2 -> imageview.setImageResource(R.drawable.ic_alarm_category_todo_off)
            R.id.create_category_image3 -> imageview.setImageResource(R.drawable.ic_alarm_category_schedule)
        }
    }
}

@BindingAdapter("setCategoryText")
fun setCategoryText(textView: TextView, category: Int) {
    if (category == 1) {
        when (textView.id) {
            R.id.create_category_text1 -> textView.setTextColor(Color.parseColor("#0d0d0d"))
            R.id.create_category_text2 -> textView.setTextColor(Color.parseColor("#999999"))
            R.id.create_category_text3 -> textView.setTextColor(Color.parseColor("#999999"))
        }
    } else if (category == 2) {
        when (textView.id) {
            R.id.create_category_text1 -> textView.setTextColor(Color.parseColor("#999999"))
            R.id.create_category_text2 -> textView.setTextColor(Color.parseColor("#0d0d0d"))
            R.id.create_category_text3 -> textView.setTextColor(Color.parseColor("#999999"))
        }
    } else {
        when (textView.id) {
            R.id.create_category_text1 -> textView.setTextColor(Color.parseColor("#999999"))
            R.id.create_category_text2 -> textView.setTextColor(Color.parseColor("#999999"))
            R.id.create_category_text3 -> textView.setTextColor(Color.parseColor("#0d0d0d"))
        }
    }
}
