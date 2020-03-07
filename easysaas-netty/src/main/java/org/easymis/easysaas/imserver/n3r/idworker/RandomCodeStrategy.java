package org.easymis.easysaas.imserver.n3r.idworker;
public interface RandomCodeStrategy {

    void init();

    int prefix();

    int next();

    void release();
}
