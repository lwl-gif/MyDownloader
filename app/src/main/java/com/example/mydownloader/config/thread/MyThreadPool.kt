package com.example.mydownloader.config.thread

import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * <Description> TODO
 *
 * @author Wallace
 * @Date 2021/11/19 10:35
 */
object MyThreadPool {
    /**
     * 创建线程池
     */
    var threadPool: ThreadPoolExecutor = ThreadPoolExecutor(
        ThreadPoolConfig.CORE_POOL_SIZE,
        ThreadPoolConfig.CPU_MAXIMUM_POOL_SIZE,
        ThreadPoolConfig.KEEP_ALIVE_TIME,
        TimeUnit.SECONDS,
        ThreadPoolConfig.WORK_QUEUE,
        ThreadPoolConfig.threadFactory,
        ThreadPoolConfig.myRejectHandler
    )
}