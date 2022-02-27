package com.akshay.phonepetestapplication.utils.view

import android.os.SystemClock
import android.view.View
import java.util.*

abstract class DebouncedOnClickListener
/**
 * The one and only constructor
 * @param minimumInterval The minimum allowed time between clicks - any click sooner than this after a previous click will be rejected
 */
    (private val minimumInterval: Long) : View.OnClickListener {
    private val lastClickMap: MutableMap<View, Long>

    /**
     * Implement this in your subclass instead of onClick
     * @param v The view that was clicked
     */
    abstract fun onDebouncedClick(v: View)

    init {
        this.lastClickMap = WeakHashMap()
    }

    override fun onClick(clickedView: View) {
        val previousClickTimestamp = lastClickMap[clickedView]
        val currentTimestamp = SystemClock.uptimeMillis()
        lastClickMap[clickedView] = currentTimestamp
        if (previousClickTimestamp == null || currentTimestamp - previousClickTimestamp.toLong() > minimumInterval) {
            onDebouncedClick(clickedView)
        }
    }
}