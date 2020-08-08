package com.readmycourse.android.webview.Concrete;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.readmycourse.android.webview.Abstract.IApplicationWebView;
import com.readmycourse.android.webview.Abstract.IWebViewCallback;


public class ApplicationWebView extends WebViewClient implements IApplicationWebView {
    IWebViewCallback iWebViewCallback;
    public ApplicationWebView(IWebViewCallback iWebViewCallback)
    {
        this.iWebViewCallback=iWebViewCallback;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        iWebViewCallback.onPageStarted(view,url,favicon);
        super.onPageStarted(view, url, favicon);
    }
    @Override
    public void onPageFinished(WebView view, String url) {
        iWebViewCallback.onPageFinished(view,url);
        super.onPageFinished(view, url);

    }

}
