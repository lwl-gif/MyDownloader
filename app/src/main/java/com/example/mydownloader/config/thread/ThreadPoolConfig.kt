package com.example.mydownloader.config.thread

import com.example.mydownloader.utils.log.LogUtil
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger

/**
 * <Description> TODO
 *
 * @author Wallace
 * @Date 2021/11/19 9:23
 */
object ThreadPoolConfig {
    /**运行时CPU核心数 */
    private val CPU_COUNT = Runtime.getRuntime().availableProcessors()

    /**核心线程数量 */
    val CORE_POOL_SIZE = 2.coerceAtLeast((CPU_COUNT - 1).coerceAtMost(4))

    /**
     * 线程池最大容纳线程数
     * 对于IO密集型应用，此处为 ：运行时CPU心数*2+1
     * 对于cpu密集型应用，此处为 ：运行时CPU心数*+1
     */
    val IO_MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1
    val CPU_MAXIMUM_POOL_SIZE = CPU_COUNT + 1

    /**线程空闲后的存活时长 */
    const val KEEP_ALIVE_TIME = 30L

    /**任务过多后，存储任务的一个阻塞队列 */
    val WORK_QUEUE: BlockingQueue<Runnable> = SynchronousQueue()

    /**线程的创建工厂 */
    var threadFactory: ThreadFactory = object : ThreadFactory {
        val mCount: AtomicInteger = AtomicInteger(1)
        override fun newThread(r: Runnable?): Thread {
            return Thread(r, "MyDownloaderAsyncTask #" + mCount.getAndIncrement())
        }
    }

    /**线程池任务满载后采取的任务拒绝策略 */
    var rejectHandler: RejectedExecutionHandler = ThreadPoolExecutor.DiscardOldestPolicy()

    /**自定义的拒绝策略 */
    var myRejectHandler =
        RejectedExecutionHandler { r, executor -> LogUtil.w("任务$r discard by $executor") }
}