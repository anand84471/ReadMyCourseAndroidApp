package com.example.myapplication.webview.Concrete;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ui.home.HomeFragment;
import com.example.myapplication.webview.Abstract.IApplicationWebView;
import com.example.myapplication.webview.Abstract.ICustomChromeClient;
import com.example.myapplication.webview.Abstract.ICustomWebView;
import com.example.myapplication.webview.Abstract.IWebViewCallback;

public class CustomWebView extends AppCompatActivity implements ICustomWebView {
    private static final String TAG  ="CustomWebView" ;
    private Context ctx;
    private WebView webView;
    private ApplicationWebView applicationWebView;
    private CustomChromeClient customChromeClient;
    private String baseUrl;

    public  CustomWebView(Context ctx, WebView webView, ApplicationWebView applicationWebView, CustomChromeClient customChromeClient)
    {
        this.ctx=ctx;
        this.webView=webView;
        this.applicationWebView=applicationWebView;
        this.customChromeClient=customChromeClient;
        initializePinePGWebView();
    }
    @Override
    public void startWebService(String url) {
        baseUrl=url;
        webView.loadUrl(baseUrl);
    }

    @Override
    public void initializePinePGWebView() {
        webView.setWebViewClient(applicationWebView);
        webView.setWebChromeClient(customChromeClient);
        webView.getSettings().setUseWideViewPort(true);
        webView.clearCache(true);
        webView.requestFocusFromTouch();
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.requestFocus();
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        //webView.addJavascriptInterface(objPinePGJavaScriptInterface,"AndroidInterface");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                try {
                    Intent i = new Intent();
                    i.setPackage("com.android.chrome");
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    CustomWebView.this.startActivity(i);
                } catch (Exception e) {
                    Log.e(TAG, "Received an Exception", e);
                }
            }
        });
    }
}
