package com.example.mydownloader

import android.app.Application
import android.content.res.Configuration
import com.example.mydownloader.config.globalConfig.GlobalParameter
import com.example.mydownloader.utils.log.LogUtil

/**
 * <Description> TODO
 *
 * @author Wallace
 * @Date 2021/11/19 13:39
 */
class DownloaderApp : Application() {

    override fun onCreate() {
        super.onCreate()
        LogUtil.d("$TAG : ${BuildConfig.APPLICATION_ID} Created version = ${BuildConfig.VERSION_CODE} release_date= ${BuildConfig.RELEASE_DATE} build_type = ${BuildConfig.BUILD_TYPE}")
        GlobalParameter.mContext = this
        //

    }

    // 程序终止的时候执行
    override fun onTerminate() {
        LogUtil.d("onTerminate")
        GlobalParameter.mContext = null
        super.onTerminate()
    }

    // 低内存的时候执行
    override fun onLowMemory() {
        LogUtil.d("onLowMemory")
        super.onLowMemory()
    }

    // 程序在内存清理的时候执行
    override fun onTrimMemory(level: Int) {
        LogUtil.d("onTrimMemory")
        super.onTrimMemory(level)
    }

    // 配置文件更改的时候执行
    override fun onConfigurationChanged(newConfig: Configuration) {
        LogUtil.d("onConfigurationChanged")
        super.onConfigurationChanged(newConfig)
    }

    companion object{
        const val TAG = "DownloaderApp"
    }
}