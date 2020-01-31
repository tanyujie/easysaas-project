package org.easymis.easysaas.portal.entitys.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: LX
 * @Description:
 * @Date: Created in 11:24 2018/11/6
 * @Modified by:
 */
@Data
@ToString
@NoArgsConstructor
public class EsModel {

    private String id;

    private String name;

    private int age;

    private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}
