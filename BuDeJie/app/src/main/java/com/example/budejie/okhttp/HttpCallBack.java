package com.example.budejie.okhttp;

import java.io.IOException;

import okhttp3.Request;

public interface HttpCallBack {

    public void requestSuccess(Object result);

    public void requestFailure(IOException e);

}
