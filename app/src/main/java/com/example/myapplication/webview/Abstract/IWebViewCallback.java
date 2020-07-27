package com.example.myapplication.webview.Abstract;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public interface IWebViewCallback {
    boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request);
    void onPageStarted(WebView view, String url, Bitmap favicon);
    void onPageFinished(WebView view, String url);
}
