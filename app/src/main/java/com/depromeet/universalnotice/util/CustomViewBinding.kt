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
import org.jetbrains.anko.applyRecursively
import org.jetbrains.anko.custom.style
import org.jetbrains.anko.textColor

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

@BindingAdapter("setItemImage","imageViewcategory")
fun setItemImage(imageview:ImageView,bool:Boolean,category:Int){
    if(bool==true){
        when(category){
            1-> imageview.setImageResource(R.drawable.ic_alarm_category_sleep)
            2-> imageview.setImageResource(R.drawable.ic_alarm_category_todo)
            3-> imageview.setImageResource(R.drawable.ic_alarm_category_schedule)
        }
    }
    else{
        when(category){
            1-> imageview.setImageResource(R.drawable.ic_alarm_category_sleep_off)
            2-> imageview.setImageResource(R.drawable.ic_alarm_category_todo_off)
            3-> imageview.setImageResource(R.drawable.ic_alarm_category_schedule_off)
        }
    }
}

@BindingAdapter("setItemTextColor")
fun setTextViewColor(textView: TextView,bool: Boolean){
    if(bool==true){
        when(textView.id){
            R.id.item_mainlist_time_interval_type -> textView.textColor = Color.parseColor("#555555")
            R.id.item_mainlist_category_text -> textView.textColor = Color.parseColor("#0d0d0d")
            R.id.item_mainlist_time -> textView.textColor = Color.parseColor("#333333")
            R.id.item_mainlist_time_ampm -> textView.textColor = Color.parseColor("#666666")
            R.id.item_mainlist_day_of_the_week -> textView.textColor = Color.parseColor("#666666")
        }
    }
    else{
        textView.textColor = Color.parseColor("#999999")
    }
}

@BindingAdapter("setIsAlarmText")
fun setIsAlarmText(textView: TextView,bool: Boolean){
    if(bool==true){
        textView.textColor = Color.parseColor("#0d0d0d")
    }else{
        textView.textColor = Color.parseColor("#80666666")
    }
}

@BindingAdapter("setIsAlarmBtn")
fun setIsAlarmBtn(imageButton: ImageButton,bool: Boolean){
    if(bool==true){
        imageButton.setImageResource(R.drawable.ic_icon_checked_on)
    }else{
        imageButton.setImageResource(R.drawable.ic_icon_checked_off)
    }
}

@BindingAdapter("setAlarmTiming")
fun setAlarmTiming(button: Button,type:Int){
    if(type==1){
        when(button.id){
            R.id.create_target_time_before -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square_blue)
                setTextColor(Color.parseColor("#298afd"))
            }
            R.id.create_target_time_after -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
        }
    }
    else if (type==2){
        when(button.id){
            R.id.create_target_time_before -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
            R.id.create_target_time_after -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square_blue)
                setTextColor(Color.parseColor("#298afd"))
            }
        }
    }
}