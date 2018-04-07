/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author rtmss
 */
public class ApiResult {
    
    private int code;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object body;

    public ApiResult() {
    }

    public ApiResult(int code, Object body) {
        this.code = code;
        this.body = body;
    }

    public ApiResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public ApiResult setCode(int code) {
        this.code = code;
        return this;
    }

    public Object getBody() {
        return body;
    }

    public ApiResult setBody(Object body) {
        this.body = body;
        return this;
    }
}
