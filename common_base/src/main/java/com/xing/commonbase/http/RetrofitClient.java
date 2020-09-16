package com.xing.commonbase.http;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.xing.commonbase.base.BaseApplication;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.interceptor.AddCookiesInterceptor;
import com.xing.commonbase.interceptor.ReceivedCookiesInterceptor;
import com.xing.commonbase.json.FastJsonConverterFactory;
import com.xing.commonbase.util.SharedPreferenceUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitClient {

//    private static final String API_HOST = "https://www.wanandroid.com/";
//    public static final String API_HOST = "http://10.2.8.154:8888/";
    private static RetrofitClient instance;
    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;

    private RetrofitClient() {

        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(),
                        new SharedPrefsCookiePersistor(BaseApplication.getApplication()));

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .addInterceptor(InterceptorUtil.logInterceptor())
                .addInterceptor(InterceptorUtil.headerTokenInterceptor())
//                .addInterceptor(InterceptorUtil.headerInterceptor())
//                .addInterceptor(new ReceivedCookiesInterceptor())
//                .addInterceptor(new AddCookiesInterceptor())
                .build();
        //记录访问地址
        String host = SharedPreferenceUtil.read(Constants.HOST, Constants.HOST, "http://10.2.8.154:8888/");
        retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())   // 使用 fastjson 解析器解析 json
                .client(okHttpClient)
                .build();

    }


    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}