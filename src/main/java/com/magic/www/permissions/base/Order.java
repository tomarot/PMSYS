package com.magic.www.permissions.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/9
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public interface Order {

    //是否开启 排序 0 不启用 1 启用
    public int orderState = 0;
    //排序字段
    public List<String> orderFiele = new ArrayList<String>();

    /**
     * 设置排序字段
     * @param fieldList
     */
    default void setOrderField(List<String> fieldList){
        this.orderFiele.addAll(fieldList);
    }
}
