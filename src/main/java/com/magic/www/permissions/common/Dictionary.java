package com.magic.www.permissions.common;

import com.magic.www.permissions.domain.WindVane;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/2
 * Time: 16:32
 * To change this template use File | Settings | File Templates.
 */
public class Dictionary {
    //风向标
    public static class Dictionary_WindVane{
        /*风向标周期*/
        public static String TYPE_MONTH = "3";//月
        public static String TYPE_WEEK = "2";//周
        public static String TYPE_DAY = "1"; //日

        //操作的周期
        public static int OPTION_TYPE_ALL = 0;//全部
        public static int OPTION_TYPE_DAY = 1;//日
        public static int OPTION_TYPE_WEEK = 2;//周
        public static int OPTION_TYPE_MONTH = 3;//月


    }
    //北向资金
    public static class Dictionary_NorthMoney{
        //数据类型
        public static String DATA_TYPE_HY = "0";//行业
        public static String DATA_TYPE_GN = "1";//概念

        //数据周期
        public static String PERIOD_TYPE_1R = "1";//1日
        public static String PERIOD_TYPE_3R = "3";//3日
        public static String PERIOD_TYPE_5R = "5";//5日
        public static String PERIOD_TYPE_10R = "10";//10日
        public static String PERIOD_TYPE_1Y = "m";//1月
        public static String PERIOD_TYPE_1JD = "jd";//1季度
        public static String PERIOD_TYPE_1N = "y";//1年
    }
    //板块基本信息
    public static class Dictionary_StockBase{
        //数据周期
        public static String PERIOD_TYPE_1R = "1";//1日
        public static String PERIOD_TYPE_3R = "3";//3日
        public static String PERIOD_TYPE_5R = "5";//5日
        public static String PERIOD_TYPE_10R = "10";//10日
    }
    //板块基本信息
    public static class Dictionary_PlateBase{
        //类型
        public static String TYPE_HY = "0";//0 行业
        public static String TYPE_GN = "1";//1 概念
        public static String TYPE_DY = "2";//2 地域

        //数据周期
        public static String PERIOD_TYPE_1R = "1";//1日
        public static String PERIOD_TYPE_5R = "5";//5日
        public static String PERIOD_TYPE_10R = "10";//10日

        //可用状态
        public static String AVAILABLE_N = "0";//0 不可用
        public static String AVAILABLE_Y = "1";//1 可用

        //可用状态
        public static String CONFIRM_STATE_N = "0";//0 未确认
        public static String CONFIRM_STATE_Y  = "1";//1 已确认

    }
}
