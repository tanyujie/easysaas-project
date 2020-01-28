package org.easymis.easysaas.portal.thread.pool;

public class TempThread  implements Runnable  {
	     @Override
	     public void run() {
	         // 打印正在执行的缓存线程信息
	         System.out.println(Thread.currentThread().getName() + "正在被执行");
	         try {
	             // sleep一秒保证3个任务在分别在3个线程上执行
	             Thread.sleep(1000);
	        } catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	     }
}
