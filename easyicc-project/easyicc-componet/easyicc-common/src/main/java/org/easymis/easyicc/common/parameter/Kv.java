package org.easymis.easyicc.common.parameter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
public class Kv extends HashMap {

	public Kv() {
	}

	public static Kv by(Object key, Object value) {
		return new Kv().set(key, value);
	}

	public static Kv create() {
		return new Kv();
	}

	public Kv set(Object key, Object value) {
		super.put(key, value);
		return this;
	}

	public Kv setIfNotBlank(Object key, String value) {
		if (StringUtils.isNoneBlank(value)) {
			set(key, value);
		}
		return this;
	}

	public Kv setIfNotNull(Object key, Object value) {
		if (value != null) {
			set(key, value);
		}
		return this;
	}

	public Kv set(Map map) {
		super.putAll(map);
		return this;
	}

	public Kv set(Kv kv) {
		super.putAll(kv);
		return this;
	}

	public Kv delete(Object key) {
		super.remove(key);
		return this;
	}

	public <T> T getAs(Object key) {
		return (T) get(key);
	}

	public String getStr(Object key) {
		Object s = get(key);
		return s != null ? s.toString() : null;
	}

	public Integer getInt(Object key) {
		Number n = (Number) get(key);
		return n != null ? n.intValue() : null;
	}

	public Long getLong(Object key) {
		Number n = (Number) get(key);
		return n != null ? n.longValue() : null;
	}

	public Number getNumber(Object key) {
		return (Number) get(key);
	}

	public Boolean getBoolean(Object key) {
		return (Boolean) get(key);
	}

	/**
	 * key 瀛樺湪锛屽苟涓� value 涓嶄负 null
	 */
	public boolean notNull(Object key) {
		return get(key) != null;
	}

	/**
	 * key 涓嶅瓨鍦紝鎴栬�� key 瀛樺湪浣� value 涓簄ull
	 */
	public boolean isNull(Object key) {
		return get(key) == null;
	}

	/**
	 * key 瀛樺湪锛屽苟涓� value 涓� true锛屽垯杩斿洖 true
	 */
	public boolean isTrue(Object key) {
		Object value = get(key);
		return (value instanceof Boolean && ((Boolean) value == true));
	}

	/**
	 * key 瀛樺湪锛屽苟涓� value 涓� false锛屽垯杩斿洖 true
	 */
	public boolean isFalse(Object key) {
		Object value = get(key);
		return (value instanceof Boolean && ((Boolean) value == false));
	}

	public String toJson() {
		// JSONObject jsonObject = JSON.parseObject(rowData);
		// return Json.getJson().toJson(this);
		return "";
	}

	public boolean equals(Object kv) {
		return kv instanceof Kv && super.equals(kv);
	}
}
