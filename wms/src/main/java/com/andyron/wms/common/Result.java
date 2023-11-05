package com.andyron.wms.common;

import lombok.Data;

/**
 * @author andyron
 **/
@Data
public class Result {
    private int code;
    private String msg;
    private Long total;
    private Object data;

    private static Result result(int code, String msg, Long total, Object data) {
        Result r = new Result();
        r.code = code;
        r.msg = msg;
        r.total = total;
        r.data = data;
        return r;
    }

    public static Result fail() {
        return result(400, "失败", 0L, null);
    }
    public static Result suc() {
        return result(200, "成功", 0L, null);
    }

    public static Result suc(Object data) {
        return result(200, "成功", 0L, data);
    }

    public static Result suc(Object data, Long total) {
        return result(200, "成功", total, data);
    }
}
