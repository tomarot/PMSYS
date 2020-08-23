package com.magic.www.permissions.parameterExpand;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/2
 * Time: 13:27
 * 风向标参数拓展 各周期分页查询
 */

public class WindVaneParameter {

    //月 页大小
    private int month_pageSize;
    //月 页码
    private int month_pageNum;
    //周 页大小
    private int week_pageSize;
    //周 页码
    private int week_pageNum;
    //日 页大小
    private int day_pageSize;
    //日 页码
    private int day_pageNum;
    //操作类型 0 全 1 日 2 周 3 月
    private int optionType;

    public int getMonth_pageSize() {
        return month_pageSize;
    }

    public void setMonth_pageSize(int month_pageSize) {
        this.month_pageSize = month_pageSize;
    }

    public int getMonth_pageNum() {
        return month_pageNum;
    }

    public void setMonth_pageNum(int month_pageNum) {
        this.month_pageNum = month_pageNum;
    }

    public int getWeek_pageSize() {
        return week_pageSize;
    }

    public void setWeek_pageSize(int week_pageSize) {
        this.week_pageSize = week_pageSize;
    }

    public int getWeek_pageNum() {
        return week_pageNum;
    }

    public void setWeek_pageNum(int week_pageNum) {
        this.week_pageNum = week_pageNum;
    }

    public int getDay_pageSize() {
        return day_pageSize;
    }

    public void setDay_pageSize(int day_pageSize) {
        this.day_pageSize = day_pageSize;
    }

    public int getDay_pageNum() {
        return day_pageNum;
    }

    public void setDay_pageNum(int day_pageNum) {
        this.day_pageNum = day_pageNum;
    }

    public int getOptionType() {
        return optionType;
    }

    public void setOptionType(int optionType) {
        this.optionType = optionType;
    }
}
