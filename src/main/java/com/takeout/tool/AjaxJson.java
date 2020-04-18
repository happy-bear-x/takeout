package com.takeout.tool;

import lombok.Data;

@Data
public class AjaxJson {
    private String msg="成功";
    private boolean success=true;
    private Object obj;
}
