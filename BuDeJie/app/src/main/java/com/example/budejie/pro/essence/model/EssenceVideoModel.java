package com.example.budejie.pro.essence.model;

import android.content.Context;
import android.text.TextUtils;

import com.example.budejie.okhttp.HttpCallBack;
import com.example.budejie.okhttp.HttpManger;
import com.example.budejie.pro.base.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

public class EssenceVideoModel extends BaseModel {

    public EssenceVideoModel(Context context) {
        super(context);
    }

    private String getUrl(){
        return getServerUrl().concat("/api/api_open.php");
    }

    public void getEssenceList(int type, int page, String maxtime, HttpCallBack onHttpResultListener){
        Map param = new HashMap();
        param.put("a","list");
        param.put("c","data");
        param.put("type",type+"");
        param.put("page",page+"");
        if (!TextUtils.isEmpty(maxtime)){
            param.put("maxtime",maxtime);
        }
        //发送请求
        HttpManger.getInstance().post(getUrl(),param,onHttpResultListener);
    }
}
