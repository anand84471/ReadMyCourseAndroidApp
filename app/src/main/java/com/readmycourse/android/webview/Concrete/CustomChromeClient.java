package com.readmycourse.android.webview.Concrete;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.readmycourse.android.R;
import com.readmycourse.android.webview.Abstract.ICustomChromeClient;

import java.util.Objects;

public class CustomChromeClient extends WebChromeClient implements ICustomChromeClient {
    private Dialog progressDialogue =null;
    private static final String TAG="CustomChromeClient";
    private Context context;
    public CustomChromeClient(Context context)
    {
        this.context=context;
        initializePinePGLoader();
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
