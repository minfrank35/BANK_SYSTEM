package com.software.banksystem;

import org.json.simple.parser.ParseException;

public class ApiUtil {
    public String requestUrl;
    public OnResponse onResponse;

    public ApiUtil(String requestUrl, OnResponse onResponse) {
        this.requestUrl = requestUrl;
        this.onResponse = onResponse;
    }

    public String requestPost(String requestData) {
        return Retrofit.create(requestData, onResponse).requestPostData();
    }

    public String requestGet(String requestData) {
        return Retrofit.create(requestData, onResponse).requestPostData();
    }

    interface OnResponse {
        public void onFail(String res);
        public void onSuccess(String res) throws ParseException;
    }
}
