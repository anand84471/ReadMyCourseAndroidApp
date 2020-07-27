package com.example.myapplication.DI.Concrete;

import android.content.Context;

import com.example.myapplication.DI.Abstract.IServiceLocator;
import com.example.myapplication.webview.Abstract.IApplicationWebView;
import com.example.myapplication.webview.Abstract.ICustomChromeClient;
import com.example.myapplication.webview.Abstract.IWebViewCallback;
import com.example.myapplication.webview.Concrete.ApplicationWebView;
import com.example.myapplication.webview.Concrete.CustomChromeClient;
import com.example.myapplication.webview.Concrete.WebViewCallback;

public class ServiceLocator implements IServiceLocator {
    private static ServiceLocator instance = null;
    private ServiceLocator() {}
    public static ServiceLocator getInstance() {
        if (instance == null) {
            synchronized(ServiceLocator.class) {
                instance = new ServiceLocator();
            }
        }
        return instance;
    }

    @Override
    public ICustomChromeClient getCustomChromeClient(Context ctx) {
        return  new CustomChromeClient(ctx);
    }

    @Override
    public IApplicationWebView getApplicationWebView(Context ctx) {
        return new ApplicationWebView(new WebViewCallback(ctx));
    }
}
