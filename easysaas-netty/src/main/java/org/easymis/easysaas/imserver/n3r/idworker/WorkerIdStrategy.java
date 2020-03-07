package org.easymis.easysaas.imserver.n3r.idworker;

public interface WorkerIdStrategy {

    void initialize();

    long availableWorkerId();

    void release();
}
