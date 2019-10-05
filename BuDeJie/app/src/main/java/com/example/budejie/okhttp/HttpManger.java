package com.example.budejie.okhttp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HttpManger {

    //防止多个线程同时访问
    private volatile static HttpManger instance;


    public static HttpManger getInstance() {
        if (instance == null) {
            synchronized (HttpManger.class) {
                if (instance == null) {
                    instance = new HttpManger();
                }
            }
        }
        return instance;
    }


    public void get(String url, Map<String, String> params, final HttpCallBack callBack) {
        String urlStr = appendParams(url,params);
        okhttp3.Request request = new okhttp3.Request.Builder().url(urlStr).get().addHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)").build();

        OkHttpClient okHttpClient = new OkHttpClient();
        final Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                callBack.requestSuccess(response.body().string());
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.requestFailure(e);
            }
        });


    }

    public void post(String url, Map<String, String> params, final HttpCallBack callBack) {


        FormBody.Builder formBody = new FormBody.Builder();
        addParams(formBody, params);
        RequestBody body = formBody.build();

        okhttp3.Request request = new okhttp3.Request.Builder().url(url).post(body).addHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)").build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                callBack.requestSuccess(result);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.requestFailure(e);
            }
        });
    }


    //get 参数拼在url后面
    private String appendParams(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (url.indexOf("?") == -1) {
            sb.append(url + "?");
        } else {
            sb.append(url + "&");
        }

        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }
        }

        sb = sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    //键值对拼接的参数
    private void addParams(FormBody.Builder builder, Map<String, String> params) {
        if (builder == null) {
            throw new IllegalArgumentException("builder can not be null .");
        }

        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
    }




}
