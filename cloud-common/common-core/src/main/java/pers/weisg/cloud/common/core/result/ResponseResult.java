package pers.weisg.cloud.common.core.result;

import java.io.Serializable;

/**
 * 功能描述  响应信息主体
 * author WEISANGENG
 * date 2019/2/10
 */
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SUCCESS = "00000";

    public static final String FAIL = "99999";

    private String msg = "success";

    private String code = SUCCESS;

    private Object[] args;

    private String app;

    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(T data) {
        super();
        this.data = data;
    }

    public ResponseResult(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public ResponseResult(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = FAIL;
    }

    public ResponseResult(Exception e) {
        super();
        this.msg = e.getMessage();
        this.code = FAIL;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
    
}
