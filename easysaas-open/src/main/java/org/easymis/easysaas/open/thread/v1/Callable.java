package org.easymis.easysaas.open.thread.v1;

import org.elasticsearch.common.recycler.Recycler.V;

public interface Callable {
	V call() throws Exception;
}
