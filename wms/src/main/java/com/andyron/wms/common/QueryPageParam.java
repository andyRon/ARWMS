package com.andyron.wms.common;

import lombok.Data;

import java.util.HashMap;

/**
 * @author andyron
 **/
@Data
public class QueryPageParam {
    /**
     * 默认
     */
    private static int PAGE_SIZE = 20;
    private static int PAGE_NUM = 1;

    public int pageSize = PAGE_SIZE;
    public int pageNum = PAGE_NUM;

    public HashMap param = new HashMap();
}
