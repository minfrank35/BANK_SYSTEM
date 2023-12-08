package com.software.banksystem;

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
        public void onSuccess(String res);
    }
}
