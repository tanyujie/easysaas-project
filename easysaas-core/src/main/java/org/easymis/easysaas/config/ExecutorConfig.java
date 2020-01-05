package org.easymis.easysaas.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@Slf4j
@EnableAsync
public class ExecutorConfig {

    /**
     * 成功支付后异步执行线程池
     *
     * @return
     */
    @Bean("QueryQuantityAsyncExecutorPool")
    public ThreadPoolTaskExecutor queryQuantityAsyncExecutorPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(100);
        executor.setCorePoolSize(50);
        executor.setAllowCoreThreadTimeOut(false);  //超过最大核心数 空闲时不关闭
        executor.setKeepAliveSeconds(5 * 60);  //存活时间 5分钟
        executor.setQueueCapacity(1000);  //最大队列数
        executor.setThreadNamePrefix("queryQuantity-async-executor");  //线程前缀名
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());   //当执行任务被拒接添加到线程时,主线程自己执行该任务
        executor.initialize();
        return executor;
    }


    /**
     * 成功支付后异步执行线程池
     *
     * @return
     */
    @Bean("afterSuccessfulPayAsyncExecutorPool")
    public Executor afterSuccessfulPayAsyncExecutorPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(100);
        executor.setCorePoolSize(20);
        executor.setAllowCoreThreadTimeOut(false);  //超过最大核心数 空闲时不关闭
        executor.setKeepAliveSeconds(5 * 60);  //存活时间 5分钟
        executor.setQueueCapacity(1000);  //最大队列数
        executor.setThreadNamePrefix("afterSuccessfulPay-async-executor");  //线程前缀名
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());   //当执行任务被拒接添加到线程时,主线程自己执行该任务

        executor.initialize();
        return executor;
    }

    /**
     * 发送邮件异步执行线程池
     *
     * @return
     */
    @Bean("sendEmailAsyncExecutorPool")
    public Executor sendEmailAsyncExecutorPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(200);
        executor.setCorePoolSize(20);
        executor.setAllowCoreThreadTimeOut(false);  //超过最大核心数 空闲时不关闭
        executor.setKeepAliveSeconds(5 * 60);  //存活时间 5分钟
        executor.setQueueCapacity(1000);  //最大队列数
        executor.setThreadNamePrefix("sendEmail-async-executor");  //线程前缀名
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());   //当执行任务被拒接添加到线程时,主线程自己执行该任务
        executor.initialize();
        return executor;
    }

    /**
     *
     *  导出excel
     * @return
     */
    @Bean("exportedQueryResultAsyncExecutorPool")
    public Executor exportedQueryResultAsyncExecutorPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(200);
        executor.setCorePoolSize(20);
        executor.setAllowCoreThreadTimeOut(false);  //超过最大核心数 空闲时不关闭
        executor.setKeepAliveSeconds(5 * 60);  //存活时间 5分钟
        executor.setQueueCapacity(1000);  //最大队列数
        executor.setThreadNamePrefix("exportedQueryResult-async-executor");  //线程前缀名
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());   //当执行任务被拒接添加到线程时,主线程自己执行该任务
        executor.initialize();
        return executor;
    }


}
