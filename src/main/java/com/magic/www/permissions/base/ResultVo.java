package com.magic.www.permissions.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/12
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 *
 * 标准数据返回VO对象
 */
public class ResultVo<T> {

    //状态码 200：成功 500：失败
    private int result_code;
    //信息
    private String result_msg;
    //返回数据
    private Object resultData;
    //返回集合
    private List<T> resultList;
    //总数
    private int count;

    //成功号码
    public static final int CODE_SUCCESS = 200;
    //失败号码
    public static final int CODE_FAILED = 500;
    //成功默认提示信息
    public static final String MSG_SUCCESS = "操作成功";
    //失败默认提示信息
    public static final String MSG_FAILED = "操作失败";

    public ResultVo() {
        result_code = this.CODE_SUCCESS;
        result_msg = this.MSG_SUCCESS;
    }

    public ResultVo(int result_code, String result_msg) {
        this.result_code = result_code;
        this.result_msg = result_msg;
    }

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
