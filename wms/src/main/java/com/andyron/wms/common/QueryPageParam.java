package com.andyron.wms.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;

/**
 * @author andyron
 **/
@ApiModel(value = "分页查询对象")
@Data
public class QueryPageParam {
    /**
     * 默认
     */
    private static int PAGE_SIZE = 20;
    private static int PAGE_NUM = 1;
    @ApiModelProperty(value = "当前页码")
    public int pageSize = PAGE_SIZE;
    @ApiModelProperty(value = "每页条数")
    public int pageNum = PAGE_NUM;

    public HashMap param = new HashMap();
}
