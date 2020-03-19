package org.easymis.easyicc.config.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源选择--自定义注解
 * @ClassName DataSource
 * @Description TODO
 * @author tanyujie
 * @date 2018年2月27日 上午11:23:41
 */
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface EasymisDataSource {

	DataSourceType value() default DataSourceType.Master;	//默认主表
	
}
