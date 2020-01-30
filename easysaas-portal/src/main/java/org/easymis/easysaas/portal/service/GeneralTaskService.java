package org.easymis.easysaas.portal.service;

import org.springframework.scheduling.annotation.Async;

public interface GeneralTaskService {
    @Async("sendEmailAsyncExecutorPool")
    void sendEmailAsyncExecutor(byte[] bytes, String toMail);
}
