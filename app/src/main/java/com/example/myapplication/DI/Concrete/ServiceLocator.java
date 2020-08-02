package com.example.myapplication.DI.Concrete;

import android.content.Context;

import com.example.myapplication.DI.Abstract.IServiceLocator;
import com.example.myapplication.apiclient.ApiLayer.Abstract.IApplicationRetrofitInterface;
import com.example.myapplication.apiclient.ApiLayer.Abstract.IStudentApiController;
import com.example.myapplication.apiclient.ApiLayer.Concrete.ApplicationRetrofitInterface;
import com.example.myapplication.apiclient.BusinessLayer.Abstract.IStudentApiBusinessLayer;
import com.example.myapplication.apiclient.ServiceLayer.Abstract.IStudentApiServiceLayer;
import com.example.myapplication.utilities.Abstract.IApplicationProgressBarUtils;
import com.example.myapplication.utilities.Concrete.ApplicationProgressBarUtils;
import com.example.myapplication.webview.Abstract.IApplicationWebView;
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
    public CustomChromeClient getCustomChromeClient(Context ctx) {
        return  new CustomChromeClient(ctx);
    }

    @Override
    public IStudentApiBusinessLayer getStudentApiBusinessService() {
        return null;
    }

    @Override
    public IStudentApiController getStudentApiController() {
        return null;
    }

    @Override
    public IStudentApiServiceLayer getStudentApiServiceLayer() {
        return null;
    }

    @Override
    public IApplicationWebView getApplicationWebView(Context ctx, IWebViewCallback webViewCallback) {
        return new ApplicationWebView( webViewCallback);
    }

    @Override
    public IApplicationRetrofitInterface getApplicationRetrofitInterface() {
        return new ApplicationRetrofitInterface();
    }

    @Override
    public IApplicationProgressBarUtils getApplicationProgressBarUtils() {
        return new ApplicationProgressBarUtils();
    }
}
