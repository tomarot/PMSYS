package com.magic.www.permissions.utils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/2
 * Time: 17:03
 * 计算器
 * 计算对应的索引号
 */
public class Calculator {
    /**
     * 获取开始时间的索引号
     * @param num
     * @param size
     * @return
     */
    public static int getStartIndex(int num, int size){
        return (num-1)*size;
    }

    /**
     * 获取结束时间的索引号
     * @param num
     * @param size
     * @return
     */
    public static int getEndIndex(int num,int size){
        return (num*size)-1;
    }

    /**
     * 获取开始时间
     * @return
     */
    public static Date getStartDate(int num, int size, List<Date> dateList){
        int index = getEndIndex(num,size);
        return index>=dateList.size()?DateUtils.getNextDay(dateList.get(dateList.size()-1),1):dateList.get(index);
    }

    /**
     * 获取结束时间
     * @return
     */
    public static Date getEndDate(int num, int size,List<Date> dateList){
        int index = getStartIndex(num,size);
        return dateList.get(index>=dateList.size()?dateList.size()-1:index);
    }


}
