package pers.weisg.cloud.common.core.util;

import pers.weisg.cloud.common.core.result.ResponseResult;


public class ApiResultUtil {


    public static ApiResult ok(Object data) {
        ResponseResult result = new ResponseResult();
        result.setData(data);
        ApiResult apiResult = new ApiResult();
        apiResult.setResult(result);
        return apiResult;
    }

    public static ApiResult fail(Throwable throwable) {
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseResult.FAIL);
        result.setMsg(throwable.getMessage());
        ApiResult apiResult = new ApiResult();
        apiResult.setResult(result);
        return apiResult;
    }

    public static ApiResult fail(String message) {
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseResult.FAIL);
        result.setMsg(message);
        ApiResult apiResult = new ApiResult();
        apiResult.setResult(result);
        return apiResult;
    }


}
