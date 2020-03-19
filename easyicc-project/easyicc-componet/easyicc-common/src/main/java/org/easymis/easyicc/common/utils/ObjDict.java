package org.easymis.easyicc.common.utils;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanwenbin on 11/24/2016.
 */
public class ObjDict<T> {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private Class<T> ObjClass;

    private PropertyDescriptor[] descriptors;

    private PropertyUtilsBean propertyUtilsBean;

   /* public ObjDict() {
        super();
    }*/

    public ObjDict(Class<T> ObjClass) {
        if (ObjClass == null) {
            throw new IllegalArgumentException("the class cannot be empty");
        }
        this.ObjClass = ObjClass;
        this.propertyUtilsBean = new PropertyUtilsBean();
        this.descriptors = propertyUtilsBean.getPropertyDescriptors(ObjClass);
    }

    /*public ObjDict(Class objClass, PropertyDescriptor[] descriptors) {
        super();
        ObjClass = objClass;
        this.descriptors = descriptors;
    }*/

    public static String toFirstUpperCase(String str) {
        StringBuilder builder = new StringBuilder(str);
        builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
        return builder.toString();
    }

    public Class getObjClass() {
        return ObjClass;
    }

    public void setObjClass(Class objClass) {
        if (ObjClass == null) {
            throw new IllegalArgumentException("the class cannot be empty");
        }
        ObjClass = objClass;
    }

    public PropertyDescriptor[] getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(PropertyDescriptor[] descriptors) {
        this.descriptors = descriptors;
    }

    public <T> Map<String, Object> conversion(T bean) {
        Map<String, Object> params = new HashMap<String, Object>(this.descriptors.length * 3 / 2);
        if (bean == null) {
            throw new IllegalArgumentException("the bean cannot be empty");
        }
        try {
            for (int i = 0; i < this.descriptors.length; i++) {
                String propertyName = descriptors[i].getName();
                if (!StringUtils.equals(propertyName, "class")) {
                    Object value = propertyUtilsBean.getNestedProperty(bean, propertyName);
                    if (value != null) {
                        params.put(propertyName, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return params;
    }

    public T conversion(Map map) {
        log.info("map conversion " + ObjClass.getName() + " Instance");
        if (map == null) {
            throw new IllegalArgumentException("the map cannot be empty");
        }
        T bean = null;
        try {
            bean = ObjClass.newInstance();
            for (PropertyDescriptor descriptor : descriptors) {
                if (!StringUtils.equals(descriptor.getName(), "class")) {
                    String property = ObjDict.toFirstUpperCase(descriptor.getName());
                    if (map.containsKey(property)) {

                        Method method = ObjClass.getMethod("set" + property, map.get(property).getClass());
                        method.setAccessible(true);
                        method.invoke(bean, map.get(property));


                    }

                }
            }
        } catch (IllegalAccessException e) {
            log.error(e.toString());
        } catch (InvocationTargetException e) {
            log.error(e.toString());
        } catch (NoSuchMethodException e) {
            log.error(e.toString());
        } catch (InstantiationException e) {
            log.error(e.toString());
        }


        return bean;
    }

    /**
     * @param source, target
     * @Author
     * @Version 1.0
     * @Description 下划线 转 驼峰 不能嵌套 ,
     * @Return void
     * @Exception
     * @Date 2019/6/10
     */
    public <K> void copyProperties(T source,
                                   K targetBean) {

        Class targetClass = targetBean.getClass();
        PropertyUtilsBean targetPropertyUtilsBean = new PropertyUtilsBean();

        for (int i = 0; i < this.descriptors.length; i++) {
            try {
                String propertyName = descriptors[i].getName();
                if (!StringUtils.equals(propertyName, "class")) {
                    String[] splits = propertyName.split("_");
                    String newPropertyName = "";
                    if (splits.length > 1) {
                        StringBuilder builder = new StringBuilder(splits[0]);
                        for (int index = 1; index < splits.length; index++) {
                            splits[index] = toFirstUpperCase(splits[index]);
                            builder.append(splits[index]);
                        }
                        newPropertyName = builder.toString();
                    } else {
                        newPropertyName = propertyName;
                    }
                    PropertyDescriptor targetProperty = targetPropertyUtilsBean.getPropertyDescriptor(targetBean, newPropertyName);
                    if (targetProperty != null) {
                        Object value = propertyUtilsBean.getNestedProperty(source, propertyName);
                        if (value != null) {
                            String property = ObjDict.toFirstUpperCase(targetProperty.getName());
                            // Method  method=targetProperty.getWriteMethod();
                            Method method = targetClass.getMethod("set" + property, value.getClass());
                            method.setAccessible(true);
                            method.invoke(targetBean, value);
                        }
                    }


                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Map<String, Object>> conversion(List<T> beans) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(beans.size());
        for (T bean : beans) {
            Map<String, Object> params = this.conversion(bean);
            list.add(params);
        }
        return list;
    }


}
