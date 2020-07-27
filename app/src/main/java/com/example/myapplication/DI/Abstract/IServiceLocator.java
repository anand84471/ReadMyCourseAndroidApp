package com.example.myapplication.DI.Abstract;

import android.content.Context;

import com.example.myapplication.webview.Abstract.IApplicationWebView;
import com.example.myapplication.webview.Abstract.ICustomChromeClient;

public interface IServiceLocator {
    ICustomChromeClient getCustomChromeClient(Context ctx);
    IApplicationWebView getApplicationWebView(Context ctx);
}
