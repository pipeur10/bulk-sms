package com.pipo.bulksms.features.ui

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by philip on 6/22/16.
 */
class NonSwipeableViewPager : ViewPager {

    private var allowSwipping = false

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}


    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return if (allowSwipping) {
            super.onInterceptTouchEvent(event)
        } else false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (allowSwipping) {
            super.onTouchEvent(event)
        } else false
        // Never allow swiping to switch between pages
    }


    fun setAllowSwipping(allowSwipping: Boolean) {
        this.allowSwipping = allowSwipping
    }
}
