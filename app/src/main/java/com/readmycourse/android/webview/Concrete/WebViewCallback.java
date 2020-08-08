package com.readmycourse.android.webview.Concrete;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;


import com.readmycourse.android.constants.ConfigConstants;
import com.readmycourse.android.webview.Abstract.IWebViewCallback;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class WebViewCallback implements IWebViewCallback {
    Context context;
    public WebViewCallback(Context ctx)
    {
        this.context=ctx;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if(url.equals(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_HOME)||url.equals(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_HOME+"/"))
        {
            if(getIsInstructorAccount()){
                view.loadUrl(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_INSTRUCTOR);
            }
            else {
                view.loadUrl(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_STUDENT);
            }
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {

    }
    private boolean getIsInstructorAccount() {
        SharedPreferences pref =  Objects.requireNonNull(context).getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isInstructorSelected",false);
        return  isIntroActivityOpnendBefore;
    }
}
