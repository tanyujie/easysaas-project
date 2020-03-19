package org.easymis.easyicc.common.result.exception;

public class ElasticSearchMaxRecordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public ElasticSearchMaxRecordException() {
        super("ElasticSearch查询异常");
    }
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
