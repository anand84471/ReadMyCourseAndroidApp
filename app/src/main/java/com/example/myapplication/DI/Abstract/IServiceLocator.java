package com.example.myapplication.DI.Abstract;

import android.content.Context;

import com.example.myapplication.utilities.Abstract.IApplicationProgressBarUtils;
import com.example.myapplication.webview.Abstract.IApplicationWebView;
import com.example.myapplication.webview.Abstract.ICustomChromeClient;
import com.example.myapplication.webview.Abstract.IWebViewCallback;

public interface IServiceLocator {
    ICustomChromeClient getCustomChromeClient(Context ctx);
    IApplicationWebView getApplicationWebView(Context ctx,IWebViewCallback webViewCallback);
    IApplicationProgressBarUtils getApplicationProgressBarUtils();
}
