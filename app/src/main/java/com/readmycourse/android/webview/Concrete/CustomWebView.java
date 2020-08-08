package com.readmycourse.android.webview.Concrete;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.RequiresApi;


import com.readmycourse.android.MainActivity;
import com.readmycourse.android.R;
import com.readmycourse.android.ui.home.HomeFragment;
import com.readmycourse.android.webview.Abstract.ICustomChromeClient;
import com.readmycourse.android.webview.Abstract.ICustomWebView;

import java.util.Objects;

public class CustomWebView extends HomeFragment implements ICustomWebView {
    private static final String TAG  ="CustomWebView" ;
    private Context ctx;
    private WebView webView;
    private ApplicationWebView applicationWebView;
    private ApplicationChromeClient applicationChromeClient;
    private String baseUrl;
    public  CustomWebView(Context ctx, WebView webView, ApplicationWebView applicationWebView)
    {
        this.ctx=ctx;
        this.webView=webView;
        this.applicationWebView=applicationWebView;
        this.applicationChromeClient =new ApplicationChromeClient(ctx);
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
        webView.setWebChromeClient(applicationChromeClient);
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
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
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
    public class ApplicationChromeClient extends WebChromeClient implements ICustomChromeClient {
        private Dialog progressDialogue =null;
        private static final String TAG="CustomChromeClient";
        private Context context;
        public ApplicationChromeClient(Context context)
        {
            this.context=context;
            initializePinePGLoader();
        }
        protected void openFileChooser(ValueCallback uploadMsg, String acceptType)
        {
            mUploadMessage = uploadMsg;
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            CustomWebView.this.startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);
        }


        // For Lollipop 5.0+ Devices
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams)
        {
            if (uploadMessage != null) {
                uploadMessage.onReceiveValue(null);
                uploadMessage = null;
            }

            uploadMessage = filePathCallback;

            Intent intent = fileChooserParams.createIntent();
            try
            {
                CustomWebView.this.startActivityForResult(intent, FILECHOOSER_RESULTCODE);
            } catch (ActivityNotFoundException e)
            {
                mUploadMessage = null;
                return false;
            }
            return true;
        }

        //For Android 4.1 only
        protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture)
        {
            mUploadMessage = uploadMsg;
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            CustomWebView.this.startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);
        }

        protected void openFileChooser(ValueCallback<Uri> uploadMsg)
        {
            mUploadMessage = uploadMsg;
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            CustomWebView.this.startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
        }


        @Override
        public boolean onCreateWindow(WebView view, boolean dialog, boolean userGesture, Message resultMsg) {
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            resultMsg.sendToTarget();
            view.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return true;
                }
            });
            return true;
        }
        @Override
        public  void onProgressChanged(WebView view, int newProgress) {
            try {
                progressDialogue.show();
                if(newProgress>75)
                {
                    progressDialogue.dismiss();
                    view.setVisibility(View.VISIBLE);
                }

            } catch (Exception e) {
                Log.e(TAG,"An error has occurred"+e.getMessage(),e);
            }
        }
        private void initializePinePGLoader() {
            if(progressDialogue ==null) {
                {
                    progressDialogue = new Dialog(context);
                    progressDialogue.setCanceledOnTouchOutside(false);
                    progressDialogue.setCancelable(false);
                    progressDialogue.setContentView(R.layout.app_loader);
                    Objects.requireNonNull(progressDialogue.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
            }
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            if (requestCode == FILECHOOSER_RESULTCODE)
            {
                if (uploadMessage == null)
                    return;
                uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, intent));
                uploadMessage = null;
            }
        }
        else if (requestCode == FILECHOOSER_RESULTCODE)
        {
            if (null == mUploadMessage)
                return;
            // Use MainActivity.RESULT_OK if you're implementing WebView inside Fragment
            // Use RESULT_OK only if you're implementing WebView inside an Activity
            Uri result = intent == null || resultCode != MainActivity.RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        }
        else
            Toast.makeText(ctx, "Failed to Upload Image", Toast.LENGTH_LONG).show();
    }
    private final static int FILECHOOSER_RESULTCODE=1;
    private ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> uploadMessage;
}
