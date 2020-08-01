package com.example.myapplication.utilities.Concrete;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.example.myapplication.R;
import com.example.myapplication.utilities.Abstract.IApplicationProgressBarUtils;

import java.util.Objects;

public class ApplicationProgressBarUtils implements IApplicationProgressBarUtils {
    Dialog getApplicationWebViewLoader;
    public ApplicationProgressBarUtils()
    {

    }

    @Override
    public Dialog getApplicationWebViewLoader(Context context) {
        Dialog progressDialogue = new Dialog(context);
        progressDialogue.setCanceledOnTouchOutside(false);
        progressDialogue.setCancelable(false);
        progressDialogue.setContentView(R.layout.app_loader);
        Objects.requireNonNull(progressDialogue.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return progressDialogue;
    }
}
