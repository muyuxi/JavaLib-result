package com.fengwneyi.javalib.result;

import com.fengwenyi.javalib.result.BaseCodeMsg;
import com.fengwenyi.javalib.result.Result;
import org.junit.Test;

/**
 * @author Erwin Feng
 * @since 2019-03-24 14:55
 */
public class TestResult {

    /* data */
    private Object obj = new Object();

    @Test
    public void start() {
        Result.error();
        Result.success();

        Result result = Result.error().setCode(-1000);
        System.out.println(result); // Result{code=-1000, msg='Error'}

    }

    // 简单例子
    @Test
    public void simple() {
        // 错误
        Result.error();

        // 错误类型
        Result.error(BaseCodeMsg.ERROR_INIT);

        // 成功
        Result.success();

        // 成功，返回数据
        Result.success(obj);
    }

    // 完整例子
    @Test
    public void complete() {
        // Error(-1, "Error")
        Result.error();

        // Error(-1, "Error")
        Result.error(BaseCodeMsg.ERROR_INIT);

        // Error(404, "Error")
        Result.error().setCode(404);

        // Error(404, "Not Found")
        Result.error().setCode(404).setMsg("Not Found");

        // Success(0, "Success")
        Result.success();

        // Success(0, "Success", obj)
        Result.success(obj);

        // Success(200, "Success")
        Result.success().setCode(200);

        // Success(200, "Success")
        Result.success().setCode(200).setMsg("Success");

        // Success(200, "Success", obj)
        Result.success().setCode(200).setData(obj);

        // Success(200, "Success", obj)
        Result.success().setCode(200).setMsg("Success").setData(obj);
    }

    @Test
    public void mResult() {
        System.out.println(MResult.ok()); // MResult{code=200, msg='OK', success=true}

        System.out.println(MResult.fail()); // Result{code=400, msg='Not Found'}
    }

}
