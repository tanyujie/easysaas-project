package org.easymis.easysaas.portal.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 2.3 Executors.newScheduledThreadPool(int n)：创建一个定长线程池，支持定时及周期性任务执行
 *
 */
public class ThreadPoolExecutorTest3 {
	public static void main(String[] args) {
		// 创建一个定长线程池，支持定时及周期性任务执行——延迟执行
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		// 延迟1秒执行
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("延迟1秒执行");
			}
		}, 1, TimeUnit.SECONDS);
	}
}
