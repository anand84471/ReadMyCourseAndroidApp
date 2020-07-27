package com.example.myapplication.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.DI.Concrete.ServiceLocator;
import com.example.myapplication.R;
import com.example.myapplication.constants.ConfigConstants;
import com.example.myapplication.webview.Concrete.ApplicationWebView;
import com.example.myapplication.webview.Concrete.CustomChromeClient;
import com.example.myapplication.webview.Concrete.CustomWebView;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        webView=root.findViewById(R.id.wvHome);
        if(webView!=null)
        {
            ApplicationWebView applicationWebView= (ApplicationWebView)ServiceLocator.getInstance().getApplicationWebView(getContext());
            CustomChromeClient customChromeClient=(CustomChromeClient)ServiceLocator.getInstance().getCustomChromeClient(getContext());
            CustomWebView customWebView=new CustomWebView(getContext(),webView,applicationWebView,customChromeClient);
            if(getIsInstructorAccount()){
                customWebView.startWebService(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_INSTRUCTOR);
            }
            else {
                customWebView.startWebService(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_STUDENT);
            }

        }
        return root;
    }
    private boolean getIsInstructorAccount() {
        SharedPreferences pref =  Objects.requireNonNull(getContext()).getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isUserTypeSelected",false);
        return  isIntroActivityOpnendBefore;
    }
}
