package com.depromeet.universalnotice.ui

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.dip

class CircleIndicator: LinearLayout {

    private var mContext: Context? = null

    private var mDefaultCircle: Int = 0
    private var mSelectCircle: Int = 0

    private var imageDot: MutableList<ImageView> = mutableListOf()

    private val margin = dip(4)

    constructor(context: Context) : super(context) {

        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        mContext = context
    }

    /**
     * 기본 점 생성
     * @param count 점의 갯수
     * @param defaultCircle 기본 점의 이미지
     * @param selectCircle 선택된 점의 이미지
     * @param position 선택된 점의 포지션
     */
    fun createDotPanel(count: Int, defaultCircle: Int, selectCircle: Int, position: Int) {

        this.removeAllViews()

        mDefaultCircle = defaultCircle
        mSelectCircle = selectCircle

        for (i in 0 until count) {
            imageDot.add(ImageView(mContext).apply {
                layoutParams = LayoutParams(dip(8), dip(8)).apply {
                    leftMargin = margin
                    rightMargin = margin
                }
            })

            this.addView(imageDot[i])
        }

        //인덱스 선택
        selectDot(position)
    }

    /**
     * 선택된 점 표시
     * @param position
     */
    fun selectDot(position: Int) {
        for (i in imageDot.indices) {
            if (i == position) {
                imageDot[i].setImageResource(mSelectCircle)
            } else {
                imageDot[i].setImageResource(mDefaultCircle)
            }
        }
    }
}