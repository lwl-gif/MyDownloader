package com.example.mydownloader.config.globalConfig

import android.app.Application
import android.util.Log
import com.example.mydownloader.BuildConfig

/**
 * <Description> TODO
 *
 * @author Wallace
 * @Date 2021/11/19 14:15
 */
object GlobalParameter {

    var mContext: Application? = null


    // BuildConfig.DEBUG
    val logLevel = if (BuildConfig.DEBUG) Log.VERBOSE else Log.WARN

}