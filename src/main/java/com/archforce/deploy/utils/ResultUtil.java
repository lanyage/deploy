package com.archforce.deploy.utils;

import com.archforce.deploy.pojo.Result;

/**
 * Created by lanyage on 2018/6/28.
 */
public class ResultUtil {
    public static Result success(Object t) {
        Result result = new Result<>();
        result.setCode(0);
        result.setData(t);
        result.setMessage("操作成功");
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(String message) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage(message);
        return result;
    }
}
