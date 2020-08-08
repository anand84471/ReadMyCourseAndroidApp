package com.readmycourse.android.DI.Abstract;

import android.content.Context;


import com.readmycourse.android.apiclient.ApiLayer.Abstract.IApplicationRetrofitInterface;
import com.readmycourse.android.apiclient.ApiLayer.Abstract.IStudentApiController;
import com.readmycourse.android.apiclient.BusinessLayer.Abstract.IStudentApiBusinessLayer;
import com.readmycourse.android.apiclient.ServiceLayer.Abstract.IStudentApiServiceLayer;
import com.readmycourse.android.utilities.Abstract.IApplicationProgressBarUtils;
import com.readmycourse.android.webview.Abstract.IApplicationWebView;
import com.readmycourse.android.webview.Abstract.ICustomChromeClient;
import com.readmycourse.android.webview.Abstract.IWebViewCallback;

public interface IServiceLocator {
    ICustomChromeClient getCustomChromeClient(Context ctx);
    IApplicationWebView getApplicationWebView(Context ctx, IWebViewCallback webViewCallback);
    IApplicationProgressBarUtils getApplicationProgressBarUtils();
    IStudentApiBusinessLayer getStudentApiBusinessService();
    IStudentApiController getStudentApiController();
    IStudentApiServiceLayer getStudentApiServiceLayer();
    IApplicationRetrofitInterface getApplicationRetrofitInterface();
}
