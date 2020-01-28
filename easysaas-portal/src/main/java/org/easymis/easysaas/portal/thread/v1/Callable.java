package org.easymis.easysaas.portal.thread.v1;

import org.elasticsearch.common.recycler.Recycler.V;

public interface Callable {
	V call() throws Exception;
}
