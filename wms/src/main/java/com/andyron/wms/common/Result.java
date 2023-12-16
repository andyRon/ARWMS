package com.andyron.wms.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author andyron
 **/
@ApiModel(value = "返回结果对象")
@Data
public class Result {
    @ApiModelProperty(value = "返回码")
    private int code;
    @ApiModelProperty(value = "返回信息")
    private String msg;
    @ApiModelProperty(value = "返回数据条数")
    private Long total;
    @ApiModelProperty(value = "返回数据")
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
