package com.maiya.shopcloud.base.base;

/**
 * 功能描述:响应结果基础类
 *
 * @auther:  mandy.hu
 */
public class BaseResult {
    /** 结果码 **/
    protected String resultCode;
    /** 结果消息 **/
    protected String resultMsg;

    public BaseResult() {
    }

    public BaseResult(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
