package pers.weisg.cloud.common.core.util;


import pers.weisg.cloud.common.core.result.ResponseResult;

public class ApiResult<T> {

    private String status = "OK";
    private ResponseResult<T> result = null;

    public ApiResult() {
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResponseResult<T> getResult() {
        return this.result;
    }

    public void setResult(ResponseResult<T> result) {
        this.result = result;
    }



}
