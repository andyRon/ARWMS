package com.andyron.wms.entity;

import lombok.Data;

/**
 * @author andyron
 **/
@Data
public class RecordRes extends Record {
    private String username;
    private String adminname;
    private String goodsname;
    private String storagename;
    private String goodstypename;
}
