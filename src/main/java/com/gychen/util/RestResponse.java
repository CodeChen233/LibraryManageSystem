package com.gychen.util;

import java.util.HashMap;
import java.util.List;

/**
 * REST 接口返回数据
 *
 * @author gychen
 */
public class RestResponse extends HashMap<String, Object> {

    /**
     * 禁止通过构造函数构造对象，只能通过静态方法获取实例。
     *
     * @see #ok()
     * @see #ok(String)
     * @see #fail()
     * @see #fail(String)
     */
    private RestResponse() {
    }



    /**
     * 设置接口返回的文本消息，属性 key: message
     *
     * @param msg
     * @return
     */
    public RestResponse msg(String msg) {
        this.put(Constants.OK_MSG, msg);
        return this;
    }

    /**
     * 设置接口返回的数据对象，属性 key: item
     *
     * @param item
     * @return
     */
    public RestResponse item(Object item) {
        this.put(Constants.ITEM, item);
        return this;
    }

    /**
     * 设置接口返回的数据对象列表，属性 key: list
     *
     * @param list
     * @return
     */
    public RestResponse list(List<?> list) {
        this.put("data", list);
        return this;
    }

    /**
     * 设置接口返回的数据项，并指定数据项的属性 key
     *
     * @param key
     * @param value
     * @return
     */
    public RestResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 接口执行成功的返回数据，其中属性 OK_CODE = 0
     *
     * @return
     */
    public static RestResponse ok() {
        RestResponse result = new RestResponse();
        result.put("code", Constants.OK_CODE);
        result.put("msg", Constants.OK_MSG);
        return result;
    }

    /**
     * 接口执行成功的返回数据，并设置文本消息
     *
     * @param msg
     * @return
     */
    public static RestResponse ok(String msg) {
        RestResponse result = new RestResponse();
        result.put("code", Constants.OK_CODE);
        result.put("msg", Constants.OK_MSG).msg(msg);
        return result;
    }

    /**
     * 接口执行成功的返回数据，并设置对象数据
     *
     * @param item
     * @return
     */
    public static RestResponse ok(Object item) {
        RestResponse result = new RestResponse();
        result.put("msg", Constants.OK_MSG);
        result.put("code", Constants.OK_CODE).item(item);
        return result;
    }

    /**
     * 接口执行成功的返回数据，并设置列表对象数据
     *
     * @param list
     * @return
     */
    public static RestResponse ok(List<?> list) {
        RestResponse result = new RestResponse();
        result.put("code", Constants.OK_CODE);
        result.put("msg",Constants.OK_MSG).list(list);
        return result;
    }

    /**
     * 接口执行失败的返回数据，其中属性 FIAL_CODE = 1
     *
     * @return
     */
    public static RestResponse fail() {
        RestResponse result = new RestResponse();
        result.put("code", Constants.FAIL_CODE);
        result.put("msg", Constants.FAIL_MSG);
        return result;
    }

    /**
     * 接口执行失败的返回数据，并设置文本消息，其中属性 error = 1, message = {msg}
     *
     * @param msg
     * @return
     */
    public static RestResponse fail(String msg) {
        RestResponse result = new RestResponse();
        result.put("msg", Constants.FAIL_MSG);
        result.put("code", Constants.FAIL_CODE).msg(msg);
        return result;
    }

    /**
     * 接口执行失败的返回数据，自定义状态码，其中属性 error = {errcode}
     *
     * @param errcode
     * @return
     */
    public static RestResponse fail(int errcode) {
        RestResponse result = new RestResponse();
        result.put("msg", Constants.FAIL_MSG);
        result.put("code", errcode);
        return result;
    }
}