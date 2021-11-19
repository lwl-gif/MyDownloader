package com.example.mydownloader.utils.log

import android.util.Log

/**
 * <Description> TODO
 *
 * @author Wallace
 * @Date 2021/11/19 9:57
 */
object LogUtil {

    private fun createLogTag(list: List<String>): String {
        return "(${list[0]}:${list[2]})|${list[1]}"
    }

    /**
     * 获取文件名、方法名、所在行数
     * @param sElements
     */
    private fun getMethodNames(sElements: Array<StackTraceElement>): List<String> {
        val className = sElements[1].fileName
        val methodName = sElements[1].methodName
        val lineNumber = sElements[1].lineNumber
        return listOf(className, methodName, lineNumber.toString())
    }

    //log.i
    fun i(text: String?) {
        val list = getMethodNames(Throwable().stackTrace)
        Log.i(createLogTag(list), text ?: "null")
    }

    //log.e
    fun e(text: String?) {
        val list = getMethodNames(Throwable().stackTrace)
        Log.e(createLogTag(list), text ?: "null")
    }

    //log.d
    fun d(text: String?) {
        val list = getMethodNames(Throwable().stackTrace)
        Log.d(createLogTag(list), text ?: "null")
    }

    //log.w
    fun w(text: String?) {
        val list = getMethodNames(Throwable().stackTrace)
        Log.w(createLogTag(list), text ?: "null")
    }

    //log.w
    fun v(text: String?) {
        val list = getMethodNames(Throwable().stackTrace)
        Log.v(createLogTag(list), text ?: "null")
    }
}