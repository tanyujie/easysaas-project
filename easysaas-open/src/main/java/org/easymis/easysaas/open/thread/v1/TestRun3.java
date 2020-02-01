package org.easymis.easysaas.open.thread.v1;

/**
 * 实现Runnable接口创建线程类
 */
public class TestRun3 {

	public static void main(String[] args) { // 步骤1：创建实现Callable接口的类SomeCallable(略);
		// 步骤2：创建一个类对象：
	//	Callable oneCallable = new SomeCallable();
		// 步骤3：由Callable创建一个FutureTask对象：
		//FutureTask oneTask = new FutureTask(oneCallable);
		// 注释： FutureTask是一个包装器，它通过接受Callable来创建，它同时实现了 Future和Runnable接口。
		// 步骤4：由FutureTask创建一个Thread对象：
		//Thread oneThread = new Thread(oneTask);
		// 步骤5：启动线程：
		//oneThread.start();
	}

}
