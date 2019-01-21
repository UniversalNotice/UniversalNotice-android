package com.depromeet.universalnotice.util

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.depromeet.universalnotice.R
import com.depromeet.universalnotice.model.Category
import com.depromeet.universalnotice.ui.mainlist.MainListAdapter
import org.jetbrains.anko.textColor
import java.time.LocalTime

@BindingAdapter("setAdapter")
fun setAdapter(recyclerView: RecyclerView, adapter: MainListAdapter) {
    val recyclerViewLayoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.apply {
        setHasFixedSize(true)
        layoutManager = recyclerViewLayoutManager
        this.adapter = adapter
    }
}

@BindingAdapter("setCategory")
fun setCategory(imageview: ImageView, category: Category?) {
    when (category) {
        Category.SLEEP -> when (imageview.id) {
            R.id.create_category_image1 -> imageview.setImageResource(R.drawable.ic_alarm_category_sleep)
            R.id.create_category_image2 -> imageview.setImageResource(R.drawable.ic_alarm_category_todo_off)
            R.id.create_category_image3 -> imageview.setImageResource(R.drawable.ic_alarm_category_schedule_off)
        }
        Category.TODO -> when (imageview.id) {
            R.id.create_category_image1 -> imageview.setImageResource(R.drawable.ic_alarm_category_sleep_off)
            R.id.create_category_image2 -> imageview.setImageResource(R.drawable.ic_alarm_category_todo)
            R.id.create_category_image3 -> imageview.setImageResource(R.drawable.ic_alarm_category_schedule_off)
        }
        else -> when (imageview.id) {
            R.id.create_category_image1 -> imageview.setImageResource(R.drawable.ic_alarm_category_sleep_off)
            R.id.create_category_image2 -> imageview.setImageResource(R.drawable.ic_alarm_category_todo_off)
            R.id.create_category_image3 -> imageview.setImageResource(R.drawable.ic_alarm_category_schedule)
        }
    }
}

@BindingAdapter("setCategoryText")
fun setCategoryText(textView: TextView, category: Category?) {
    when (category) {
        Category.SLEEP -> when (textView.id) {
            R.id.create_category_text1 -> textView.setTextColor(Color.parseColor("#0d0d0d"))
            R.id.create_category_text2 -> textView.setTextColor(Color.parseColor("#999999"))
            R.id.create_category_text3 -> textView.setTextColor(Color.parseColor("#999999"))
        }
        Category.TODO -> when (textView.id) {
            R.id.create_category_text1 -> textView.setTextColor(Color.parseColor("#999999"))
            R.id.create_category_text2 -> textView.setTextColor(Color.parseColor("#0d0d0d"))
            R.id.create_category_text3 -> textView.setTextColor(Color.parseColor("#999999"))
        }
        else -> when (textView.id) {
            R.id.create_category_text1 -> textView.setTextColor(Color.parseColor("#999999"))
            R.id.create_category_text2 -> textView.setTextColor(Color.parseColor("#999999"))
            R.id.create_category_text3 -> textView.setTextColor(Color.parseColor("#0d0d0d"))
        }
    }
}

@TargetApi(Build.VERSION_CODES.O)
@BindingAdapter("setListTime")
fun setListTime(textView: TextView,time:LocalTime){

    textView.text = ""+time.hour+":"+time.minute
}

@TargetApi(Build.VERSION_CODES.O)
@BindingAdapter("setInterval","setIntervalType")
fun setIntervalText(textView: TextView,time: LocalTime,bool: Boolean){
    if(bool){
        textView.text = "이전 "+time.hour+"분"
    } else {
        textView.text = "이후 "+time.hour+"분"
    }
}

@BindingAdapter("setItemImage", "imageViewcategory")
fun setItemImage(imageview: ImageView, bool: Boolean, category: Category) {
    if (bool) {
        when (category) {
            Category.SLEEP -> imageview.setImageResource(R.drawable.ic_alarm_category_sleep)
            Category.TODO -> imageview.setImageResource(R.drawable.ic_alarm_category_todo)
            Category.PLAN -> imageview.setImageResource(R.drawable.ic_alarm_category_schedule)
        }
    } else {
        when (category) {
            Category.SLEEP -> imageview.setImageResource(R.drawable.ic_alarm_category_sleep_off)
            Category.TODO -> imageview.setImageResource(R.drawable.ic_alarm_category_todo_off)
            Category.PLAN -> imageview.setImageResource(R.drawable.ic_alarm_category_schedule_off)
        }
    }
}

@BindingAdapter("setItemTextColor")
fun setTextViewColor(textView: TextView, bool: Boolean) {
    if (bool == true) {
        when (textView.id) {
            R.id.item_mainlist_time_interval_type -> textView.textColor = Color.parseColor("#555555")
            R.id.item_mainlist_category_text -> textView.textColor = Color.parseColor("#0d0d0d")
            R.id.item_mainlist_time -> textView.textColor = Color.parseColor("#333333")
            R.id.item_mainlist_time_ampm -> textView.textColor = Color.parseColor("#666666")
            R.id.item_mainlist_day_of_the_week -> textView.textColor = Color.parseColor("#666666")
        }
    } else {
        textView.textColor = Color.parseColor("#999999")
    }
}

@BindingAdapter("setIsActiveText")
fun setIsAlarmText(textView: TextView, bool: Boolean) {
    if (bool == true) {
        textView.textColor = Color.parseColor("#0d0d0d")
    } else {
        textView.textColor = Color.parseColor("#80666666")
    }
}

@BindingAdapter("setIsActiveBtn")
fun setIsAlarmBtn(image: ImageView, bool: Boolean) {
    if (bool == true) {
        image.setImageResource(R.drawable.ic_icon_checked_on)
    } else {
        image.setImageResource(R.drawable.ic_icon_checked_off)
    }
}

@BindingAdapter("setAlarmTiming")
fun setAlarmTiming(button: Button, type: Int) {
    if (type == 1) {
        when (button.id) {
            R.id.create_target_time_before -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square_blue)
                setTextColor(Color.parseColor("#298afd"))
            }
            R.id.create_target_time_after -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
        }
    } else if (type == 2) {
        when (button.id) {
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

@BindingAdapter("setDaysOfTheWeek")
fun setDaysoftheWeek(textView: TextView, bool: Boolean) {
    if (bool == true) textView.setTextColor(Color.parseColor("#298afd")) else textView.setTextColor(Color.parseColor("#666666"))
}

@BindingAdapter("setRepeatType")
fun setRepeatType(button: Button, type: Int) {
    when (type) {
        1 -> when (button.id) {
            R.id.create_repeat_onetime_btn -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
            R.id.create_repeat_week_btn -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square_blue)
                setTextColor(Color.parseColor("#298afd"))
            }
        }
        2 -> when (button.id) {
            R.id.create_repeat_week_btn -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
            R.id.create_repeat_onetime_btn -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square_blue)
                setTextColor(Color.parseColor("#298afd"))
            }
        }
    }
}

@BindingAdapter("setStrengthButton")
fun setStrengthButton(button: Button, type: Int) {
    when (type) {
        1 -> when (button.id) {
            R.id.create_strength_btn_1 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square_blue)
                setTextColor(Color.parseColor("#298afd"))
            }
            R.id.create_strength_btn_2 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
            R.id.create_strength_btn_3 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
        }
        2 -> when (button.id) {
            R.id.create_strength_btn_1 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
            R.id.create_strength_btn_2 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square_blue)
                setTextColor(Color.parseColor("#298afd"))
            }
            R.id.create_strength_btn_3 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
        }
        3 -> when (button.id) {
            R.id.create_strength_btn_1 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
            R.id.create_strength_btn_2 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square)
                setTextColor(Color.parseColor("#80666666"))
            }
            R.id.create_strength_btn_3 -> button.apply {
                setBackgroundResource(R.drawable.button_style_round_square_blue)
                setTextColor(Color.parseColor("#298afd"))
            }
        }

    }
}

//TODO ampm 구별해서 뷰에 설정해주기.