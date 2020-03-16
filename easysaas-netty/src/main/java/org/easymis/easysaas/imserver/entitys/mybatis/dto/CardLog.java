package org.easymis.easysaas.imserver.entitys.mybatis.dto;

import lombok.Data;

@Data
public class CardLog {
	public final static int ALLOCATION_TYPE_SYSTEM = 1;
	
	public final static int ALLOCATION_TYPE_USER = 2;
	
	public final static int ALLOCATION_TYPE_BACK = 3;
	
	public final static int ALLOCATION_TYPE_FINISHED = 4;
	
	public final static int ALLOCATION_TYPE_EXPIRED = 5;
	
	public final static int ALLOCATION_TYPE_SALE = 6;
	
	public final static int ALLOCATION_TYPE_SALE_FINIHSED = 7;
}
