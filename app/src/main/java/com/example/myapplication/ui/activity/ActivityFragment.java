package com.example.myapplication.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.myapplication.constants.ConfigConstants;
import com.example.myapplication.ui.home.HomeFragment;

import static android.content.Context.MODE_PRIVATE;

public class ActivityFragment extends HomeFragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=  super.onCreateView(inflater,container,savedInstanceState);
        if(getIsInstructorAccount()){
            webView.loadUrl(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_INSTRUCTOR_ACTIVITY);
        }
        else {
            webView.loadUrl(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_STUDENT_ACTIVITY);
        }
        return view;
    }

}
