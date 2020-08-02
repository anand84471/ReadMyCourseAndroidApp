package com.example.myapplication.DI.Abstract;

import android.content.Context;

import com.example.myapplication.apiclient.ApiLayer.Abstract.IApplicationRetrofitInterface;
import com.example.myapplication.apiclient.ApiLayer.Abstract.IStudentApiController;
import com.example.myapplication.apiclient.BusinessLayer.Abstract.IStudentApiBusinessLayer;
import com.example.myapplication.apiclient.ServiceLayer.Abstract.IStudentApiServiceLayer;
import com.example.myapplication.utilities.Abstract.IApplicationProgressBarUtils;
import com.example.myapplication.webview.Abstract.IApplicationWebView;
import com.example.myapplication.webview.Abstract.ICustomChromeClient;
import com.example.myapplication.webview.Abstract.IWebViewCallback;

public interface IServiceLocator {
    ICustomChromeClient getCustomChromeClient(Context ctx);
    IApplicationWebView getApplicationWebView(Context ctx,IWebViewCallback webViewCallback);
    IApplicationProgressBarUtils getApplicationProgressBarUtils();
    IStudentApiBusinessLayer getStudentApiBusinessService();
    IStudentApiController getStudentApiController();
    IStudentApiServiceLayer getStudentApiServiceLayer();
    IApplicationRetrofitInterface getApplicationRetrofitInterface();
}
