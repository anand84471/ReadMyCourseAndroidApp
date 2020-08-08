package com.readmycourse.android.DI.Concrete;

import android.content.Context;



import com.readmycourse.android.DI.Abstract.IServiceLocator;
import com.readmycourse.android.apiclient.ApiLayer.Abstract.IApplicationRetrofitInterface;
import com.readmycourse.android.apiclient.ApiLayer.Abstract.IStudentApiController;
import com.readmycourse.android.apiclient.ApiLayer.Concrete.ApplicationRetrofitInterface;
import com.readmycourse.android.apiclient.BusinessLayer.Abstract.IStudentApiBusinessLayer;
import com.readmycourse.android.apiclient.ServiceLayer.Abstract.IStudentApiServiceLayer;
import com.readmycourse.android.utilities.Abstract.IApplicationProgressBarUtils;
import com.readmycourse.android.utilities.Concrete.ApplicationProgressBarUtils;
import com.readmycourse.android.webview.Abstract.IApplicationWebView;
import com.readmycourse.android.webview.Abstract.IWebViewCallback;
import com.readmycourse.android.webview.Concrete.ApplicationWebView;
import com.readmycourse.android.webview.Concrete.CustomChromeClient;

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
