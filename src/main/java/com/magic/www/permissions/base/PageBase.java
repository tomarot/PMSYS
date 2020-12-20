package com.magic.www.permissions.base;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/2
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class PageBase {
    //分页功能状态 禁用
    public static int PAGE_STATE_DISABLE = 0;
    //分页功能状态 启用
    public static int PAGE_STATE_ENABLE = 1;


    //分页状态 0 禁用 1 启用
    private int pageState = 0;
    //条数
    private int pageSize;
    //页码
    private int pageNum;
    //分页查询 开始位置
    private int offset;

    public int getPageState() {
        return pageState;
    }

    public void setPageState(int pageState) {
        this.pageState = pageState;
        setPageSize(1);
        setPageNum(1);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.offset = (this.pageNum-1) * pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.offset = (pageNum-1) * this.pageSize;
    }

    public int getOffset() {
        return offset;
    }
}
